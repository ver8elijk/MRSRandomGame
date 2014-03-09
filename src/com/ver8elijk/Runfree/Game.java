package com.ver8elijk.Runfree;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.ver8elijk.Runfree.actor.mobs.Player;
import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.input.Keyboard;
import com.ver8elijk.Runfree.input.Mouse;
import com.ver8elijk.Runfree.level.Level;
import com.ver8elijk.Runfree.level.StartLevel;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8337543318458996576L;

	// Window related variables
	public static int frameWidth = 640;
	public static int frameHeight = frameWidth / 16 * 9;
	public static int renderScale = 2;
	public static String title = "Run Free";
	private JFrame frame;
	// Thread related variables
	private Thread thread;
	private boolean gameRunning = false;

	private BufferedImage image = new BufferedImage(frameWidth, frameHeight,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	private Screen screen;
	private Level level;
	private Player player;
	private Keyboard key;

	Random rand = new Random();

	//
	// Main Constructor
	//
	public Game() {
		Dimension size = new Dimension(frameWidth * renderScale, frameHeight
				* renderScale);
		setPreferredSize(size);
		screen = new Screen(frameWidth, frameHeight);
		frame = new JFrame();
		key = new Keyboard();
		level = new StartLevel("/textures/level.png");
		player = new Player(3 * 16, 3 * 16, key);
		player.init(level);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(key);
	}

	// Start a new thread
	public synchronized void start() {
		gameRunning = true;
		Thread thread = new Thread(this, "Display");
		thread.start();
	}

	// Stop thread by joining
	public synchronized void stop() {
		gameRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//
	//
	//
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		// game loop
		while (gameRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {// call to update
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			// upd,fps counter
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " - Updates: " + updates + " , "
						+ "Frames: " + frames);
				frames = 0;
				updates = 0;
			}

		}
	}

	// update all elements
	private void update() {
		key.update();
		player.update();

	}

	private void render() {
		// create backbuffer
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}

		// clear screen then render
		screen.clear();
		int xScroll = player.x - screen.screenWidth / 2;
		int yScroll = player.y - screen.screenHeight / 2;

		/*
		 * render all individual elements
		 */
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		// draw from the pixel array to the backbuffer
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.screenPixels[i];
		}

		Graphics gfx = buffer.getDrawGraphics();
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, getWidth(), getHeight());
		gfx.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// Draw the rest

		gfx.setColor(Color.WHITE);
		gfx.setFont(new Font("Arial", 0, 12));
		gfx.drawString("Player X:" + player.x + ",Y:" + player.y, 4, 16);
		gfx.drawString("Mouse X:" + Mouse.getX() + " Y:" + Mouse.getY()
				+ " Button:" + Mouse.getButton(), 4, 32);
		gfx.dispose();
		buffer.show();

	}

	//
	// Main method
	//
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
}
