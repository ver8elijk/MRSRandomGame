package com.ver8elijk.Runfree.level;

import java.util.ArrayList;
import java.util.List;

import com.ver8elijk.Runfree.actor.Actor;
import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.level.tile.Tile;

public class Level {

	protected int levelWidth, levelHeight;
	protected int[] tilesInt;
	protected int tiles[];
	private List<Actor> entities = new ArrayList<Actor>();

	public Level(int width, int height) {
		this.levelWidth = width;
		this.levelHeight = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	public boolean collidingWithTile(double x, double y, double newX,
			double newY, int size) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) {
			int xCorner = (((int) x + (int) newX) + corner % 2 * (size / 2) + 6) / 16;
			int yCorner = (((int) y + (int) newY) + corner / 2 * (size / 2) + 6) / 16;
			if (getTile(xCorner, yCorner).solid())
				solid = true;
		}
		return solid;
	}

	public void add(Actor e) {
		e.init(this);
		entities.add(e);
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.screenWidth + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.screenHeight + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			if (!entities.get(i).isRemoved())
				entities.get(i).render(screen);
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= levelWidth || y < 0 || y >= levelHeight)
			return Tile.voidTile;
		if (tiles[x + y * levelWidth] == 0xff00ff00)
			return Tile.grass;
		if (tiles[x + y * levelWidth] == 0xffffff00)
			return Tile.flower;
		if (tiles[x + y * levelWidth] == 0xff666666)
			return Tile.rock;
		return Tile.voidTile;

	}
}
