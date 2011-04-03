package org.soundhaven.keyboard.controls.custom;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.Patch;

import org.soundhaven.keyboard.constants.Constants;
public class CustomControls{
    @SuppressWarnings("unused")
	private MidiChannel[] channels;
    private Instrument[] instrument;
    private Patch patch;
    private HashMap<Integer,CustomPatch> patches;
    private int selected_instrument,
            low,
            high;

    public CustomControls(MidiChannel[] channels, Instrument[] instrument, Patch patch){
        this.channels=channels;
        this.instrument=instrument;
        this.patch=patch;
        this.patches=new HashMap<Integer,CustomPatch>();
				
        HashSet<CustomPatchElement> tmp=new HashSet<CustomPatchElement>();
        tmp.add(new CustomPatchElement(channels[0],1,127));
        tmp.add(new CustomPatchElement(channels[1],20,102));
        tmp.add(new CustomPatchElement(channels[2],70,75));
        
        patches.put(0,new CustomPatch("mine",tmp));
        
        for(CustomPatchElement c: patches.get(0).getPatch()){
            patch=instrument[c.getInstrument()].getPatch();
            c.getChannel().programChange(patch.getBank(),patch.getProgram());
        }
        
        this.selected_instrument=0;
    }

    public void decrementInsternment(){
        if(selected_instrument>low)
            --selected_instrument;
            for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch()){
                patch=instrument[cpatch.getInstrument()].getPatch();
                cpatch.getChannel().programChange(patch.getBank(),patch.getProgram());
            } 
    }
    
    public void inccrementInsternment(){
        if(selected_instrument<high)
            ++selected_instrument;
        
            for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch()){
                patch=instrument[cpatch.getInstrument()].getPatch();
                cpatch.getChannel().programChange(patch.getBank(),patch.getProgram());
            } 
    }
     
    public void setModulation(int modulation){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
            cpatch.getChannel().controlChange(Constants.MODULATION,modulation);
    }
    
    public void setModulation(MidiChannel channel, int modulation){
        channel.controlChange(Constants.MODULATION,modulation);
    }
    
    public void setPan(int pan){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
            cpatch.getChannel().controlChange(Constants.PAN,pan);
    }
    
    public void setPan(MidiChannel channel, int pan){
        channel.controlChange(Constants.PAN,pan);
    }
    
    public void setReverb(int reverb){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
            cpatch.getChannel().controlChange(Constants.REVERB,reverb);
    }
    
    public void setReverb(MidiChannel channel, int reverb){
        channel.controlChange(Constants.REVERB,reverb);
    }
    
    public void setSustain(int sustain){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
            cpatch.getChannel().controlChange(Constants.SUSTAIN,sustain);
    }
    
    public void setSustain(MidiChannel channel, int sustain){
        channel.controlChange(Constants.SUSTAIN,sustain);
    }
    
    public void setVolume(int volume){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
            cpatch.getChannel().controlChange(Constants.VOLUME,volume);
    }
    
    public void setVolume(MidiChannel channel, int volume){
        channel.controlChange(Constants.VOLUME,volume);
    }
    
    public void startCustomNote(int note){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
        	if(cpatch.getRange()[0] <=note && note <= cpatch.getRange()[1])
        		cpatch.getChannel().noteOn(note,cpatch.getVolume());
    }
    
    public void stopCustomNote(int note){
        for(CustomPatchElement cpatch: patches.get(selected_instrument).getPatch())
        	if(cpatch.getRange()[0] <=note && note <= cpatch.getRange()[1])
        		cpatch.getChannel().noteOff(note);
    }
}
