package org.soundhaven.keyboard.controls;
import java.io.IOException;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Patch;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

import org.soundhaven.keyboard.constants.Constants;
public class DefaultControls{
    Synthesizer synth;
    Instrument[] instrument;
    MidiChannel[] channels;
    Patch patch;
    Sequence sequence;
    Sequencer sequencer;
    int selected_instrument,
        type,
        low,
        high;
    
    public DefaultControls() throws MidiUnavailableException, InvalidMidiDataException, IOException{
        this.synth=MidiSystem.getSynthesizer();
        synth.open();
        synth.loadAllInstruments(
                MidiSystem.getSoundbank(
                    getClass().getResourceAsStream("soundbank.gm")));
        
        this.instrument=synth.getAvailableInstruments();
        this.channels=synth.getChannels();
        this.low=0;
        this.high=15;
        
        this.sequencer = MidiSystem.getSequencer();
        this.sequence = new Sequence(Sequence.PPQ, 10);
    }
    
    public void closeSynth(){
        if(synth!=null)
            synth.close();

        if (sequencer != null) 
            sequencer.close();
 
         sequencer=null;
         synth=null;
         channels=null; 
    }
    
    public void decrementInsternment(){
        if(selected_instrument>low)
            --selected_instrument;
        
        patch=instrument[selected_instrument].getPatch();
        channels[0].programChange(patch.getBank(),patch.getProgram()); 
    }
    
    public String getInstrumentName(){
        return instrument[selected_instrument].getName();
    }
    
    public Instrument[] getInstruments(){
        return instrument;
    }
    
    public void incrementInsternment(){
        if(selected_instrument<high)
            ++selected_instrument;
        
        patch=instrument[selected_instrument].getPatch();
        channels[0].programChange(patch.getBank(),patch.getProgram()); 
    }

    public void setInstrument(int instrument_index){
    	patch=instrument[instrument_index].getPatch();
        channels[0].programChange(patch.getBank(),patch.getProgram()); 
    }
    
    public void setModulation(int modulation){
        channels[0].controlChange(Constants.MODULATION,modulation);
    }
    
    public void setPan(int pan){
        channels[0].controlChange(Constants.PAN,pan);
    }

    public void setPitchBend(int pitchbend){
        if(pitchbend>0) channels[0].setPitchBend(pitchbend);
    }
    
    public void setRange(int low, int high){
        this.low=low;
        this.high=high;
        this.selected_instrument=low;
        patch=instrument[selected_instrument].getPatch();
        channels[0].programChange(patch.getBank(),patch.getProgram()); 
    }
    
    public void setReverb(int reverb){
        channels[0].controlChange(Constants.REVERB,reverb);
    }

    public void setSustain(int sustain){
        channels[0].controlChange(Constants.SUSTAIN,sustain);
    }
    
    public void setVolume(int volume){
        channels[0].controlChange(Constants.VOLUME,volume);
    }
    
    public void startNote(int note){
        channels[0].noteOn(note,127);
    }
    
    public void stopNote(int note){
        channels[0].noteOff(note);
    }
}