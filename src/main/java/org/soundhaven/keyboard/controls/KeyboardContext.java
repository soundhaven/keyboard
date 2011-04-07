package org.soundhaven.keyboard.controls;

import java.util.Map;
import java.util.Set;

import javax.swing.JDialog;

import org.soundhaven.keyboard.gui.KeyboardPanel;

public class KeyboardContext {
	Controls controls;
    int key_pressed,
        octave_shift=0,
        bendStartCoordinate,
        pitchbend;
    boolean isBending;
    Map<Character,Integer> notes;
    Set<Character> pressed;
    JDialog help;
    KeyboardPanel keyboardPanel;

	public Controls getControls(){
    	return controls;
    }
    
    public void setControls(Controls controls){
    	this.controls=controls;
    }
    
    public KeyboardPanel getKeyboard(){
    	return keyboardPanel;
    }
    
    public void setKeyboard(KeyboardPanel keyboard){
    	this.keyboardPanel=keyboard;
    }
    
    public int getKeyPressed(){
    	return key_pressed;
    }
    
    public void setKeyPressed(int key_pressed){
    	this.key_pressed=key_pressed;
    }
    
    public int getOctaveShift(){
    	return octave_shift;
    }
    
    public void setOctaveShift(int octave_shift){
    	this.octave_shift=octave_shift;
    }
    
    public int getBendStartCoordinate(){
    	return bendStartCoordinate;
    }
    
    public void setBendStartCoordinate(int bendStartCoordinate){
    	this.bendStartCoordinate=bendStartCoordinate;
    }
    
    public int getPitchbend(){
    	return pitchbend;
    }

    public void setPitchbend(int pitchbend){
    	this.pitchbend=pitchbend;
    }
    
    public boolean isBending(){
    	return isBending;
    }

    public void setIsBending(boolean isBending){
    	this.isBending=isBending;
    }
    
    public JDialog getHelp(){
    	return help;
    }
    
    public void setHelp(JDialog help){
    	this.help=help;
    }

    public void decrementOctave(){
    	--octave_shift;
    }
    
    public void incrementOctave(){
    	++octave_shift;
    }
    
    public void setNotes(Map<Character,Integer> notes){
    	this.notes=notes;
    }
    
    public Map<Character,Integer> getNotes(){
    	return notes;
    }
    
    public void setPressed(Set<Character> pressed){
    	this.pressed=pressed;
    }
    
    public Set<Character> getPressed(){
    	return pressed;
    }
}
