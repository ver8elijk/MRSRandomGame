package com.ver8elijk.Runfree.graphics;

import com.ver8elijk.Runfree.level.tile.Tile;

public class Screen {
	public int screenWidth;
	public int screenHeight;
	public int[] screenPixels;
	public int xOffset, yOffset;

	public Screen(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		screenPixels = new int[width * height];
	}

	public void renderTile(int xPosition, int yPosition, Tile tile) {
		xPosition -= xOffset;
		yPosition -= yOffset;
		for (int y = 0; y < tile.sprite.SPRITE_SIZE; y++) {
			int yTranslate = y + yPosition;
			for (int x = 0; x < tile.sprite.SPRITE_SIZE; x++) {
				int xTranslate = x + xPosition;
				if (xTranslate < -tile.sprite.SPRITE_SIZE
						|| xTranslate >= screenWidth || yTranslate < 0
						|| yTranslate >= screenHeight)
					break;
				if (xTranslate < 0)
					xTranslate = 0;
				screenPixels[xTranslate + yTranslate * screenWidth] = tile.sprite.spritePixels[x
						+ y * tile.sprite.SPRITE_SIZE];
			}
		}
	}

	public void renderPlayer(int xPosition, int yPosition, Sprite sprite,
			int flip) {
		xPosition -= xOffset;
		yPosition -= yOffset;
		for (int y = 0; y < 16; y++) {
			int yTranslate = y + yPosition;
			int ySprite = y;
			if (flip == 2 || flip == 3) {
				ySprite = 15 - y;
			}
			for (int x = 0; x < 16; x++) {
				int xTranslate = x + xPosition;
				int xSprite = x;
				if (flip == 1 || flip == 3) {
					xSprite = 15 - x;
				}
				if (xTranslate < -16 || xTranslate >= screenWidth
						|| yTranslate < 0 || yTranslate >= screenHeight)
					break;
				if (xTranslate < 0)
					xTranslate = 0;
				int color = sprite.spritePixels[xSprite + ySprite * 16];
				if (color != 0xffff00ff)
					screenPixels[xTranslate + yTranslate * screenWidth] = color;
			}
		}
	}

	public void clear() {
		for (int i = 0; i < screenPixels.length; i++) {
			screenPixels[i] = 0;
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
