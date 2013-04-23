import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Controller {

//	ArrayList<Convoyer> conv = new ArrayList<Convoyer>();
	Player p1;
	Player p2;
	View view;
	boolean canceled = true;
	static int counte=0;
	ArrayList<Shape> shape= new ArrayList<Shape>();
	int moveShapes=1;
	int difficulity = 1;
	
int viewWidth = 1150;
int viewHeight = 700;
	public Controller(View v) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		view = v;
		p1 = new Player();
		p2 = new Player();
		
		p1.setPosX(viewWidth);
		p2.setPosX(0);
		v.setReadOnly(new ReadOnlyModel(p1, p2));
		generateRandom(5);
		moveShapes=(int) (difficulity*1.5);
//		LinkedList<Shape> q = new LinkedList<Shape>();
//		Plate p = new Plate();
//		p.setColor("Red");
//		q.offer(p);
//		Plate p1 = new Plate();
//		p1.setColor("Red");
//		p1.setPosX(20);
//		q.offer(p1);
//		
//		Plate p2 = new Plate();
//		p2.setPosX(200);
//		p2.setColor("Red");
//		q.offer(p2);
//		Plate p3 = new Plate();
//		p3.setColor("Red");
//		p3.setPosX(500);
//		q.offer(p3);
//		Plate p4 = new Plate();
//		p4.setColor("Red");
//		q.offer(p4);
//		Plate p5 = new Plate();
//		p5.setColor("Red");
//		q.offer(p5);
//		shape.add(p1);
//		shape.add(p2);
//		shape.add(p3);
//		Convoyer convo = new Convoyer(700, 100, 800, q, "toleft" , 10);
//		conv.add(convo);
//		p = new Plate();
//		p.setColor("Blue");
//		q.add(p);
//		p1 = new Plate();
//		p1.setColor("Black");
//		q.add(p1);
//		Convoyer conv2 = new Convoyer(130, 500, 400, q, "toRight", 11);
//		conv.add(conv2);

	}
	public void generateMore() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		if(shape.size()<2){
			int num = (int) (10*Math.random());
			generateRandom(num);
		}
	}
public void generateRandom (int num) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
	boolean flag = false;
	for(int i =0 ;i<num ;i++){
		int x = (int)(3*Math.random());
		int color = (int) (6*Math.random());
		int PoX = (int)(900*Math.random());
		int PoY = (int)(100*Math.random());
		ShapePool shapeP = ShapePool.getInstance();
		Shape s = null;
		if(x==0){
			 s = shapeP.acquireShape("Plate");
		}	
//		else if(x==2){
//			s = new Bomb();
//			flag = true;
//			s.setPosX(100);
//			s.setPosY(100);
//		}
		else{
			 s  = shapeP.acquireShape("Ball");
		}
		if(!flag){
		if(color==0){
			s.setColor("black");
			}
			else if(color ==1){
				s.setColor("Red");
			}else if(color==2){
				s.setColor("blue");
			}else if(color==3){
				s.setColor("green");
			}else {
				s.setColor("orange");
			}
		}
		s.setPosX(PoX);
		s.setPosY(PoY);
		shape.add(s);
	}
}
public void controlAll() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
	intersect();
	generateMore();
}
	public void intersect() {
//		if(p1.shapes.peek().getPosY()<=0 ||p2.shapes.peek().getPosY()<=0 ){
//			System.exit(0);
//		}
		
		intersectFrame();
		//generateMore();
		if(!shape.isEmpty()){
		Iterator<Shape> i = shape.iterator();
		while (i.hasNext()) {
			Shape s = i.next();
	
			if (p1.checkIntersect(s)) {
				if(s.getType().equals("bomb")){
			Iterator<Shape > it = p1.getShapes().iterator();
			while(it.hasNext()){
				Shape shh = it.next();
				ShapePool shapePool = ShapePool.getInstance();
				shapePool.releaseShape(shh);
			}
				}
			
			p1.getShapes().push(s);
				
				i.remove();
			} else if (p2.checkIntersect(s)) {
			
				p2.getShapes().push(s);
				
				i.remove();
				
			}
		}
		}

	}
public int getDifficulity() {
		return difficulity;
	}
	public void setDifficulity(int difficulity) {
		this.difficulity = difficulity;
		moveShapes=(int) (difficulity*1.5);
	}
public void generateArryaList() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
	ShapePool pool = ShapePool.getInstance();
	Shape sh = pool.acquireShape("Plate");
	sh.setColor("Red");
	shape.add(sh);
}
	private void intersectFrame() {
		Iterator<Shape> i = shape.iterator();
		while (i.hasNext()) {
			Shape s = i.next();
		if(s.getPosY()>viewHeight){
			//should vanish
			
		ShapePool shap=	ShapePool.getInstance();
		shap.releaseShape(s);
		i.remove();
		}else if(s.getPosX()>=viewWidth){
			s.setPosX(s.getPosX()-20);
		}else if(s.getPosX()<=0){
			s.setPosX(s.getPosX()+20);
		}
		}
	}
//	public void LoadGame(View v){
//		ArrayList<Object> a= 
//	}
	public Controller(View v , ArrayList<Shape> array ,Player pl1 ,Player pl2,int diff){
		view = v;
		shape=array;
		p1=pl1;
		p2=pl2;
		difficulity=diff;
		
	}
	public void Load(View v,String url ,String filename){
		Save s = new Save();
		ArrayList<Object> a = s.Load(url, filename);
		ArrayList<Shape> arr = (ArrayList<Shape>) a.get(0);
		Player pl1 = (Player) a.get(1);
		Player pl2= (Player) a.get(2);
		int diff = (Integer) a.get(3);
		this.shape = arr;
		this.p1 = pl1;
		
		this.p2= pl2;
		this.difficulity = diff;
		
	}
public void save(String url , String filename){
	Save s = new Save();
	ArrayList<Object> allGame =  new ArrayList<Object>();
	allGame.add(shape);
	allGame.add(p1);
	allGame.add(p2);
	allGame.add(difficulity);
s.save(allGame, url, filename);
}
	public void checkScore() {
		if (p1.getShapes().size() >= 3) {
			if (p1.checkScore()) {

				Shape first = p1.getShapes().pop();
				Shape second = p1.getShapes().pop();
				Shape third = p1.getShapes().pop();

				ShapePool s = ShapePool.getInstance();
				s.releaseShape(first);
				s.releaseShape(second);
				s.releaseShape(third);
				p1.setScore(p1.getScore() + difficulity * 3);
				System.out.println(p1.getScore());
	
			}
		}
		if (p2.getShapes().size() >= 3) {
			if (p2.checkScore()) {
				Shape first = p2.getShapes().pop();
				Shape second = p2.getShapes().pop();
				Shape third = p2.getShapes().pop();
				ShapePool s = ShapePool.getInstance();
				s.releaseShape(first);
				s.releaseShape(second);
				s.releaseShape(third);
				p2.setScore(p2.getScore() + difficulity * 3);
				System.out.println(p1.getScore());
			}
		}
		view.readOnly= new ReadOnlyModel(p1,p2);
	}

	public void move(KeyEvent e, boolean flag) {
		if (!flag) {
			p1.setDx(0);
			p2.setDx(0);
		} else {

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (p1.getPosX() -7 > 0 && p1.getPosX()-7 >(p2.getPosX()+p2.getPosWidth())) {
					
					p1.setDx(-7);
				}else {
				p1.setDx(0);	
				}
			}
			
			if (e.getKeyCode() == KeyEvent.VK_A ) {
				if(p2.getPosX() -7>0){
				p2.setDx(-7);
			}
			else {
				p2.setDx(0);
			}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (p1.getPosX() +7 <viewWidth) {
					
				p1.setDx(7);
				}else{
					p1.setDx(0);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				if(p2.getPosX()+7<viewWidth && p2.getPosX()+7<p1.getPosX()-p1.getPosWidth()){
				p2.setDx(7);
				}else{
					p2.setDx(0);
				}
			}
		}
		p1.move();
		p2.move();
	}
	// cycle conv
//	public void cycle() {
//	
//		Iterator<Convoyer> co = conv.iterator();
//		int count=0;
//		while (co.hasNext()) {
//			Convoyer c = co.next();
//			LinkedList<Shape> l = c.getShapes();
//			if(!l.isEmpty()){
//			if(l.getLast().getPosX()<c.getStartOfShapes())
//			{c.setStartOfShapes(c.getStartOfShapes() - 1);
//			}	else
//			{
//				System.out.println("Posmesh"+l.getLast().getPosX());
//				c.setStartOfShapes(c.getStartOfShapes() + 1);
//			
//			
////			System.out.println(l.getLast().getColor()+"     "+l.getLast().getPosX());
//////				Plate p = new Plate();
//////				p.setColor("Red");
//////				c.getShapes().addFirst(p);
////			}
//		
//////				Plate p = new Plate();
//////				p.setColor("Red");
//////				c.getShapes().addFirst(p);
////			}
//			}	
//			}else{
//				LinkedList<Shape> q = new LinkedList<Shape>();
//				Plate p = new Plate();
//				p.setColor("Red");
//				q.offer(p);
//				Plate p1 = new Plate();
//				p1.setColor("Blue");
//				q.offer(p1);
//				Plate p2 = new Plate();
//				p2.setColor("Red");
//				q.offer(p2);
//				Plate p3 = new Plate();
//				p3.setColor("Black");
//				q.offer(p3);
//				Plate p4 = new Plate();
//				p4.setColor("green");
//				q.offer(p4);
//				Plate p5 = new Plate();
//				p5.setColor("Red");
//				q.offer(p5);
//				Convoyer convo = new Convoyer(700, 100, 800, q, "toleft" , 10);
//				co.remove();
//				conv.add(count,convo);
//			}
//			count++;
//		}
//		
//	}
//	public void cycle() {
//		
//		Iterator<Convoyer> co = conv.iterator();
//		while (co.hasNext()) {
//			Convoyer c = co.next();
//			if (c.getDirection().equalsIgnoreCase("toLeft"))
//				c.setStartOfShapes(c.getStartOfShapes() - 1);
//			else
//				c.setStartOfShapes(c.getStartOfShapes() + 1);
//		}
//	}
//	public Shape generateRandom(Shape s){
//		int m = (int) ( 5*Math.random()/2);
//		if(s.getPosX()>viewWidth/2){
//		s.setPosX(s.getPosX()-m);
//	
//		}else {
//			s.setPosX(s.getPosX()+m);
//			System.out.println("here");
//		}
//		return s;
//	}
	public String getShapeUrl(Shape sh) {
		if(sh.getType().equals("bomb")){
			return "bomb.png";
		}else{
		 if (sh.getColor().equalsIgnoreCase("blue"))
			return sh.getURLBlueShape();
		else if (sh.getColor().equalsIgnoreCase("black"))
			return sh.getURLBlackShape();
		else if (sh.getColor().equalsIgnoreCase("green"))
			return sh.getURLGreenShape();
		else if (sh.getColor().equalsIgnoreCase("red"))
			return sh.getURLRedShape();
		else
			return sh.getURLOrangeShape();
		}
	}
	
//	public void checkFalling() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		
//		Iterator<Convoyer> con = conv.iterator();
//	
//		while(con.hasNext()){
//			Convoyer c = con.next();
//			if(c.checkFalling()){
//				Shape s =c.getShapes().removeLast();
//				if(c.getShapes().isEmpty()){
//	
//		c.getShapes().add(s);
//	
//				}
//				System.out.println("size"+c.getShapes().size());
//				shape.add(s);
//			}
//		}
//	}

}
