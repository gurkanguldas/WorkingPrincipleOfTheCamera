package com.Camera.WorkingPrincipleOfTheCamera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class Draw {
	public static void PixelDraw(Graphics g,ArrayList<Integer> U ,ArrayList<Integer> V)
	{
	 Color myColour = new Color(0, 0, 0, 127);
		 
         g.setColor(myColour);
         int x[]= {U.get(0), U.get(1), U.get(2), U.get(3), U.get(4), U.get(5), U.get(0)};
         int y[]= {V.get(0), V.get(1), V.get(2), V.get(3), V.get(4), V.get(5), V.get(0)};
         g.fillPolygon(x, y, x.length);
         
         myColour = new Color(0, 0, 0, 127);
         
         g.setColor(myColour);
         int x9[]= {U.get(17), U.get(23), U.get(22), U.get(16), U.get(17)};
         int y9[]= {V.get(17), V.get(23), V.get(22), V.get(16), V.get(17)};
         g.fillPolygon(x9, y9, x9.length);
         
         myColour = new Color(0, 0, 255, 127);
         
         g.setColor(myColour);
         int x1[]= {U.get(6), U.get(7), U.get(8), U.get(9), U.get(6)};
         int y1[]= {V.get(6), V.get(7), V.get(8), V.get(9), V.get(6)};
         g.fillPolygon(x1, y1, x1.length);
         
         myColour = new Color(255, 0, 0, 127);
         
         g.setColor(myColour);
         int x2[]= {U.get(1), U.get(2), U.get(10), U.get(11), U.get(1)};
         int y2[]= {V.get(1), V.get(2), V.get(10), V.get(11), V.get(1)};
         g.fillPolygon(x2, y2, x2.length);
         
         myColour = new Color(0, 0, 255, 127);
         
         g.setColor(myColour);
         int x3[]= {U.get(12), U.get(13), U.get(14), U.get(15), U.get(12)};
         int y3[]= {V.get(12), V.get(13), V.get(14), V.get(15), V.get(12)};
         g.fillPolygon(x3, y3, x3.length);
         
         myColour = new Color(0, 0, 0, 70);
         
         g.setColor(myColour);
         int x4[]= {U.get(5), U.get(23), U.get(22), U.get(0)};
         int y4[]= {V.get(5), V.get(23), V.get(22), V.get(0)};
         g.fillPolygon(x4, y4, x4.length);
         
         myColour = new Color(0, 0, 255, 70);
         
         g.setColor(myColour);
         int x5[]= {U.get(24), U.get(25), U.get(26), U.get(27), U.get(24)};
         int y5[]= {V.get(24), V.get(25) ,V.get(26), V.get(27), V.get(24)};
         g.fillPolygon(x5, y5, x5.length);
         
         myColour = new Color(0, 0, 255, 70);
         
         g.setColor(myColour);
         int x6[]= {U.get(18), U.get(19), U.get(20), U.get(21), U.get(18)};
         int y6[]= {V.get(18), V.get(19), V.get(20), V.get(21), V.get(18)};
         g.fillPolygon(x6, y6, x6.length);
         
         myColour = new Color(0, 0, 0, 70);
         
         g.setColor(myColour);
         int x7[]= {U.get(3), U.get(16), U.get(17), U.get(4)};
         int y7[]= {V.get(3), V.get(16), V.get(17), V.get(4)};
         g.fillPolygon(x7, y7, x7.length);
         
         myColour = new Color(255, 127, 0, 127);
         
         g.setColor(myColour);
         int x8[]= {U.get(4), U.get(17), U.get(23), U.get(5)};
         int y8[]= {V.get(4), V.get(17), V.get(23), V.get(5)};
         g.fillPolygon(x8, y8, x8.length);
	}
	
	public void RealDraw(GL2 draw,ArrayList<Float> x ,ArrayList<Float> y ,ArrayList<Float> z,Coordinate f) 
	{
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(1.0f, 0.0f, 0.0f,1.0f);
		draw.glVertex3f(0, 0, 0); 
		draw.glVertex3f(200, 0, 0);
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(0.0f, 1.0f, 0.0f,1.0f);
		draw.glVertex3f(0, 0, 0); 
		draw.glVertex3f(0, 200, 0);
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(0.0f, 0.0f, 1.0f,1.0f);
		draw.glVertex3f(0, 0, 0); 
		draw.glVertex3f(0, 0, 200);
		draw.glEnd();
	
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 0.0f, 0.3f);
		draw.glVertex3f(x.get(0), y.get(0), z.get(0)); 
		draw.glVertex3f(x.get(5), y.get(5), z.get(5));
		draw.glVertex3f(x.get(23), y.get(23), z.get(23));
		draw.glVertex3f(x.get(22), y.get(22), z.get(22));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 0.0f,0.5f);
		draw.glVertex3f(x.get(0), y.get(0), z.get(0)); 
		draw.glVertex3f(x.get(5), y.get(5), z.get(5));
		draw.glVertex3f(x.get(4), y.get(4), z.get(4));
		draw.glVertex3f(x.get(3), y.get(3), z.get(3));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(1.0f, 0.5f, 0.0f,0.5f);
		draw.glVertex3f(x.get(4), y.get(4), z.get(4)); 
		draw.glVertex3f(x.get(17), y.get(17), z.get(17));
		draw.glVertex3f(x.get(23), y.get(23), z.get(23));
		draw.glVertex3f(x.get(5), y.get(5), z.get(5));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 0.0f,0.3f);
		draw.glVertex3f(x.get(3), y.get(3), z.get(3)); 
		draw.glVertex3f(x.get(16), y.get(16), z.get(16));
		draw.glVertex3f(x.get(17), y.get(17), z.get(17));
		draw.glVertex3f(x.get(4), y.get(4), z.get(4));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 0.0f,0.5f);
		draw.glVertex3f(x.get(17), y.get(17), z.get(17)); 
		draw.glVertex3f(x.get(23), y.get(23), z.get(23));
		draw.glVertex3f(x.get(22), y.get(22), z.get(22));
		draw.glVertex3f(x.get(16), y.get(16), z.get(16));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(1.0f, 0.0f, 0.0f,0.5f);
		draw.glVertex3f(x.get(1), y.get(1), z.get(1)); 
		draw.glVertex3f(x.get(2), y.get(2), z.get(2));
		draw.glVertex3f(x.get(10), y.get(10), z.get(10));
		draw.glVertex3f(x.get(11), y.get(11), z.get(11));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 1.0f,0.5f);
		draw.glVertex3f(x.get(6), y.get(6), z.get(6)); 
		draw.glVertex3f(x.get(7), y.get(7), z.get(7));
		draw.glVertex3f(x.get(8), y.get(8), z.get(8));
		draw.glVertex3f(x.get(9), y.get(9), z.get(9));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 1.0f,0.5f);
		draw.glVertex3f(x.get(12), y.get(12), z.get(12)); 
		draw.glVertex3f(x.get(13), y.get(13), z.get(13));
		draw.glVertex3f(x.get(14), y.get(14), z.get(14));
		draw.glVertex3f(x.get(15), y.get(15), z.get(15));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 1.0f,0.5f);
		draw.glVertex3f(x.get(24), y.get(24), z.get(24)); 
		draw.glVertex3f(x.get(25), y.get(25), z.get(25));
		draw.glVertex3f(x.get(26), y.get(26), z.get(26));
		draw.glVertex3f(x.get(27), y.get(27), z.get(27));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(0.0f, 0.0f, 1.0f,0.5f);
		draw.glVertex3f(x.get(18), y.get(18), z.get(18)); 
		draw.glVertex3f(x.get(19), y.get(19), z.get(19));
		draw.glVertex3f(x.get(20), y.get(20), z.get(20));
		draw.glVertex3f(x.get(21), y.get(21), z.get(21));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_POLYGON );
		draw.glColor4f(1.0f, 1.0f, 0.0f,1.0f);
		draw.glVertex3d(f.g[0], f.g[1], f.g[2]); 
		draw.glVertex3d((f.g[0] + 2 * (f.f[0] - f.g[0])), (f.g[1] + 2 * (f.f[1] - f.g[1])), f.g[2]);
		draw.glVertex3d((f.g[0] + 2 * (f.f[0] - f.g[0])), (f.g[1] + 2 * (f.f[1] - f.g[1])), (f.g[2] + 2 * (f.f[2] - f.g[2])));
		draw.glVertex3d(f.g[0], f.g[1], (f.g[2] + 2 * (f.f[2] - f.g[2])));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(0.0f,1.0f, 0.0f,1.0f);
		draw.glVertex3d(Data.X0, Data.Y0, Data.Z0); 
		draw.glVertex3d(f.g[0], f.g[1], f.g[2]);
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(1.0f,0.0f, 0.0f,1.0f);
		draw.glVertex3d(Data.X0, Data.Y0, Data.Z0); 
		draw.glVertex3d(f.f[0], f.f[1], f.f[2]);
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(0.0f,1.0f, 0.0f,1.0f);
		draw.glVertex3d(Data.X0, Data.Y0, Data.Z0); 
		draw.glVertex3d((f.g[0]  +2 * (f.f[0] - f.g[0])), (f.g[1] + 2 * (f.f[1] - f.g[1])), (f.g[2] + 2 * (f.f[2] - f.g[2])));
		draw.glEnd();
		
		draw.glBegin(GL2.GL_LINES );
		draw.glColor4f(1.0f,0.0f, 1.0f,1.0f);
		draw.glVertex3d(f.f[0], f.f[1], f.f[2]); 
		draw.glVertex3d(f.Mx,f.My,f.Mz);
		draw.glEnd();
	}
}
