package org.soundhaven.keyboard.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.gui.KeyboardGUI;

public class ControlsMouseMotionListener implements MouseMotionListener{
	KeyboardGUI keyboardGUI;
	
	public ControlsMouseMotionListener(KeyboardGUI keyboardGUI){
		this.keyboardGUI=keyboardGUI;
	}
	
	public void mouseDragged(MouseEvent me) {
        if(me.getX()>860 && me.getY()>56 && me.getX()<945 && me.getY()<346)
        	keyboardGUI.setIsBending(true);
              
        if(keyboardGUI.isBending()){
            if(me.getY()>keyboardGUI.getBendStartCoordinate())
            	keyboardGUI.setPitchbend(keyboardGUI.getPitchbend()-Constants.BEND_DELTA);

            else if(me.getY()<keyboardGUI.getBendStartCoordinate())
            	keyboardGUI.setPitchbend(keyboardGUI.getPitchbend()+Constants.BEND_DELTA);
          
            keyboardGUI.getControls().setPitchBend(keyboardGUI.getPitchbend());
        	keyboardGUI.getKeyboard().setPitchBend(keyboardGUI.getPitchbend(),keyboardGUI.getBendStartCoordinate());
        	keyboardGUI.setBendStartCoordinate(me.getY());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //volume
        if(me.getX()>=30 && me.getX()<=56 && me.getY()>=48 && me.getY()<=130){
            if(me.getY()<=115 && me.getY()>=108) keyboardGUI.getControls().setVolume(0);
            else if(me.getY()<108 && me.getY()>=101) keyboardGUI.getControls().setVolume(20);
            else if(me.getY()<=101 && me.getY()>=94) keyboardGUI.getControls().setVolume(43);
            else if(me.getY()<=94 && me.getY()>=88) keyboardGUI.getControls().setVolume(55);
            else if(me.getY()<88 && me.getY()>=82) keyboardGUI.getControls().setVolume(67);
            else if(me.getY()<82 && me.getY()>=75) keyboardGUI.getControls().setVolume(79);
            else if(me.getY()<75 && me.getY()>=64) keyboardGUI.getControls().setVolume(91);
            else if(me.getY()<64 && me.getY()>=58) keyboardGUI.getControls().setVolume(103);
            else if(me.getY()<58 && me.getY()>=42) keyboardGUI.getControls().setVolume(115);
            else if(me.getY()<42 && me.getY()>=32) keyboardGUI.getControls().setVolume(127);

            keyboardGUI.getKeyboard().setVolumeCoordinates(me.getY()-30);
            keyboardGUI.getKeyboard().repaint();           
        }
        //reverb
        else if(me.getX()>=90 && me.getX()<=116 && me.getY()>=48 && me.getY()<=130){
            if(me.getY()<=115 && me.getY()>=108) keyboardGUI.getControls().setReverb(0);
            else if(me.getY()<108 && me.getY()>=101) keyboardGUI.getControls().setReverb(20);
            else if(me.getY()<=101 && me.getY()>=94) keyboardGUI.getControls().setReverb(43);
            else if(me.getY()<=94 && me.getY()>=88) keyboardGUI.getControls().setReverb(55);
            else if(me.getY()<88 && me.getY()>=82) keyboardGUI.getControls().setReverb(67);
            else if(me.getY()<82 && me.getY()>=75) keyboardGUI.getControls().setReverb(79);
            else if(me.getY()<75 && me.getY()>=64) keyboardGUI.getControls().setReverb(91);
            else if(me.getY()<64 && me.getY()>=58) keyboardGUI.getControls().setReverb(103);
            else if(me.getY()<58 && me.getY()>=42) keyboardGUI.getControls().setReverb(115);
            else if(me.getY()<42 && me.getY()>=32) keyboardGUI.getControls().setReverb(127);

            keyboardGUI.getKeyboard().setReverbCoordinates(me.getY()-30);
            keyboardGUI.getKeyboard().repaint();           
        }
        //pan
        else if(me.getX()>=150 && me.getX()<=176 && me.getY()>=48 && me.getY()<=130){
            if(me.getY()<=115 && me.getY()>=108) keyboardGUI.getControls().setPan(0);
            else if(me.getY()<108 && me.getY()>=101) keyboardGUI.getControls().setPan(20);
            else if(me.getY()<=101 && me.getY()>=94) keyboardGUI.getControls().setPan(43);
            else if(me.getY()<=94 && me.getY()>=88) keyboardGUI.getControls().setPan(55);
            else if(me.getY()<88 && me.getY()>=82) keyboardGUI.getControls().setPan(67);
            else if(me.getY()<82 && me.getY()>=75) keyboardGUI.getControls().setPan(79);
            else if(me.getY()<75 && me.getY()>=64) keyboardGUI.getControls().setPan(91);
            else if(me.getY()<64 && me.getY()>=58) keyboardGUI.getControls().setPan(103);
            else if(me.getY()<58 && me.getY()>=42) keyboardGUI.getControls().setPan(115);
            else if(me.getY()<42 && me.getY()>=32) keyboardGUI.getControls().setPan(127);

            keyboardGUI.getKeyboard().setPanCoordinates(me.getY()-30);
            keyboardGUI.getKeyboard().repaint();
        }
        //modulation
        else if(me.getX()>=210 && me.getX()<=236 && me.getY()>=48 && me.getY()<=130){
            if(me.getY()<=115 && me.getY()>=108) keyboardGUI.getControls().setModulation(0);
            else if(me.getY()<108 && me.getY()>=101) keyboardGUI.getControls().setModulation(20);
            else if(me.getY()<=101 && me.getY()>=94) keyboardGUI.getControls().setModulation(43);
            else if(me.getY()<=94 && me.getY()>=88) keyboardGUI.getControls().setModulation(55);
            else if(me.getY()<88 && me.getY()>=82) keyboardGUI.getControls().setModulation(67);
            else if(me.getY()<82 && me.getY()>=75) keyboardGUI.getControls().setModulation(79);
            else if(me.getY()<75 && me.getY()>=64) keyboardGUI.getControls().setModulation(91);
            else if(me.getY()<64 && me.getY()>=58) keyboardGUI.getControls().setModulation(103);
            else if(me.getY()<58 && me.getY()>=42) keyboardGUI.getControls().setModulation(115);
            else if(me.getY()<42 && me.getY()>=32) keyboardGUI.getControls().setModulation(127);

            keyboardGUI.getKeyboard().setModulationCoordinates(me.getY()-30);
            keyboardGUI.getKeyboard().repaint(); 
        }
    }

    public void mouseMoved(MouseEvent arg0) {}
}
