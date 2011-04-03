package org.soundhaven.keyboard.controls.custom;
import javax.sound.midi.MidiChannel;
public class CustomPatchElement{
    private int volume;
    private MidiChannel channel;
    private int instrument;
    private int[] range;
    
    public CustomPatchElement(){}
    
    public CustomPatchElement(MidiChannel channel, int instrument, int volume){
        this.channel=channel;
        this.instrument=instrument;
        this.volume=volume;
    }
    
    public MidiChannel getChannel(){
        return channel;
    }
    
    public int getInstrument(){
        return instrument;
    }
    
    public int[] getRange(){
    	return range;
    }

    public int getVolume(){
        return volume;
    }
    
    public void setChannel(MidiChannel channel){
        this.channel=channel;
    }
    
    public void setInstrument(int instrument){
        this.instrument=instrument;
    }
    
    public void setRange(int low, int high){
    	range[0]=low;
    	range[1]=high;
    }
    
    public void setVolume(int volume){
        this.volume=volume;
    }
}
