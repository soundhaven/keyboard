package org.soundhaven.keyboard.gui.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.controls.KeyboardContext;

public class ControlsMouseListener implements MouseListener{
	KeyboardContext keyboardGUI;
	
	public ControlsMouseListener(KeyboardContext keyboardGUI){
		this.keyboardGUI=keyboardGUI;
	}

	public void mouseClicked(MouseEvent me){}

    public void mousePressed(MouseEvent me){
        //pitchbend
        if(me.getX()>860 && me.getY()>56 && me.getX()<945 && me.getY()<346){
        		keyboardGUI.getKeyboard().setPitchAsBending(true,me.getY());
        		keyboardGUI.setBendStartCoordinate(me.getY());
        }
        
        if(me.getY()>=120 && me.getY()<=140){
            //decrement instrument
            if(me.getX()>=477 && me.getX()<=500){
            	keyboardGUI.getControls().decrementInstrument();
            	keyboardGUI.getKeyboard().flagDec();
            	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
            }
            //increment instrument
            else if(me.getX()>=607 && me.getX()<=628){
            	keyboardGUI.getControls().incrementInstrument();
            	keyboardGUI.getKeyboard().flagInc();
            	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
            }
            //decrement octave
            else if(me.getX()>=340 && me.getX()<=383){
            	keyboardGUI.getKeyboard().octaveDown();
            	keyboardGUI.decrementOctave();
            }
                
            //increment instrument
            else if(me.getX()>=404 && me.getX()<=426){
            	keyboardGUI.getKeyboard().octaveUp();
            	keyboardGUI.incrementOctave();
            }
            keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: piano
        if(me.getX()>=668 && me.getX()<=718 && me.getY()<=50 && me.getY()>=30){
        	keyboardGUI.getControls().setRange(0,15);
        	keyboardGUI.getKeyboard().changeType(0);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: organ
        else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=50 && me.getY()>=30){
        	keyboardGUI.getControls().setRange(16,23);
        	keyboardGUI.getKeyboard().changeType(1);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: guitar
        else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=50 && me.getY()>=30){
        	keyboardGUI.getControls().setRange(24,31);
        	keyboardGUI.getKeyboard().changeType(2);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: bass
        else if(me.getX()>=668 && me.getX()<=718 && me.getY()<=80 && me.getY()>=60){
        	keyboardGUI.getControls().setRange(32,39);
        	keyboardGUI.getKeyboard().changeType(3);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: strings
        else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=80 && me.getY()>=60){
        	keyboardGUI.getControls().setRange(40,55);
        	keyboardGUI.getKeyboard().changeType(4);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: wind
        else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=80 && me.getY()>=60){
        	keyboardGUI.getControls().setRange(56,79);
        	keyboardGUI.getKeyboard().changeType(5);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: synth
        else if(me.getX()>=668 && me.getX()<=718 && me.getY()<=110 && me.getY()>=90){
        	keyboardGUI.getControls().setRange(80,111);
        	keyboardGUI.getKeyboard().changeType(6);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: effects
        else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=110 && me.getY()>=90){
        	keyboardGUI.getControls().setRange(120,127);
        	keyboardGUI.getKeyboard().changeType(7);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        
        //change patch type: drums
        else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=110 && me.getY()>=90){
        	keyboardGUI.getControls().setRange(112,119);
        	keyboardGUI.getKeyboard().changeType(8);
        	keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
        	keyboardGUI.getKeyboard().repaint();
        }
        //help
        else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=140 && me.getY()>=120){
        	keyboardGUI.getHelp().setVisible(true);
            keyboardGUI.getKeyboard().changeType(9);
            keyboardGUI.getKeyboard().setInstrumentName(keyboardGUI.getControls().getInstrumentName());
            keyboardGUI.getKeyboard().repaint();
        } 
    }

    public void mouseReleased(MouseEvent me){
    	keyboardGUI.getKeyboard().unflagIncDec();
    	keyboardGUI.getKeyboard().unFlagOct();
    	keyboardGUI.getKeyboard().unFlagChangeType();
    	keyboardGUI.getKeyboard().setPitchAsBending(false);
    	keyboardGUI.getKeyboard().setPitchBend(Constants.PITCHBEND,0);
        keyboardGUI.getControls().setPitchBend(Constants.PITCHBEND);
        keyboardGUI.setPitchbend(Constants.PITCHBEND);
        keyboardGUI.setIsBending(false);
        keyboardGUI.getKeyboard().repaint();
    }

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}
 
}
