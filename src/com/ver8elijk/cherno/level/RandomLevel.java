package com.ver8elijk.cherno.level;

import java.util.Random;

public class RandomLevel extends Level {

	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);

	}

	protected void generateLevel() {
		for (int y = 0; y < levelHeight; y++) {
			for (int x = 0; x < levelWidth; x++) {
				tilesInt[x + y * levelWidth] = random.nextInt(3);
			}
		}
	}

}
