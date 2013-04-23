import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends JPanel implements ActionListener {
	Image img;
	ReadOnlyModel readOnly;
	Controller control;
	// new Controller(this);
	public Thread animator;
	private final int DELAY = 19;
	Timer time;

	public View() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		setFocusable(true);
		requestFocusInWindow();
		requestFocus();
		addKeyListener(new AL());
		ImageIcon i = new ImageIcon("wall2.jpg"); // the background
		img = i.getImage();
		this.setPreferredSize(getMaximumSize());
		time = new Timer(100, this);
		time.start();
		// convoyer thread
		control = new Controller(this);
		Runnable runConv = new Runnable() {
			@Override
			public void run() {
				long beforeTime, timeDiff, sleep;
				beforeTime = System.currentTimeMillis();
				while (true) {
				//	control.cycle();
					
					repaint();
					timeDiff = System.currentTimeMillis() - beforeTime;
					sleep = DELAY - timeDiff;
					if (sleep < 0)
						sleep = 2;
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						System.out.println("interrupted");
					}

					beforeTime = System.currentTimeMillis();
				}
			}

		};
		animator = new Thread(runConv);
		animator.start();

	}

//	public void paintConvoyer(Convoyer convoyer, Graphics2D g2d) {
//		int i = 0;
//		int posx = convoyer.getPositionX();
//		int posy = convoyer.getPositionY();
//		LinkedList<Shape> shaps = convoyer.getShapes();
//		Iterator<Shape> it = shaps.iterator();
//		// draw convoyer image
//		ImageIcon co = new ImageIcon(convoyer.getImageUrl());
//		Image conv = co.getImage();
//		g2d.drawImage(conv, posx, posy, this);
//
//		// draw Queue of shapes which in the convoyer
//		int x = convoyer.getStartOfShapes();
//		int y = posy - 50;
//		while (it.hasNext()) {
//			Shape shape = it.next();
//			String url = control.getShapeUrl(shape);
//			ImageIcon ii = new ImageIcon(url);
//			Image star = ii.getImage();
//			if (convoyer.getDirection().equalsIgnoreCase("toLeft")) {
//				g2d.drawImage(star, x - i, y, this);
//				shape.setPosX(x - i);
//
//			} else {
//				g2d.drawImage(star, x + i, y, this);
//				shape.setPosX(x + i);
//			}
//			shape.setPosY(y);
//		
//
//			i += 50;
//		}
//
//	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public ReadOnlyModel getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(ReadOnlyModel readOnly) {
		this.readOnly = readOnly;
	}

	public void paint(Graphics g) {
		//System.out.println(control.p1.posX);
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		control.checkScore();
		control.intersect();
	try {
		control.generateMore();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		ArrayList<Shape> a = control.shape;
		Iterator<Shape> iter = a.iterator();
		while (iter.hasNext()) {
			
			Shape myShape = iter.next();
			Image mImg=null;
			if(myShape.getType().equals("bomb")){
			ImageIcon img = new ImageIcon("bomb.png");
			 mImg = img.getImage();
			}else{
			ImageIcon img = new ImageIcon(control.getShapeUrl(myShape));
			 mImg = img.getImage();
			}
//			int m = (int) ( 5*Math.random()/2);
//			int sign  = (int) (2*Math.random());
////			if(sign >.9){
////				m= -m;
////			}
//			if(myShape.getPosX()>control.viewWidth/2){
//			myShape.setPosX(myShape.getPosX()+m);
//			
//			}else {
//				myShape.setPosX(myShape.getPosX()-m);
//			}
			g2d.drawImage(mImg, myShape.getPosX(), myShape.getPosY(), null);
			myShape.setPosY(myShape.getPosY() + control.moveShapes);
		}
		
		ReadOnlyPlayer player1 = readOnly.getPlayer1();
		ReadOnlyPlayer player2 = readOnly.getPlayer2();
		if(!player1.getStack().isEmpty()){
			Iterator<Shape> itere = player1.getStack().iterator();
			while(itere.hasNext()){
				Shape s = itere.next();
				ImageIcon imgee = new ImageIcon(control.getShapeUrl(s));
				Image mImgee = imgee.getImage();
				g2d.drawImage(mImgee, control.p1.getPosX(), s.getPosY(), null);
			}
		}
		if(!player2.getStack().isEmpty()){
			Iterator<Shape> itere = player2.getStack().iterator();
			while(itere.hasNext()){
				Shape s = itere.next() ;
				ImageIcon imgee = new ImageIcon(control.getShapeUrl(s));
				Image mImgee = imgee.getImage();
				g2d.drawImage(mImgee, control.p2.getPosX(), s.getPosY(), null);
			}
		}
		ImageIcon imagP = new ImageIcon(player1.getPlayerImage());
		ImageIcon imagP2 = new ImageIcon(player2.getPlayerImage());
		g2d.drawImage(imagP.getImage(), player2.getPosX(), player1.getPosY(), null);
		g2d.drawImage(imagP2.getImage(), player1.getPosX(), player2.getPosY(), null);
//		Iterator<Convoyer> it = control.conv.iterator();
//		while (it.hasNext()) {
//			Convoyer c = it.next();
//			paintConvoyer(c, g2d);
//		}
//		try {
//			control.checkFalling();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	private class AL extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			// sendThisEvent to controller
			control.move(e, false);
		}

		public void keyPressed(KeyEvent e) {
			// sendThisEvent to controller
			control.move(e, true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	public void runGUI() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		
		JFrame frame = new JFrame();
		
		JMenuBar jmenu = new  JMenuBar();
		
		jmenu.setPreferredSize(new Dimension(1200,30));
		JMenu jm = new JMenu("File");
		JMenuItem itemSave = new JMenuItem("Save");
		itemSave.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		control.save("", "game.txt");
			}
		});
		JMenuItem itemLoad = new JMenuItem("Load");
		itemLoad.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				View v=null;
				try {
					v = new View();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		control.Load(v, "", "game.txt");
		readOnly  = new ReadOnlyModel(control.p1,control.p2);
			}
		});
		
		jm.add(itemSave);
		jm.add(itemLoad);
		JMenu Score= new JMenu("Player 1 Score = " +this.control.p1.getScore());
		JMenu Score2= new JMenu("Player 2 Score = " +this.control.p2.getScore());
		
		jmenu.add(Score);
		jmenu.add(Score2);
		
		jmenu.add(jm);
//		JLabel scoreP1 = new JLabel();
//		
//		scoreP1.setBackground(Color.white);
//		scoreP1.setLayout(null);
//		
//		scoreP1.setText(readOnly.getPlayer1().getScore()+"");
//		scoreP1.setLocation(new Point(200,200));
//		scoreP1.setVisible(true);
//		
//		this.add(scoreP1);
		

//System.out.println(this.getComponentAt(new Point(200,200)));
		Controller c = new Controller(this);
		this.setControl(c);
		
		frame.add(this);
		frame.setJMenuBar(jmenu);
	
		frame.setVisible(true);
		frame.setSize(this.getMaximumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		JFrame frame = new JFrame();
//		View v = new View();
//		Controller c = new Controller(v);
//		v.setControl(c);
//	
//		frame.add(v);
//		frame.setVisible(true);
//		frame.setSize(v.getMaximumSize());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		View v = new View();
		v.runGUI();
		
	}
}
