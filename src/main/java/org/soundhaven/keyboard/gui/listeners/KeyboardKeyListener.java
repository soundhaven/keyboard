package org.soundhaven.keyboard.gui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.soundhaven.keyboard.controls.KeyboardContext;
public class KeyboardKeyListener implements KeyListener{
	KeyboardContext keyboardGUI;
	
	public KeyboardKeyListener(KeyboardContext keyboardGUI){
		this.keyboardGUI=keyboardGUI;
	}
	
	public void keyTyped(KeyEvent ke){}

    public void keyPressed(KeyEvent ke){                
        if(!keyboardGUI.getNotes().containsKey(ke.getKeyChar())){
            if(ke.getKeyCode()==32){
                keyboardGUI.getControls().setSustain(127);
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }
            if(ke.getKeyChar()=='z'){
                keyboardGUI.getControls().startNote(52+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('z',52+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }
            else if(ke.getKeyChar()=='s'){
                keyboardGUI.getControls().startNote(53+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('s',53+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='x'){
                keyboardGUI.getControls().startNote(54+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('x',54+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='d'){
                keyboardGUI.getControls().startNote(55+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('d',55+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='c'){
                keyboardGUI.getControls().startNote(56+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('c',56+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='v'){
                keyboardGUI.getControls().startNote(57+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('v',57+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='g'){
                keyboardGUI.getControls().startNote(58+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('g',58+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='b'){
                keyboardGUI.getControls().startNote(59+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('b',59+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='h'){
                keyboardGUI.getControls().startNote(60+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('h',60+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='n'){
                keyboardGUI.getControls().startNote(61+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('n',61+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='j'){
                keyboardGUI.getControls().startNote(62+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('j',62+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='m'){
                keyboardGUI.getControls().startNote(63+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('m',63+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()==','){
                keyboardGUI.getControls().startNote(64+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put(',',64+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='l'){
                keyboardGUI.getControls().startNote(65+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('l',65+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='.'){
                keyboardGUI.getControls().startNote(66+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('.',66+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()==';'){
                keyboardGUI.getControls().startNote(67+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put(';',67+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='/'){
                keyboardGUI.getControls().startNote(68+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('/',68+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='q'){
                keyboardGUI.getControls().startNote(69+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('q',69+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='2'){
                keyboardGUI.getControls().startNote(70+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('2',70+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='w'){
                keyboardGUI.getControls().startNote(71+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('w',71+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='3'){
                keyboardGUI.getControls().startNote(72+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('3',72+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='e'){
                keyboardGUI.getControls().startNote(73+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('e',73+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='4'){
                keyboardGUI.getControls().startNote(74+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('4',74+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='r'){
                keyboardGUI.getControls().startNote(75+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('r',75+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='t'){
                keyboardGUI.getControls().startNote(76+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('t',76+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='6'){
                keyboardGUI.getControls().startNote(77+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('6',77+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='y'){
                keyboardGUI.getControls().startNote(78+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('y',78+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='7'){
                keyboardGUI.getControls().startNote(79+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('7',79+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='u'){
                keyboardGUI.getControls().startNote(80+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('u',80+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='i'){
                keyboardGUI.getControls().startNote(81+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('i',81+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='9'){
                keyboardGUI.getControls().startNote(82+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('9',82+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='o'){
                keyboardGUI.getControls().startNote(83+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('o',83+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='0'){
                keyboardGUI.getControls().startNote(84+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('0',84+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='p'){
                keyboardGUI.getControls().startNote(85+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('p',85+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='-'){
                keyboardGUI.getControls().startNote(86+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('-',86+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }

            else if(ke.getKeyChar()=='['){
                keyboardGUI.getControls().startNote(87+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put('[',87+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }
            else if(ke.getKeyChar()==']'){
                keyboardGUI.getControls().startNote(88+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getNotes().put(']',88+(keyboardGUI.getOctaveShift()*12));
                keyboardGUI.getPressed().add(ke.getKeyChar());
            }
            keyboardGUI.getKeyboard().repaint();
        }
    }

    public void keyReleased(KeyEvent ke){
        try{
            if(ke.getKeyCode()==32){
                keyboardGUI.getControls().setSustain(0);
                keyboardGUI.getPressed().remove(ke.getKeyChar());
            }
            else{
                keyboardGUI.getControls().stopNote(keyboardGUI.getNotes().get(ke.getKeyChar()));              
                keyboardGUI.getNotes().remove(ke.getKeyChar());
                keyboardGUI.getPressed().remove(ke.getKeyChar());
                keyboardGUI.getKeyboard().unflagIncDec();             
                keyboardGUI.getKeyboard().repaint();
            }
        }
        catch(Exception e){}
    }

}
