/*
 * Author: Jean-Paul Stevens
 */
package asteroidgame;

import blobz.PolyBlob;
import blobz.BlobUtils;
import java.awt.Point;
import java.util.Random;

public class Asteroid extends PolyBlob {
	
	private static final Random random = new Random();
	
	public Asteroid(int idx, int jdx, double rot) {
		super(-100, -100, rot);
		super.setDelta(idx, jdx);
		
		int num_sides = 5 + random.nextInt(5);
		
		int[] vertex = new int[num_sides];
		for (int i = 0; i < num_sides; i++) {
			vertex[i] = 5 + random.nextInt(11);
		}
		
		Point[] p = new Point[num_sides];
		double region = (2 * Math.PI) / num_sides;
		double[] angle = new double[num_sides];
		
		for (int i = 0; i < num_sides; i++) {
			angle[i] = (i * region) + (Math.random() * region);
			p[i] = BlobUtils.rotatePoint(vertex[i], angle[i]);
		}
		
		super.setPolygon(p);
	}
}
