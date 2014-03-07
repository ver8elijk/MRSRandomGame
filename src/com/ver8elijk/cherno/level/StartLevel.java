package com.ver8elijk.cherno.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StartLevel extends Level {

	public StartLevel(String path) {
		super(path);

	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(StartLevel.class
					.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			this.levelWidth = width;
			this.levelHeight = height;
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			System.out.println("Couldn't load level file:");
			e.printStackTrace();
		}
	}

	// grs 00ff00 flw ffff00 rk 666666
	protected void generateLevel() {

	}
}
