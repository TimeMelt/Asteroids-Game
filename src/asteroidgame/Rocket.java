/*
 * Author: Jean-Paul Stevens
 */
package asteroidgame;

import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.PolyBlob;
import blobz.BlobUtils;
import blobz.SandBox;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Point;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {
	
	public Rocket rocket;
	static SandBox s;
	private double angle = 0.0;
	private final double delta = 0.15;
	private final double speed = 5.0;
	private int xloc = 0;
	private int yloc = 0;
	Point RocketLoc;
	int RocketSize;
	
	public Rocket(int x, int y, SandBox sb) {
		super(x,y,0);
		xloc = x;
		yloc = y;
		s = sb;
		
		Point[] points = {
			new Point(10,0),
			new Point(-10,-7),
			new Point(-5,0),
			new Point(-10,7)
		};
		
		setPolygon(points);
		setColor(Color.green);
		RocketLoc = getLoc();
		RocketSize = getSize();
	}
	
	public void launch(SandBox s) {
		Missile missile = new Missile(xloc, yloc, angle); 
		s.addBlob(missile);
	}
	
	public void keyAction(KeyEvent e) {
		
		switch(e.getKeyCode()) {
			case 32: // Process Space Bar
				launch(s);
				BlobUtils.playSound();
				break;
			case 37: // Process Left Arrow Key
				angle = angle - delta;
				
				if(angle < 0)
					angle = angle + (2 * Math.PI);
					
				setAngle(angle);
				break;
			case 38: // Process Up Arrow Key
				xloc = xloc + (int) Math.round(speed * Math.cos(angle));
				yloc = yloc + (int) Math.round(speed * Math.sin(angle));
					
				setLoc(xloc, yloc);
				break;
			case 39: // Process Right Arrow Key
				angle = delta + angle;
				
				if(angle > (2 * Math.PI))
					angle = angle - (2 * Math.PI);
					
				setAngle(angle);
				break;
		}
	}
}
