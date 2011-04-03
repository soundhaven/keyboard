package org.soundhaven.keyboard.controls;

import javax.sound.midi.Instrument;

public interface Controls {

	public void closeSynth();
    
    public void decrementInstrument();
    
    public String getInstrumentName();
    
    public Instrument[] getInstruments();
    
    public void incrementInstrument();
    
    public void setInstrument(int instrument_index);
    
    public void setModulation(int modulation);
    
    public void setPan(int pan);

    public void setPitchBend(int pitchbend);
    
    public void setRange(int low, int high);
    
    public void setReverb(int reverb);

    public void setSustain(int sustain);
    
    public void setVolume(int volume);
    
    public void startNote(int note);
    
    public void stopNote(int note);

}
