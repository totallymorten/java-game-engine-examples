package engine.examples;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.JavaEngine;


public class JavaMinimalEngine extends JavaEngine
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841844401025841597L;
	
	public JavaMinimalEngine (int width, int height, double fps)
	{
		super(width, height, fps);
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.blue);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 20, 20);

		
		renderStats(g, 200);
	}
	
	double x=13,y=47;
	double speedx = 237;
	double speedy = 125;
	double speedXPrNs = speedx / Math.pow(10, 9);
	double speedYPrNs = speedy / Math.pow(10, 9);
	
	public void update(double ns)
	{
		x += speedXPrNs * ns;
		y += speedYPrNs * ns;
		
		if (x > (WIDTH - 20) && speedXPrNs > 0
		 || x < 0 && speedXPrNs < 0)
			speedXPrNs *= -1;
		
		if (y > (HEIGHT - 20) && speedYPrNs > 0 
		||  y < 0 && speedYPrNs < 0)
			speedYPrNs *= -1;
	}

	public static void main(String[] args)
	{
		(new Thread(new JavaMinimalEngine(500,500,5000))).start();
	}

	@Override
	public void handlePreCycle()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preExit()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		
	}

}
