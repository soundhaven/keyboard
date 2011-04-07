package org.soundhaven.keyboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.controls.DefaultControls;
import org.soundhaven.keyboard.controls.KeyboardContext;
import org.soundhaven.keyboard.gui.HelpPanel;
import org.soundhaven.keyboard.gui.KeyboardPanel;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseListener;
import org.soundhaven.keyboard.gui.listeners.ControlsMouseMotionListener;
import org.soundhaven.keyboard.gui.listeners.KeyboardKeyListener;

public class KeyboardApplet extends JApplet{
	private static final long serialVersionUID = 1L;
	KeyboardContext data;

	@Override
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					try{
						makeApplet();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		catch(Exception e){
			System.err.println("oops...     sorry I guess there was a problem loading this app");
		}
	}
	
	public void makeApplet() throws MidiUnavailableException, InvalidMidiDataException, IOException{
		data=new KeyboardContext();
        data.setNotes(new HashMap<Character,Integer>());
        data.setPressed(new HashSet<Character>());
        data.setControls(new DefaultControls());
        data.setKeyboard(new KeyboardPanel(data.getPressed()));
        data.getKeyboard().setInstrumentName(data.getControls().getInstrumentName());
        data.setPitchbend(8192);
		this.setName(Constants.GUI_NAME);
		data.setHelp(new JDialog());
        makeHelp();
        this.setSize(Constants.GUI_SIZE_X,Constants.GUI_SIZE_Y);
        this.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(data.getKeyboard());
        this.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent fe){
				data.getKeyboard().repaint();				
			}

			@Override
			public void focusLost(FocusEvent fe){
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
