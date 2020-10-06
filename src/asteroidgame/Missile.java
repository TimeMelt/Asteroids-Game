/*
 * Author: Jean-Paul Stevens
 */
package asteroidgame;

import java.awt.Color;
import blobz.Blob;
import blobz.BlobProximity;

public class Missile extends Blob implements BlobProximity {
	private double speed = 5.0; 
	private double diameter = 5.0;
	private int dx = 0; 
	private int dy = 0;
	
	public Missile(int x, int y, double angle) {
		super(x, y, Color.orange);
		setSize((int)diameter);
		
		dx = dx + (int) Math.round(speed * Math.cos(angle));
		dy = dy + (int) Math.round(speed * Math.sin(angle));
		
		int newX = getLoc().x + dx;
		int newY = getLoc().y + dy;
		
		setLoc(newX, newY);
		setDelta(dx, dy);
		
		
			
	}
}