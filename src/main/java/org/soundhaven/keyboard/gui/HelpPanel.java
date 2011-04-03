package org.soundhaven.keyboard.gui;
import java.awt.Graphics;
import javax.swing.JPanel;
public class HelpPanel extends JPanel{
	private static final long serialVersionUID = -6863950128874928696L;
	int left_margin=22;

	public HelpPanel(){
		super();
	}
	
	public void paint(Graphics g){
		g.setFont(g.getFont().deriveFont(0,40));
		g.drawString("Virtual Keyboard Controls",left_margin,40);
		
		g.setFont(g.getFont().deriveFont(0,18));
		g.drawString("Press the keys on your keyboard to play.  They are mapped like the ",left_margin,100);
		g.drawString("keys on a keyboard, with a black key above a white key. For example ",left_margin,130);
		g.drawString("'z' is your lowest note with 's' being the sharp of that note.",left_margin,160);
		g.drawString("Also, the spacebar acts as a sustain pedal.  Holding that while playing ",left_margin,220);
		g.drawString("will keep the note playing until it is released.",left_margin,250);
	}
}
