package com.ver8elijk.cherno.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private String path;
	public final int SHEET_SIZE;
	public int[] sheetPixels;

	public static Spritesheet tiles = new Spritesheet(
			"/textures/spritesheet.png", 256);

	public Spritesheet(String path, int size) {
		this.path = path;
		this.SHEET_SIZE = size;
		sheetPixels = new int[SHEET_SIZE * SHEET_SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, sheetPixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
