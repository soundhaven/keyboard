package org.soundhaven.keyboard.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import javax.swing.JPanel;

import org.soundhaven.keyboard.constants.Constants;
public class KeyboardPanel extends JPanel{
	private static final long serialVersionUID = -6223275104069034226L;
	private int type,
        bendStartCoordinate,
        bendYCoordinate;
    private int volume_coordinates,
        pan_coordinates,
        reverb_coordinates,
        modulation_coordinates;
    private boolean decrement,
            increment,
            oct_down,
            oct_up,
            change_type,
            bending;
    private String instrument;
    private Set<Character> pressed;
    
    public KeyboardPanel(Set<Character> pressed){
        super();
        this.pressed=pressed;
        this.volume_coordinates=Constants.VOLUME_COORDINATES;
        this.pan_coordinates=Constants.PAN_COORDINATES;
        this.reverb_coordinates=Constants.REVERB_COORDINATES;
        this.modulation_coordinates=Constants.MODULATION_COORDINATES;
        this.setBackground(Color.DARK_GRAY);
    }
    
    public String getInstrumentName(){
        return instrument;
    }
    
    public void setInstrumentName(String instrument){
        this.instrument=instrument;
    }
    
    public void flagInc(){
        this.increment=true;
    }
    
    public void flagDec(){
        this.decrement=true;
    }
    
    public void unflagIncDec(){
        increment=false;
        decrement=false;
    }
    
    public void unFlagOct(){
        oct_up=false;
        oct_down=false;
    }
    
    public void unFlagChangeType(){
        change_type=false;
    }
    
    public void changeType(int type){
        this.type=type;
        this.change_type=true;
    }
    
    public void octaveDown(){
        oct_down=true;
    }
    
    public void octaveUp(){
        oct_up=true;
    }
    
    public void setModulationCoordinates(int coordinates){
        this.modulation_coordinates=coordinates;
    }
    
     public void setPanCoordinates(int coordinates){
        this.pan_coordinates=coordinates;
    }
     
    public void setPitchAsBending(boolean bent){
        bending=bent;
    }
     
    public void setPitchAsBending(boolean bent, int yStartCoordinate){
        bending=bent;
        this.bendStartCoordinate= yStartCoordinate;
    }
    
    public void setPitchBend(int pitchbend, int yCoordinate){
        if(yCoordinate>54 && yCoordinate<349)
            this.bendYCoordinate=yCoordinate;
    }
    
    public void setReverbCoordinates(int coordinates){
        this.reverb_coordinates=coordinates;
    }
    
    public void setVolumeCoordinates(int coordinates){
        this.volume_coordinates=coordinates;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(6,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(46,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(86,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(126,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(166,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(206,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(246,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(286,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(326,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(366,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(406,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(446,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(486,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(526,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(566,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(606,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(646,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(686,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(726,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(766,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.fillRect(806,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        
        g.setColor(Color.BLACK);
        g.drawRect(6,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(46,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(86,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(126,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(166,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(206,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(246,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(286,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(326,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(366,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(406,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(446,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(486,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(526,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(566,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(606,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(646,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(686,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(726,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(766,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        g.drawRect(806,Constants.KEY_LOCATION_Y,Constants.WHITE_KEY_SIZE_X,Constants.WHITE_KEY_SIZE_Y);
        
        g.fillRect(36,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(76,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(156,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(196,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(236,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(316,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(356,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(436,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(476,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(516,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(596,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(636,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(716,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(756,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        g.fillRect(796,Constants.KEY_LOCATION_Y,Constants.BLACK_KEY_SIZE_X,Constants.BLACK_KEY_SIZE_Y);
        
        for(Character c:pressed){
            if(c=='z'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(6,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='s'){
                g.setColor(Color.WHITE);
                g.fillRect(36,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='x'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(46,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='d'){
                g.setColor(Color.WHITE);
                g.fillRect(76,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='c'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(86,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='v'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(126,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='g'){
                g.setColor(Color.WHITE);
                g.fillRect(156,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='b'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(166,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='h'){
                g.setColor(Color.WHITE);
                g.fillRect(196,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='n'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(206,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='j'){
                g.setColor(Color.WHITE);
                g.fillRect(236,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
             }

            if(c=='m'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(246,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c==','){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(286,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='l'){
                g.setColor(Color.WHITE);
                g.fillRect(316,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='.'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(326,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c==';'){
                g.setColor(Color.WHITE);
                g.fillRect(356,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='/'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(366,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='q'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(406,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='2'){
                g.setColor(Color.WHITE);
                g.fillRect(436,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='w'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(446,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='3'){
                g.setColor(Color.WHITE);
                g.fillRect(476,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='e'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(486,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='4'){
                g.setColor(Color.WHITE);
                g.fillRect(516,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='r'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(526,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='t'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(566,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='6'){
                g.setColor(Color.WHITE);
                g.fillRect(596,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='y'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(606,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='7'){
                g.setColor(Color.WHITE);
                g.fillRect(636,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='u'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(646,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='i'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(686,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='9'){
                g.setColor(Color.WHITE);
                g.fillRect(716,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }
            
            if(c=='o'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(726,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='0'){
                g.setColor(Color.WHITE);
                g.fillRect(756,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='p'){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(766,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='-'){
                g.setColor(Color.WHITE);
                g.fillRect(796,Constants.WHITE_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }

            if(c=='['){
                g.setColor(Color.DARK_GRAY);
                g.fillRect(806,Constants.BLACK_KEY_DOWN_Y,Constants.KEY_DOWN_X,Constants.KEY_DOWN_Y);
            }
        }
        
        g.setColor(Color.BLACK);
        //instrument attributes display location
        g.fillRoundRect(470,30,160,60,10,10);
        g.setFont(g.getFont().deriveFont(0,16));
        g.setColor(Color.RED);
            if(instrument!=null)
                g.drawString(instrument,472,66);
        
        
        g.setFont(g.getFont().deriveFont(0,10));
        g.setColor(Color.WHITE);
        g.drawString("Instruments",521,108);
        g.setColor(Color.BLACK);
        g.fillOval(474,94,20,20);
        g.drawOval(474,94,20,20);
        g.fillOval(604,94,20,20);
        g.drawOval(604,94,20,20);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(20,15,50,100);
        g.fillRect(80,15,110,100);
        g.fillRect(140,15,170,100);
        g.fillRect(200,15,230,100);
        g.setColor(Color.BLACK);
        g.drawLine(40,24,40,104);
        g.drawLine(100,24,100,104);
        g.drawLine(160,24,160,104);
        g.drawLine(220,24,220,104);
        g.drawRoundRect(10,4,244,110,10,10);
        g.fillRect(30,volume_coordinates,20,10);
        g.fillRect(90,reverb_coordinates,20,10);
        g.fillRect(150,pan_coordinates,20,10);
        g.fillRect(210,modulation_coordinates,20,10);
        g.setFont(g.getFont().deriveFont(0,10));
        g.setColor(Color.WHITE);
        g.drawLine(50,volume_coordinates+4,30,volume_coordinates+4);
        g.drawLine(110,reverb_coordinates+4,90,reverb_coordinates+4);
        g.drawLine(170,pan_coordinates+4,150,pan_coordinates+4);
        g.drawLine(230,modulation_coordinates+4,210,modulation_coordinates+4);
        
        g.drawLine(130,35,130,95);
        g.drawLine(128,35,132,35);
        g.drawLine(128,40,132,40);
        g.drawLine(128,45,132,45);
        g.drawLine(128,50,132,50);
        g.drawLine(128,55,132,55);
        g.drawLine(128,60,132,60);
        g.drawLine(128,65,132,65);
        g.drawLine(128,70,132,70);
        g.drawLine(128,75,132,75);
        g.drawLine(128,80,132,80);
        g.drawLine(128,85,132,85);
        g.drawLine(128,90,132,90);
        g.drawLine(128,95,132,95);
        g.drawString("Max",120,30);
        g.drawString("Min",120,110);
        
        g.drawLine(190,35,190,95);
        g.drawLine(188,35,192,35);
        g.drawLine(188,40,192,40);
        g.drawLine(188,45,192,45);
        g.drawLine(188,50,192,50);
        g.drawLine(188,55,192,55);
        g.drawLine(188,60,192,60);
        g.drawLine(188,65,192,65);
        g.drawLine(188,70,192,70);
        g.drawLine(188,75,192,75);
        g.drawLine(188,80,192,80);
        g.drawLine(188,85,192,85);
        g.drawLine(188,90,192,90);
        g.drawLine(188,95,192,95);
        g.drawString("Max",180,30);
        g.drawString("Min",180,110);
        
        g.drawLine(70,35,70,95);
        g.drawLine(68,35,72,35);
        g.drawLine(68,40,72,40);
        g.drawLine(68,45,72,45);
        g.drawLine(68,50,72,50);
        g.drawLine(68,55,72,55);
        g.drawLine(68,60,72,60);
        g.drawLine(68,65,72,65);
        g.drawLine(68,70,72,70);
        g.drawLine(68,75,72,75);
        g.drawLine(68,80,72,80);
        g.drawLine(68,85,72,85);
        g.drawLine(68,90,72,90);
        g.drawLine(68,95,72,95);
        g.drawString("Max",60,30);
        g.drawString("Min",60,110);
          
        g.drawString("Volume",20,14);
        g.drawString("Reverb",84,14);
        g.drawString("Pan",152,14);
        g.drawString("Modulation",192,14);
        g.setColor(Color.BLACK);
        g.drawRect(30,volume_coordinates,20,10);
        g.drawRect(90,reverb_coordinates,20,10);
        g.drawRect(150,pan_coordinates,20,10);
        g.drawRect(210,modulation_coordinates,20,10);
        
        
        g.setColor(Color.BLACK);
        g.fillOval(664,6,48,20);
        g.fillOval(664,36,48,20);
        g.fillOval(664,66,48,20);
        g.fillOval(724,6,48,20);
        g.fillOval(724,36,48,20);
        g.fillOval(724,66,48,20);
        g.fillOval(724,96,48,20);
        g.fillOval(784,6,48,20);
        g.fillOval(784,36,48,20);
        g.fillOval(784,66,48,20);
        
        //g.drawRoundRect(260,4,206,85,10,10);

        g.setColor(Color.WHITE);
        g.drawLine(488,97,478,104);
        g.drawLine(488,110,478,104);  
        g.drawLine(488,97,488,110);
        g.drawLine(621,104,611,97);
        g.drawLine(621,104,611,110);
        g.drawLine(611,110,611,97);
        
        g.setFont(g.getFont().deriveFont(0,10));
        g.setColor(Color.WHITE);
        g.drawString("Piano",675,20);
        g.drawString("Organ",733,20);
        g.drawString("Guitar",793,20);        
        g.drawString("Bass",677,50);
        g.drawString("Strings",732,50);
        g.drawString("Wind",796,50); 
        g.drawString("Synth",676,80);
        g.drawString("Effects",733,80);
        g.drawString("Drums",793,80);
        g.drawString("Help",737,110);
        g.drawString("Octave",360,108);

        g.setColor(Color.BLACK);
        g.fillOval(334,94,20,20);
        g.drawOval(334,94,20,20);
        g.fillOval(400,94,20,20);
        g.drawOval(400,94,20,20);
        
        g.drawOval(664,6,48,20);
        g.drawOval(664,36,48,20);
        g.drawOval(664,66,48,20);
        g.drawOval(724,6,48,20);
        g.drawOval(724,36,48,20);
        g.drawOval(724,66,48,20);
        g.drawOval(724,96,48,20);
        g.drawOval(784,6,48,20);
        g.drawOval(784,36,48,20);
        g.drawOval(784,66,48,20);
        
        g.setColor(Color.WHITE);
        g.drawLine(348,97,338,104);
        g.drawLine(348,110,338,104);  
        g.drawLine(348,97,348,110);
        g.drawLine(417,104,407,97);
        g.drawLine(417,104,407,110);
        g.drawLine(407,110,407,97);
        
        g.drawString("Pitchbend",878,20);
        g.setColor(Color.BLACK);
        g.fillRect(860,30,86,294);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(850,24,10,300);
        
            if(decrement) g.fillOval(474,94,20,20);
            else if(increment) g.fillOval(604,94,20,20);
            else if(oct_down) g.fillOval(334,94,20,20);
            else if(oct_up) g.fillOval(400,94,20,20);
        
            if(change_type){
                g.setColor(Color.DARK_GRAY);
                    if(type==0) g.fillOval(664,6,48,20);//piano
                    else if(type==1) g.fillOval(724,6,48,20);//organ
                    else if(type==2) g.fillOval(784,6,48,20);//guitar
                    else if(type==3) g.fillOval(664,36,48,20);//bass
                    else if(type==4) g.fillOval(724,36,48,20);//strings
                    else if(type==5) g.fillOval(784,36,48,20);//wind
                    else if(type==6) g.fillOval(664,66,48,20);//synth
                    else if(type==7) g.fillOval(724,66,48,20);//effects
                    else if(type==8) g.fillOval(784,66,48,20);//drums
                    else if(type==9) g.fillOval(724,96,48,20);//help 
            }
                
        
            if(bending){
                g.setColor(Color.WHITE);
                g.drawLine(860,bendYCoordinate-25, 945,bendYCoordinate-25);
                g.fillRect(851,bendStartCoordinate-25,5,5);
            }
    }
}
