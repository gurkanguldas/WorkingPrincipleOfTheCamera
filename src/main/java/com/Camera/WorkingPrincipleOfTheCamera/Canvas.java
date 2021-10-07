package com.Camera.WorkingPrincipleOfTheCamera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Canvas implements GLEventListener {
	float sleep;
	boolean text = true;
	
	ArrayList<Float> x = new ArrayList<Float>();
	ArrayList<Float> y = new ArrayList<Float>();
	ArrayList<Float> z = new ArrayList<Float>();
	
	public static void Show()
	{
		GLProfile profine = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profine);
		GLCanvas canvas = new GLCanvas(capabilities);
		Canvas l = new Canvas();
		
		canvas.addGLEventListener(l);
		canvas.setSize(700,700);
		
		JFrame frame = new JFrame();
		
		frame.setSize(700,700);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JFrame fr = new JFrame();
		
		fr.setSize(800, 600);
		fr.setLocation(100, 100);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		
		panel.actions();
		fr.add(panel);
		fr.setVisible(true);
		
		FPSAnimator animasyon = new FPSAnimator(canvas,300,true);
		animasyon.start();										
	}

	@Override
	public void display(GLAutoDrawable e) 
	{
		Coordinate f = new Coordinate();
		f.ReadText(Data.fileURL);
		f.ImageCoordinate();
		
		if(text == true) 
		{
			File SP3 = new File(Data.fileURL);
			try {
				BufferedReader buffer = new BufferedReader(new FileReader(SP3));
				String read =buffer.readLine();
				while(read!=null) 
				{
					x.add(Float.valueOf(read.substring(0, 5)));
					y.add(Float.valueOf(read.substring(8, 14)));
					z.add(Float.valueOf(read.substring(14, read.length())));				 
					read= buffer.readLine();
				}
				buffer.close();
			}catch (IOException a ) 
			{
				
			}
			text=false;
		}
		
		GL2 draw = e.getGL().getGL2();

		draw.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
		draw.glEnable(GL.GL_BLEND); 
		draw.glBlendFunc(GL2.GL_SRC_ALPHA,GL2.GL_ONE_MINUS_SRC_ALPHA);
		draw.glLoadIdentity();			
		draw.glClearColor(0.9f, 0.9f, 0.9f, 0.0f);
		
		draw.glScalef(-0.02f,0.02f,0.02f);
		draw.glTranslated(0, -0, -0);
		draw.glRotated(250, 1, 0, 0);
		draw.glRotated(115, 0, 0, 1);
		draw.glRotated(sleep, 0, 0, 1);
		
		Draw Real =new Draw();
		Real.RealDraw(draw, x, y, z ,f);
		draw.glFlush();
		
		sleep+=0.1f;
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
}
