package com.Camera.WorkingPrincipleOfTheCamera;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener
{
	public Timer animator;
	
	public void actions() 
	{
		KeyListener key = new KeyListener() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_A)
					Data.X0+=0.50;
				if(e.getKeyCode()==KeyEvent.VK_D)
					Data.X0-=0.50;
				if(e.getKeyCode()==KeyEvent.VK_W)
					Data.Y0+=0.50;
				if(e.getKeyCode()==KeyEvent.VK_S)
					Data.Y0-=0.50;
				if(e.getKeyCode()==KeyEvent.VK_V)
					Data.Z0+=0.50;
				if(e.getKeyCode()==KeyEvent.VK_C)
					Data.Z0-=0.50;
				if(e.getKeyCode()==KeyEvent.VK_UP)
					Data.f+=0.25;
				if(e.getKeyCode()==KeyEvent.VK_DOWN)
					Data.f-=0.25;
			}
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
			}
			@Override
			public void keyTyped(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
			}
		};
		
		addKeyListener(key);
		setFocusable(true);
		animator = new Timer(25, this);
		animator.start();
	}
	 public void paintComponent(Graphics g)
	 {
		 super.paintComponent(g);
         this.setBackground(Color.white);
         
         Coordinate f = new Coordinate();
         f.ReadText(Data.fileURL);
 		 f.ImageCoordinate();
 		 f.PixelCoordinate();
 		
         ArrayList<Integer> U=f.u;
         ArrayList<Integer> V=f.v;
         
         Draw.PixelDraw(g, U, V); 
	 }
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		repaint();
	}
}
