//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Queue;
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//public class tr implements Runnable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Thread animator;
//	private final int DELAY = 10;
//	int x = 200;
//	int y;
//	JPanel panel;
//	ArrayList<Convoyer> convoyers;
//
//	public tr(ArrayList<Convoyer> convoyers, JPanel panel) {
//		this.panel = panel;
//		this.convoyers = convoyers;
//		animator = new Thread(this);
//		animator.start();
//	}
//
//	public void addNotify() {
//		panel.addNotify();
//	}
//
//	public void paint(Graphics g) {
//		panel.paint(g);
//		Graphics2D g2d = (Graphics2D) g;
//		Iterator<Convoyer> it = convoyers.iterator();
//		while (it.hasNext()) {
//			Convoyer c = it.next();
//			paintConvoyer(c, g2d);
//		}
//		Toolkit.getDefaultToolkit().sync();
//		g.dispose();
//	}
//
//	public void cycleToLeft() {
//		System.out.println(x);
//
//		x -= 1;
//		// y += 1;
//		//
//		// if (y > 240) {
//		// y = -45;
//		// x = -45;
//		// }
//	}
//
//	public void cycleToRight() {
//		x += 1;
//		// y += 1;
//		//
//		// if (y > 240) {
//		// y = -45;
//		// x = -45;
//		// }
//	}
//
//	public void paintConvoyer(Convoyer convoyer, Graphics2D g2d) {
//		int i = 0;
//		int posx = convoyer.getPositionX();
//		int posy = convoyer.getPositionY();
//		Queue<Shape> shaps = convoyer.getShapes();
//		Iterator<Shape> it = shaps.iterator();
//		// draw convoyer image
//		ImageIcon co = new ImageIcon(convoyer.getImageUrl());
//		Image conv = co.getImage();
//		g2d.drawImage(conv, posx, posy, panel);
//		// draw Queue of shapes which in the convoyer
//		y = posy - 50;
//		while (it.hasNext()) {
//			Shape shape = it.next();
//			String url = getShapeUrl(shape);
//			ImageIcon ii = new ImageIcon(url);
//			Image star = ii.getImage();
//			g2d.drawImage(star, x + i, y, panel);
//			shape.setPosX(x + i);
//			shape.setPosY(y);
//			i += 50;
//		}
//
//	}
//
//	public void run() {
//		long beforeTime, timeDiff, sleep;
//		beforeTime = System.currentTimeMillis();
//		while (true) {
//			panel.repaint();
//			cycleToRight();
//
//			timeDiff = System.currentTimeMillis() - beforeTime;
//			sleep = DELAY - timeDiff;
//
//			if (sleep < 0)
//				sleep = 2;
//			try {
//				Thread.sleep(sleep);
//			} catch (InterruptedException e) {
//				System.out.println("interrupted");
//			}
//
//			beforeTime = System.currentTimeMillis();
//		}
//	}
//
//	private String getShapeUrl(Shape sh) {
//		if (sh.getColor().equalsIgnoreCase("blue"))
//			return sh.getURLBlueShape();
//		else if (sh.getColor().equals("black"))
//			return sh.getURLBlackShape();
//		else if (sh.getColor().equals("green"))
//			return sh.getURLGreenShape();
//		else if (sh.getColor().equals("red"))
//			return sh.getURLRedShape();
//		else
//			return sh.getURLOrangeShape();
//	}
//
//}
