package org.soundhaven.keyboard.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JDialog;
import javax.swing.JFrame;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.controls.DefaultControls;
import org.soundhaven.keyboard.controls.KeyboardContext;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseListener;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseMotionListener;
import org.soundhaven.keyboard.gui.listeners.KeyboardKeyListener;
public class KeyboardGUI extends JFrame{
	private static final long serialVersionUID = 1L;
    KeyboardContext data;
    
    public KeyboardGUI() throws MidiUnavailableException, InvalidMidiDataException, IOException{
        super(Constants.GUI_NAME);
        this.setResizable(false);
        
        data=new KeyboardContext();
        data.setNotes(new HashMap<Character,Integer>());
        data.setPressed(new HashSet<Character>());
        data.setControls(new DefaultControls());
        data.setKeyboard(new KeyboardPanel(data.getPressed()));
        data.getKeyboard().setInstrumentName(data.getControls().getInstrumentName());
        data.setPitchbend(8192);
        makeGUI();
    }
    
    private void makeGUI() throws MidiUnavailableException, InvalidMidiDataException, IOException{
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.setHelp(new JDialog());
        makeHelp();
        this.setSize(Constants.GUI_SIZE_X,Constants.GUI_SIZE_Y);
        this.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(data.getKeyboard());
        this.addWindowFocusListener(new WindowFocusListener(){
            public void windowGainedFocus(WindowEvent we){
                data.getKeyboard().repaint();
            }

            public void windowLostFocus(WindowEvent we){
                try{
                    for(Character c:data.getPressed())
                        data.getControls().stopNote(data.getNotes().get(c)); 
                                     
                    data.getNotes().clear();
                    data.getPressed().clear();
                    data.getKeyboard().unflagIncDec();
                    data.getKeyboard().repaint();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
        });
        
        ControlsMouseListener cml=new ControlsMouseListener(data);
        ControlsMouseMotionListener cmml=new ControlsMouseMotionListener(data);
        KeyboardKeyListener kkl=new KeyboardKeyListener(data);

        this.addMouseListener(cml);
        this.addMouseMotionListener(cmml);
        this.addKeyListener(kkl);
        
        this.setVisible(true);
        this.setEnabled(true);
    }    
    
    public void makeHelp(){
        data.getHelp().setLayout(new BorderLayout());
        HelpPanel hp=new HelpPanel();
        hp.setPreferredSize(new Dimension(600,266));
        data.getHelp().getContentPane().add(BorderLayout.CENTER,hp);
        data.getHelp().setResizable(false);
        data.getHelp().pack();
    }
  
}