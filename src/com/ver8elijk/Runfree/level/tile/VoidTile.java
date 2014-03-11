package com.ver8elijk.Runfree.level.tile;

import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.voidSprite);
	}

	public boolean solid() {
		return true;
	}
}
