package com.ver8elijk.Runfree.level.tile;

import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.rock);
	}

	public boolean solid() {
		return true;
	}

}