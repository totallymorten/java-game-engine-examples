package engine.examples;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import particle.ParticleConfiguration;
import particle.ParticleSystem;
import engine.JavaEngine;


public class JavaParticleEngine extends JavaEngine
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841844401025841597L;
	
	
	ParticleSystem p = new ParticleSystem(6000, 500, 350, ParticleConfiguration.CONF2, Color.red, Color.green, 0.0);
	//ParticleSystem p = new ParticleSystem(6000, 500, 350, ParticleConfiguration.CONF2);
	//ParticleSystem p = new ParticleSystem(6000, 500, 350, ParticleConfiguration.CONF3);
	
	public JavaParticleEngine (int w, int h)
	{
		super(w,h,5000);
	}
	
	public void render(Graphics2D g)
	{
		
		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		int y = 20;
		int xLeft = 10;
		int xRight = WIDTH - 200;
		
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Particles: " + p.count, xRight, y+60);

		renderStats(g, 200);
		
		p.render(g);
	}
	

	public void update(double ns)
	{
		p.update(ns);
	}

	Font font = new Font("Courier New",Font.BOLD,20);
	
	public static void main(String[] args)
	{
		
		(new Thread(new JavaParticleEngine(1024,768))).start();
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_A)
			p.x -= 10;
		else if (e.getKeyCode() == KeyEvent.VK_D)
			p.x += 10;
		else if (e.getKeyCode() == KeyEvent.VK_W)
			p.y -= 10;
		else if (e.getKeyCode() == KeyEvent.VK_S)
			p.y += 10;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			p.generate = p.generate ? false : true;
		}
		else super.keyPressed(e);
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