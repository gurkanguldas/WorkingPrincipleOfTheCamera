package com.Camera.WorkingPrincipleOfTheCamera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Coordinate {
	
	public ArrayList<Double> X= new ArrayList<Double>();
	public ArrayList<Double> Y= new ArrayList<Double>();
	public ArrayList<Double> Z= new ArrayList<Double>();
	
	public ArrayList<Integer> u= new ArrayList<Integer>();
	public ArrayList<Integer> v= new ArrayList<Integer>();
	
	public double Mx = 0.0, 
				  My = 0.0, 
				  Mz = 0.0;
	
	private double NormM0=0.0;
	
	public double[]  f  = new double[3];
	public double[]  g  = new double[3];
	
	private double[] eOM = new double[3];
	private double[] ex = new double[3];
	private double[] ey = new double[3];
	private double[] egk = new double[3];
	
	public void ReadText(String uzanti) {
		File SP3 = new File(uzanti);
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(SP3));
			String read =buffer.readLine();
			while(read!=null) 
			{
				X.add(Double.valueOf(read.substring(0, 5)));
				Y.add(Double.valueOf(read.substring(8, 14)));
				Z.add(Double.valueOf(read.substring(14, read.length())));
				read= buffer.readLine();
			}
			buffer.close();
		}
		catch (IOException a) 
		{
			
		}
	}
	public void ImageCoordinate() 
	{
		int pointSize = X.size();
		
		for(int i=0 ; i<pointSize ; i++) 
		{
			Mx += X.get(i);
			My += Y.get(i);
			Mz += Z.get(i);
		}
		
		Mx = Mx / pointSize;
		My = My / pointSize;
		Mz = Mz / pointSize;
	
		NormM0 = Math.sqrt((Mx - Data.X0) * (Mx - Data.X0) + (My - Data.Y0) * (My - Data.Y0) + (Mz - Data.Z0) * (Mz-Data.Z0));
		
		eOM[0] = (Mx - Data.X0) / NormM0;
		eOM[1] = (My - Data.Y0) / NormM0;
		eOM[2] = (Mz - Data.Z0) / NormM0;
	
		f[0] = eOM[0] * Data.f + Data.X0;
		f[1] = eOM[1] * Data.f + Data.Y0;
		f[2] = eOM[2] * Data.f + Data.Z0;
	  
		ex[0] = eOM[1];				
		ex[1] =-eOM[0];			
		ex[2] = 0.0;	
		
		ey[0] = eOM[2] * eOM[0];
		ey[1] = eOM[2] * eOM[1];	
		ey[2] =-eOM[0] * eOM[0] - eOM[1] * eOM[1];	
		
		g[0] = 1.0 / 2.0 / Data.lamda * (ex[0] * (Data.rows + Data.dx) + ey[0] * (Data.cols + Data.dy));
		g[1] = 1.0 / 2.0 / Data.lamda * (ex[1] * (Data.rows + Data.dx) + ey[1] * (Data.cols + Data.dy));
		g[2] = ey[2];
	 
		g[0] = f[0] - g[0];
		g[1] = f[1] - g[1];
		g[2] = f[2] - g[2];
	
		for(int i=0 ; i<pointSize ; i++) 
		{
			double norm = Math.sqrt((X.get(i) - Data.X0) * (X.get(i) - Data.X0) + (Y.get(i) - Data.Y0) * (Y.get(i) - Data.Y0) + (Z.get(i) - Data.Z0) * (Z.get(i) - Data.Z0));
			
			X.set(i, (X.get(i) - Data.X0) / norm);
			Y.set(i, (Y.get(i) - Data.Y0) / norm);
			Z.set(i, (Z.get(i) - Data.Z0) / norm);
		
			norm = Data.f / (X.get(i) * eOM[0] + Y.get(i) * eOM[1] + Z.get(i) * eOM[2]);
			
			X.set(i,X.get(i) * norm + Data.X0);
			Y.set(i,Y.get(i) * norm + Data.Y0);
			Z.set(i,Z.get(i) * norm + Data.Z0);
		}
	}
	public void PixelCoordinate() 
	{
		double R[][] = new double[][] 
		{
			{Math.cos(Data.fi)*Math.cos(Data.K) ,
			-Math.cos(Data.fi)*Math.sin(Data.K) ,
			 Math.sin(Data.fi)},
		
		    {Math.cos(Data.w)*Math.sin(Data.K)+Math.sin(Data.w)*Math.sin(Data.fi)*Math.cos(Data.K) , 
			 Math.cos(Data.w)*Math.cos(Data.K)-Math.sin(Data.w)*Math.sin(Data.fi)*Math.sin(Data.K) ,
			-Math.sin(Data.w)*Math.cos(Data.fi)},
		
		    {Math.sin(Data.w)*Math.sin(Data.K)-Math.cos(Data.w)*Math.sin(Data.fi)*Math.cos(Data.K) ,
			 Math.sin(Data.w)*Math.cos(Data.K)+Math.cos(Data.w)*Math.sin(Data.fi)*Math.sin(Data.K) ,
			 Math.cos(Data.w)*Math.cos(Data.fi)}	
		};
		
		int pointSize=X.size();
	
		for(int i=0 ; i<pointSize ; i++) 
		{
			egk[0] = (X.get(i) - g[0]) * R[0][0] + (Y.get(i) - g[1]) * R[0][1] + (Z.get(i) - g[2]) * R[0][2];
			egk[1] = (X.get(i) - g[0]) * R[1][0] + (Y.get(i) - g[1]) * R[1][1] + (Z.get(i) - g[2]) * R[1][2];
			egk[2] = (X.get(i) - g[0]) * R[2][0] + (Y.get(i) - g[1]) * R[2][1] + (Z.get(i) - g[2]) * R[2][2];
		
			double norm = Math.sqrt(egk[0] * egk[0] + egk[1] * egk[1] + egk[2] * egk[2]);
		
			egk[0] = egk[0] / norm;
			egk[1] = egk[1] / norm;
			egk[2] = egk[2] / norm;
		
			double Beta = ex[0] * egk[0] + ex[1] * egk[1] + ex[2] * egk[2];
			
			u.add((int)(Data.lamda * norm * Beta));
			v.add((int)(Data.lamda * norm * Math.sin(Math.acos(Beta))));
		}
	}
}
