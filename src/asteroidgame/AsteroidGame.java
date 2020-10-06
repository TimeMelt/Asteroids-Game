/*
 * Author: Jean-Paul Stevens
 */
package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.awt.Dimension;
import java.util.Random;

public class AsteroidGame implements BlobGUI {
	static int num;
	private static SandBox sb;
	private static final Random random = new Random();
	
	public AsteroidGame(int number) {
		num = number;
		sb = new SandBox();
		sb.setSandBoxMode(SandBoxMode.FLOW);
		sb.setFrameRate(15);
		sb.init(this);
	}
	
	public void generate() {
		Dimension dim = sb.getPanelBounds();
		Rocket rocket = new Rocket(dim.width/2, dim.height/2, sb);
		sb.addBlob(rocket);
		
		for(int i = 0; i < num; i++) {	
			int DeltX = 0;
			while(DeltX == 0) 
				DeltX = -3 + random.nextInt(7);
		
			int DeltY = 0;
			while(DeltY == 0) 
				DeltY = -3 + random.nextInt(7);
			
			double rot = 0.1;
			int b = random.nextInt(2);
			if (b == 0)
				rot = -rot;
			
			Asteroid a = new Asteroid(DeltX, DeltY, rot);
			sb.addBlob(a);
		}
	}
	
	public static void main(String[] args) {
		new AsteroidGame(Integer.parseInt((args[0])));
	}

}
