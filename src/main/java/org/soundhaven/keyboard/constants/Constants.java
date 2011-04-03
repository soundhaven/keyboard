package org.soundhaven.keyboard.constants;

import java.util.HashMap;

public class Constants{
    //control type
    public static int MODULATION=1;
    public static int PAN=10;
    public static int REVERB=91;
    public static int SUSTAIN=64;
    public static int VOLUME=7;
    
    //control default values
    public static int PITCHBEND=8192;
    public static int BEND_DELTA=100;
    
    //control default y-coordinates
    public static int VOLUME_COORDINATES=20;
    public static int PAN_COORDINATES=50;
    public static int REVERB_COORDINATES=50;
    public static int MODULATION_COORDINATES=100;
    
    //main gui
    public static String GUI_NAME="Virtual Keyboard - soundhaven.org";
    public static int GUI_SIZE_X=968;
    public static int GUI_SIZE_Y=360;
    
    //keys
    public static int KEY_LOCATION_Y=123;
    public static int WHITE_KEY_SIZE_X=40;
    public static int WHITE_KEY_SIZE_Y=200;
    public static int BLACK_KEY_SIZE_X=20;
    public static int BLACK_KEY_SIZE_Y=160;
    public static int KEY_DOWN_X=40;
    public static int KEY_DOWN_Y=6;
    public static int BLACK_KEY_DOWN_Y=319;
    public static int WHITE_KEY_DOWN_Y=280;
    
    private static HashMap<Character,Integer> noteMap=populateNoteMap();
    
    public static int getNote(char note){
    	if(noteMap.containsKey(note))
    		return noteMap.get(note);
    	
    	else return -1;
    }
    
    private static HashMap<Character,Integer> populateNoteMap(){
    	noteMap=new HashMap<Character,Integer>();
    	noteMap.put('z',52);
    	noteMap.put('s',53);
    	noteMap.put('x',54);
    	noteMap.put('d',55);
    	noteMap.put('c',56);
    	noteMap.put('v',57);
    	noteMap.put('g',58);
    	noteMap.put('b',59);
    	noteMap.put('h',60);
    	noteMap.put('n',61);
    	noteMap.put('j',62);
    	noteMap.put('m',63);
    	noteMap.put(',',64);
    	noteMap.put('l',65);
    	noteMap.put('.',66);
    	noteMap.put(';',67);
    	noteMap.put('/',68);
    	noteMap.put('q',69);
    	noteMap.put('2',70);
    	noteMap.put('w',71);
    	noteMap.put('3',72);
    	noteMap.put('e',73);
    	noteMap.put('4',74);
    	noteMap.put('r',75);
    	noteMap.put('t',76);
    	noteMap.put('6',77);
    	noteMap.put('y',78);
    	noteMap.put('7',79);
    	noteMap.put('u',80);
    	noteMap.put('i',81);
    	noteMap.put('9',82);
    	noteMap.put('o',83);
    	noteMap.put('0',84);
    	noteMap.put('p',85);
    	noteMap.put('-',86);
    	noteMap.put('[',87);
    	noteMap.put(']',88);
    	return noteMap;
    }
}
