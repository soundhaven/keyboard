package org.soundhaven.keyboard.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import org.soundhaven.keyboard.constants.Constants;
import org.soundhaven.keyboard.controls.DefaultControls;
public class KeyboardGUI extends JFrame{
	private static final long serialVersionUID = 9198738870812142310L;
	DefaultControls controls;
    int key_pressed,
        mouse_pressed,
        octave_shift=0,
        tmp_volume=127,
        bendStartCoordinate,
        pitchbend;
    boolean isBending;
    HashMap<Character,Integer> notes;
    HashSet<Character> pressed;
    JDialog help;
    KeyboardPanel keyboardPanel;
    JTextField location;
    DefaultMutableTreeNode patches;
    DefaultMutableTreeNode nodeToAdd;
    
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
        this.addMouseMotionListener(new MouseMotionListener(){
            public void mouseDragged(MouseEvent me) {
                if(me.getX()>860 && me.getY()>56 && me.getX()<945 && me.getY()<346)
                    isBending=true;
                      
                if(isBending){
                    if(me.getY()>bendStartCoordinate){
                        pitchbend=pitchbend-Constants.BEND_DELTA;
                        controls.setPitchBend(pitchbend);
                        keyboardPanel.setPitchBend(pitchbend,bendStartCoordinate);
                    }

                    else if(me.getY()<bendStartCoordinate){
                        pitchbend=pitchbend+Constants.BEND_DELTA;
                        controls.setPitchBend(pitchbend);
                        keyboardPanel.setPitchBend(pitchbend,bendStartCoordinate);
                    }
                    bendStartCoordinate=me.getY();
                    keyboardPanel.repaint();   
                }
                
                if(me.getX()>=30 && me.getX()<=56 && me.getY()>=48 && me.getY()<=130){
                    if(me.getY()<=115 && me.getY()>=108) controls.setVolume(0);
                    else if(me.getY()<108 && me.getY()>=101) controls.setVolume(20);
                    else if(me.getY()<=101 && me.getY()>=94) controls.setVolume(43);
                    else if(me.getY()<=94 && me.getY()>=88) controls.setVolume(55);
                    else if(me.getY()<88 && me.getY()>=82) controls.setVolume(67);
                    else if(me.getY()<82 && me.getY()>=75) controls.setVolume(79);
                    else if(me.getY()<75 && me.getY()>=64) controls.setVolume(91);
                    else if(me.getY()<64 && me.getY()>=58) controls.setVolume(103);
                    else if(me.getY()<58 && me.getY()>=42) controls.setVolume(115);
                    else if(me.getY()<42 && me.getY()>=32) controls.setVolume(127);

                    keyboardPanel.setVolumeCoordinates(me.getY()-30);
                    keyboardPanel.repaint();           
                }
                else if(me.getX()>=90 && me.getX()<=116 && me.getY()>=48 && me.getY()<=130){
                    if(me.getY()<=115 && me.getY()>=108) controls.setReverb(0);
                    else if(me.getY()<108 && me.getY()>=101) controls.setReverb(20);
                    else if(me.getY()<=101 && me.getY()>=94) controls.setReverb(43);
                    else if(me.getY()<=94 && me.getY()>=88) controls.setReverb(55);
                    else if(me.getY()<88 && me.getY()>=82) controls.setReverb(67);
                    else if(me.getY()<82 && me.getY()>=75) controls.setReverb(79);
                    else if(me.getY()<75 && me.getY()>=64) controls.setReverb(91);
                    else if(me.getY()<64 && me.getY()>=58) controls.setReverb(103);
                    else if(me.getY()<58 && me.getY()>=42) controls.setReverb(115);
                    else if(me.getY()<42 && me.getY()>=32) controls.setReverb(127);

                    keyboardPanel.setReverbCoordinates(me.getY()-30);
                    keyboardPanel.repaint();           
                }
            
                else if(me.getX()>=150 && me.getX()<=176 && me.getY()>=48 && me.getY()<=130){
                    if(me.getY()<=115 && me.getY()>=108) controls.setPan(0);
                    else if(me.getY()<108 && me.getY()>=101) controls.setPan(20);
                    else if(me.getY()<=101 && me.getY()>=94) controls.setPan(43);
                    else if(me.getY()<=94 && me.getY()>=88) controls.setPan(55);
                    else if(me.getY()<88 && me.getY()>=82) controls.setPan(67);
                    else if(me.getY()<82 && me.getY()>=75) controls.setPan(79);
                    else if(me.getY()<75 && me.getY()>=64) controls.setPan(91);
                    else if(me.getY()<64 && me.getY()>=58) controls.setPan(103);
                    else if(me.getY()<58 && me.getY()>=42) controls.setPan(115);
                    else if(me.getY()<42 && me.getY()>=32) controls.setPan(127);

                    keyboardPanel.setPanCoordinates(me.getY()-30);
                    keyboardPanel.repaint();
                }

                else if(me.getX()>=210 && me.getX()<=236 && me.getY()>=48 && me.getY()<=130){
                    if(me.getY()<=115 && me.getY()>=108) controls.setModulation(0);
                    else if(me.getY()<108 && me.getY()>=101) controls.setModulation(20);
                    else if(me.getY()<=101 && me.getY()>=94) controls.setModulation(43);
                    else if(me.getY()<=94 && me.getY()>=88) controls.setModulation(55);
                    else if(me.getY()<88 && me.getY()>=82) controls.setModulation(67);
                    else if(me.getY()<82 && me.getY()>=75) controls.setModulation(79);
                    else if(me.getY()<75 && me.getY()>=64) controls.setModulation(91);
                    else if(me.getY()<64 && me.getY()>=58) controls.setModulation(103);
                    else if(me.getY()<58 && me.getY()>=42) controls.setModulation(115);
                    else if(me.getY()<42 && me.getY()>=32) controls.setModulation(127);

                    keyboardPanel.setModulationCoordinates(me.getY()-30);
                    keyboardPanel.repaint(); 
                }
            }

            public void mouseMoved(MouseEvent arg0) {}
        });
        this.addMouseListener(new MouseListener(){
        public void mouseClicked(MouseEvent me){}

        public void mousePressed(MouseEvent me){
            //pitchbend
            if(me.getX()>860 && me.getY()>56 && me.getX()<945 && me.getY()<346){
                    keyboardPanel.setPitchAsBending(true,me.getY());
                    bendStartCoordinate=me.getY();
            }
            
            if(me.getY()>=120 && me.getY()<=140){
                //decrement instrument
                if(me.getX()>=477 && me.getX()<=500){
                    controls.decrementInsternment();
                    keyboardPanel.flagDec();
                    keyboardPanel.setInstrumentName(controls.getInstrumentName());
                }
                //increment instrument
                else if(me.getX()>=607 && me.getX()<=628){
                    controls.incrementInsternment();
                    keyboardPanel.flagInc();
                    keyboardPanel.setInstrumentName(controls.getInstrumentName());
                }
                //decrement octave
                else if(me.getX()>=340 && me.getX()<=383){
                    keyboardPanel.octaveDown();
                    --octave_shift;
                }
                    
                //increment instrument
                else if(me.getX()>=404 && me.getX()<=426){
                    keyboardPanel.octaveUp();
                    ++octave_shift;
                }
                keyboardPanel.repaint();
            }
            
            //change patch type: piano
            if(me.getX()>=668 && me.getX()<=718 && me.getY()<=50 && me.getY()>=30){
                controls.setRange(0,15);
                keyboardPanel.changeType(0);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: organ
            else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=50 && me.getY()>=30){
                controls.setRange(16,23);
                keyboardPanel.changeType(1);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: guitar
            else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=50 && me.getY()>=30){
                controls.setRange(24,31);
                keyboardPanel.changeType(2);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: bass
            else if(me.getX()>=668 && me.getX()<=718 && me.getY()<=80 && me.getY()>=60){
                controls.setRange(32,39);
                keyboardPanel.changeType(3);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: strings
            else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=80 && me.getY()>=60){
                controls.setRange(40,55);
                keyboardPanel.changeType(4);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: wind
            else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=80 && me.getY()>=60){
                controls.setRange(56,79);
                keyboardPanel.changeType(5);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: synth
            else if(me.getX()>=668 && me.getX()<=718 && me.getY()<=110 && me.getY()>=90){
                controls.setRange(80,111);
                keyboardPanel.changeType(6);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: effects
            else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=110 && me.getY()>=90){
                controls.setRange(120,127);
                keyboardPanel.changeType(7);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            
            //change patch type: drums
            else if(me.getX()>=788 && me.getX()<=838 && me.getY()<=110 && me.getY()>=90){
                controls.setRange(112,119);
                keyboardPanel.changeType(8);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            }
            //help
            else if(me.getX()>=728 && me.getX()<=778 && me.getY()<=140 && me.getY()>=120){
                help.setVisible(true);
                keyboardPanel.changeType(9);
                keyboardPanel.setInstrumentName(controls.getInstrumentName());
                keyboardPanel.repaint();
            } 
        }

        public void mouseReleased(MouseEvent me){
            keyboardPanel.unflagIncDec();
            keyboardPanel.unFlagOct();
            keyboardPanel.unFlagChangeType();
            keyboardPanel.setPitchAsBending(false);
            keyboardPanel.setPitchBend(Constants.PITCHBEND,0);
            controls.setPitchBend(Constants.PITCHBEND);
            pitchbend=Constants.PITCHBEND;
            isBending=false;
            keyboardPanel.repaint();
        }

        public void mouseEntered(MouseEvent arg0) {}

        public void mouseExited(MouseEvent arg0) {}
        });
        this.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent ke){}

            public void keyPressed(KeyEvent ke){                
                if(!notes.containsKey(ke.getKeyChar())){
                    if(ke.getKeyCode()==32){
                        controls.setSustain(127);
                        pressed.add(ke.getKeyChar());
                    }
                    if(ke.getKeyChar()=='z'){
                        controls.startNote(52+(octave_shift*12));
                        notes.put('z',52+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }
                    else if(ke.getKeyChar()=='s'){
                        controls.startNote(53+(octave_shift*12));
                        notes.put('s',53+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='x'){
                        controls.startNote(54+(octave_shift*12));
                        notes.put('x',54+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='d'){
                        controls.startNote(55+(octave_shift*12));
                        notes.put('d',55+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='c'){
                        controls.startNote(56+(octave_shift*12));
                        notes.put('c',56+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='v'){
                        controls.startNote(57+(octave_shift*12));
                        notes.put('v',57+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='g'){
                        controls.startNote(58+(octave_shift*12));
                        notes.put('g',58+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='b'){
                        controls.startNote(59+(octave_shift*12));
                        notes.put('b',59+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='h'){
                        controls.startNote(60+(octave_shift*12));
                        notes.put('h',60+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='n'){
                        controls.startNote(61+(octave_shift*12));
                        notes.put('n',61+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='j'){
                        controls.startNote(62+(octave_shift*12));
                        notes.put('j',62+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='m'){
                        controls.startNote(63+(octave_shift*12));
                        notes.put('m',63+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()==','){
                        controls.startNote(64+(octave_shift*12));
                        notes.put(',',64+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='l'){
                        controls.startNote(65+(octave_shift*12));
                        notes.put('l',65+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='.'){
                        controls.startNote(66+(octave_shift*12));
                        notes.put('.',66+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()==';'){
                        controls.startNote(67+(octave_shift*12));
                        notes.put(';',67+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='/'){
                        controls.startNote(68+(octave_shift*12));
                        notes.put('/',68+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='q'){
                        controls.startNote(69+(octave_shift*12));
                        notes.put('q',69+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='2'){
                        controls.startNote(70+(octave_shift*12));
                        notes.put('2',70+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='w'){
                        controls.startNote(71+(octave_shift*12));
                        notes.put('w',71+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='3'){
                        controls.startNote(72+(octave_shift*12));
                        notes.put('3',72+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='e'){
                        controls.startNote(73+(octave_shift*12));
                        notes.put('e',73+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='4'){
                        controls.startNote(74+(octave_shift*12));
                        notes.put('4',74+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='r'){
                        controls.startNote(75+(octave_shift*12));
                        notes.put('r',75+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='t'){
                        controls.startNote(76+(octave_shift*12));
                        notes.put('t',76+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='6'){
                        controls.startNote(77+(octave_shift*12));
                        notes.put('6',77+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='y'){
                        controls.startNote(78+(octave_shift*12));
                        notes.put('y',78+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='7'){
                        controls.startNote(79+(octave_shift*12));
                        notes.put('7',79+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='u'){
                        controls.startNote(80+(octave_shift*12));
                        notes.put('u',80+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='i'){
                        controls.startNote(81+(octave_shift*12));
                        notes.put('i',81+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='9'){
                        controls.startNote(82+(octave_shift*12));
                        notes.put('9',82+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='o'){
                        controls.startNote(83+(octave_shift*12));
                        notes.put('o',83+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='0'){
                        controls.startNote(84+(octave_shift*12));
                        notes.put('0',84+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='p'){
                        controls.startNote(85+(octave_shift*12));
                        notes.put('p',85+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='-'){
                        controls.startNote(86+(octave_shift*12));
                        notes.put('-',86+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }

                    else if(ke.getKeyChar()=='['){
                        controls.startNote(87+(octave_shift*12));
                        notes.put('[',87+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }
                    else if(ke.getKeyChar()==']'){
                        controls.startNote(88+(octave_shift*12));
                        notes.put(']',88+(octave_shift*12));
                        pressed.add(ke.getKeyChar());
                    }
                    repaint();
                }
            }
      
            public void keyReleased(KeyEvent ke){
                try{
                    if(ke.getKeyCode()==32){
                        controls.setSustain(0);
                        pressed.remove(ke.getKeyChar());
                    }
                    else{
                        controls.stopNote(notes.get(ke.getKeyChar()));              
                        notes.remove(ke.getKeyChar());
                        pressed.remove(ke.getKeyChar());
                        keyboardPanel.unflagIncDec();             
                        keyboardPanel.repaint();
                    }
                }
                catch(Exception e){}
            }
        });
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

}