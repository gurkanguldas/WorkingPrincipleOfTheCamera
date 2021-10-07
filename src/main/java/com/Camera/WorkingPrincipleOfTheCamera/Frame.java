package com.Camera.WorkingPrincipleOfTheCamera;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame {
	
	public static void Show() 
	{
		JFrame fr = new JFrame();
		fr.setSize(800, 600);
		fr.setLocation(100, 100);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		panel.actions();
		fr.add(panel);
		fr.setVisible(true);
	}
}
