package org.soundhaven.keyboard.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JDialog;
import javax.swing.JFrame;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.controls.Controls;
import org.soundhaven.keyboard.controls.DefaultControls;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseListener;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseMotionListener;
import org.soundhaven.keyboard.gui.listeners.KeyboardKeyListener;
public class KeyboardGUI extends JFrame{
	private static final long serialVersionUID = 9198738870812142310L;
	Controls controls;
    int key_pressed,
        octave_shift=0,
        bendStartCoordinate,
        pitchbend;
    boolean isBending;
    HashMap<Character,Integer> notes;
    HashSet<Character> pressed;
    JDialog help;
    KeyboardPanel keyboardPanel;
    
    public KeyboardGUI() throws MidiUnavailableException, InvalidMidiDataException, IOException{
        super(Constants.GUI_NAME);
        this.setResizable(false);
        this.notes=new HashMap<Character,Integer>();
        this.pressed=new HashSet<Character>();
        this.controls=new DefaultControls();
        this.keyboardPanel=new KeyboardPanel(pressed);
        keyboardPanel.setInstrumentName(controls.getInstrumentName());
        this.pitchbend=8192;
        makeGUI();
    }
    
    private void makeGUI() throws MidiUnavailableException, InvalidMidiDataException, IOException{
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.help=new JDialog();
        makeHelp();
        this.setSize(Constants.GUI_SIZE_X,Constants.GUI_SIZE_Y);
        this.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(keyboardPanel);
        this.addWindowFocusListener(new WindowFocusListener(){
            public void windowGainedFocus(WindowEvent we){
                keyboardPanel.repaint();
            }

            public void windowLostFocus(WindowEvent we){
                try{
                    for(Character c:pressed)
                        controls.stopNote(notes.get(c)); 
                                     
                    notes.clear();
                    pressed.clear();
                    keyboardPanel.unflagIncDec();
                    keyboardPanel.repaint();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
        });
        
        ControlsMouseListener cml=new ControlsMouseListener(this);
        ControlsMouseMotionListener cmml=new ControlsMouseMotionListener(this);
        KeyboardKeyListener kkl=new KeyboardKeyListener(this);

        this.addMouseListener(cml);
        this.addMouseMotionListener(cmml);
        this.addKeyListener(kkl);
        
        this.setVisible(true);
        this.setEnabled(true);
    }    
    
    public void makeHelp(){
        help.setLayout(new BorderLayout());
        HelpPanel hp=new HelpPanel();
        hp.setPreferredSize(new Dimension(600,266));
        help.getContentPane().add(BorderLayout.CENTER,hp);
        help.setResizable(false);
        help.pack();
    }
    
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
    	this.keyboardPanel=keyboardPanel;
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

    public void decrementOctave(){
    	--octave_shift;
    }
    
    public void incrementOctave(){
    	++octave_shift;
    }
    
    public Map<Character,Integer> getNotes(){
    	return notes;
    }
    
    public Set<Character> getPressed(){
    	return pressed;
    }
    
}