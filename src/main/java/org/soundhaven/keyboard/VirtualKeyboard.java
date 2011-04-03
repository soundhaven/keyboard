package org.soundhaven.keyboard;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.soundhaven.keyboard.gui.KeyboardGUI;

public class VirtualKeyboard{
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    new KeyboardGUI();
                } 
                catch(InvalidMidiDataException ime){
                    ime.printStackTrace();
                } 
                catch(IOException ioe){
                    ioe.printStackTrace();
                } 
                catch(MidiUnavailableException mue){
                    mue.printStackTrace();
                }
            }
        });
    }
}

