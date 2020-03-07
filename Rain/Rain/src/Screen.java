import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements Runnable{
	private Color c = new Color(175,190,250), c1 = new Color(230,230,250);
	private int rai = 1500, z = 0, v = 0; 
	private int[] x = new int [rai];  
	private int[] y = new int [rai];
	private int[] h = new int [rai];
	
	public Screen() {
		Thread th = new Thread(this);
		th.start();
		for(int i = 0; i < rai;i++) {
			x[i] = (int) (Math.random()*1024); 
			y[i] = (int) (Math.random()*(-500));
			h[i] = (int) (Math.random() * 4);
		}
	}
	
	public void paint(Graphics g) {
		if(z == 1) {
			g.setColor(c1);
			g.fillRect(0, 0, 1024, 1024/16*9);
			z=0;
		}
		if (z == 0) {
			g.setColor(c);
			for(int n = 0; n < rai; n++) {
				g.fillRect(x[n], y[n],h[n],20);
			}
			z=1;
		}
	}
	
	public void run() {
		raindrop();
	}
	
	public void raindrop() {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		while (v<1) {
			try {
				repaint();
				Thread.sleep((long) 3);
			}
			catch (InterruptedException ex) {}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			for(int n = 0; n < rai;n++) {
				if(y[n] > 550) {
					x[n] = (int) (Math.random()*1024);
					y[n] = (int) (Math.random()*(-10));
					h[n] = (int) (Math.random() * 3) + 1;
				}
				else {
					y[n] = y[n] + h[n];
				}
			}
			try {
				Thread.sleep(0);
				repaint();
			}
			catch (InterruptedException ex) {}
		}
	}
}
