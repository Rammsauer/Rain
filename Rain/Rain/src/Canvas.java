import java.awt.*;
import javax.swing.*;

public class Canvas extends JFrame{
	Screen s;
	public int w = 1024; public int h = w / 16*9;;
	public Color p = new Color(230,230,250);
	
	public Canvas() {
		setTitle("Rain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(w, h);
		setVisible(true);
		setBackground(p);
		setResizable(false);
		index();
	}
	
	public void index() {
		s = new Screen();
		add(s);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Canvas();
	}
}