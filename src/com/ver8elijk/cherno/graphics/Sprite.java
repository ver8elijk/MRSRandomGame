package com.ver8elijk.cherno.graphics;

public class Sprite {

	public final int SPRITE_SIZE;
	private int x, y;
	public int[] spritePixels;
	private Spritesheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, Spritesheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, Spritesheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x0000ff);

	public static Sprite playerBack0 = new Sprite(16, 2, 1, Spritesheet.tiles);
	public static Sprite playerBack1 = new Sprite(16, 2, 2, Spritesheet.tiles);
	public static Sprite playerBack2 = new Sprite(16, 2, 3, Spritesheet.tiles);

	public static Sprite playerFront0 = new Sprite(16, 0, 1, Spritesheet.tiles);
	public static Sprite playerFront1 = new Sprite(16, 0, 2, Spritesheet.tiles);
	public static Sprite playerFront2 = new Sprite(16, 0, 3, Spritesheet.tiles);

	public static Sprite playerSide0 = new Sprite(16, 1, 1, Spritesheet.tiles);
	public static Sprite playerSide1 = new Sprite(16, 1, 2, Spritesheet.tiles);
	public static Sprite playerSide2 = new Sprite(16, 1, 3, Spritesheet.tiles);

	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SPRITE_SIZE = size;
		spritePixels = new int[SPRITE_SIZE * SPRITE_SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SPRITE_SIZE = size;
		spritePixels = new int[SPRITE_SIZE * SPRITE_SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SPRITE_SIZE * SPRITE_SIZE; i++) {
			spritePixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SPRITE_SIZE; y++) {
			for (int x = 0; x < SPRITE_SIZE; x++) {
				spritePixels[x + y * SPRITE_SIZE] = sheet.sheetPixels[(x + this.x)
						+ (y + this.y) * sheet.SHEET_SIZE];
			}
		}

	}
}
