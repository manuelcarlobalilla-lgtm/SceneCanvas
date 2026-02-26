import java.awt.*;
import java.awt.geom.*;

public class Person implements DrawingObject{
	private double x,y;
	private double xmove;
	private int personx;
	private int rotation;
	private BasicStroke thickness1, thickness2, thickness3;
	private Color skin, hair, eye, shirts;
	private int angle;

	public Person(double x, double y){
		this.x = x;
		this.y = y;
		xmove = 0;
		angle = 0;
		thickness1 = new BasicStroke(7f);
		thickness2 = new BasicStroke(10f);
		thickness3 = new BasicStroke(4f);
		skin = new Color(255, 216, 181);
	}

	public void draw(Graphics2D g2d){
		AffineTransform reset = g2d.getTransform();

		g2d.translate(x,y);
		g2d.rotate(Math.toRadians(angle),42.5 + xmove,142.5);
		g2d.translate(xmove,0);
		
		Circle head = new Circle(0,0,85,skin);
		head.draw(g2d);

		Circle eyes = new Circle(6,24,30, Color.WHITE);
		eyes.draw(g2d);
		eyes.outlineCircle(g2d);
		eyes.changeColor(Color.BLACK);
		eyes.changeSize(18);
		eyes.move(10,28);
		eyes.draw(g2d);
		eyes.changeColor(Color.WHITE);
		eyes.changeSize(8);
		eyes.move(11.5,29.5);
		eyes.draw(g2d);

		g2d.translate(42,0);

		eyes.move(6,24);
		eyes.changeSize(30);
		eyes.changeColor(Color.WHITE);
		eyes.draw(g2d);
		eyes.outlineCircle(g2d);
		eyes.changeColor(Color.BLACK);
		eyes.changeSize(18);
		eyes.move(10,28);
		eyes.draw(g2d);
		eyes.changeColor(Color.WHITE);
		eyes.changeSize(8);
		eyes.move(11.5,29.5);
		eyes.draw(g2d);

		g2d.translate(-40,0);

		Line hair = new Line(42.5,7,42.5,-10,thickness1,new Color(84, 46, 13));
		hair.draw(g2d);
		hair.adjustX1(15);
		hair.adjustX2(20);
		hair.draw(g2d);
		hair.adjustX1(-30);
		hair.adjustX2(-40);
		hair.draw(g2d);
		
		Path2D.Double shirt = new Path2D.Double();
		shirt.moveTo(35,85);
		shirt.curveTo(-10,110,-12,127.5,-10,200);
		shirt.lineTo(95,200);
		shirt.curveTo(97,127.5,95,110,50,85);
		g2d.setColor(new Color(46, 119, 230));
		g2d.fill(shirt);
		
		Line hands = new Line(-4,110,-70,50,thickness2,skin);
		hands.draw(g2d);
		hands.adjustX1(93);
		hands.adjustX2(220);
		hands.draw(g2d);
		
		Circle palms = new Circle(-78,42,20,skin);
		palms.draw(g2d);
		palms.move(138,42);
		palms.draw(g2d);
		Line fingers = new Line(-67,42,-67,35,thickness3,skin);
		fingers.draw(g2d);
		fingers.adjustX1(-8);
		fingers.adjustX2(-12);
		fingers.draw(g2d);
		fingers.adjustX1(229);
		fingers.adjustX2(240);
		fingers.draw(g2d);
		fingers.adjustX1(-5);
		fingers.adjustX2(-15);
		fingers.draw(g2d);

		Line legs = new Line(5,250,-5,300,thickness2,skin);
		legs.draw(g2d);
		legs.adjustX1(75);
		legs.adjustX2(95);
		legs.draw(g2d);
	
		Path2D.Double shorts = new Path2D.Double();
		shorts.moveTo(-10,200);
		shorts.lineTo(-20,250);
		shorts.lineTo(30,250);
		shorts.lineTo(42.5,210);
		shorts.lineTo(55,250);
		shorts.lineTo(105,250);
		shorts.lineTo(95,200);
		g2d.setColor(new Color(240, 146, 38));
		g2d.fill(shorts);

		Rectangle shoes = new Rectangle(new Color(255, 94, 220),40,20);
		shoes.move(-38,290);
		shoes.draw(g2d);
		Path2D.Double swoosh = new Path2D.Double();
		swoosh.moveTo(-20,296);
		swoosh.curveTo(-35,305,-24,303,3,296);
		swoosh.curveTo(-20,298,-24,302,-20,296);
		g2d.setColor(Color.WHITE);
		g2d.fill(swoosh);
		g2d.translate(96,0);
		shoes.draw(g2d);
		g2d.setColor(Color.WHITE);
		g2d.fill(swoosh);

		g2d.setTransform(reset);
	}

	public void updatePerson(int rotate, int personx){
		angle = rotate;
		xmove = personx;
	}
}
