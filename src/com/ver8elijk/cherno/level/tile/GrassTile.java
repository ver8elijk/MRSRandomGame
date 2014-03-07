package com.ver8elijk.cherno.level.tile;

import com.ver8elijk.cherno.graphics.Screen;
import com.ver8elijk.cherno.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
