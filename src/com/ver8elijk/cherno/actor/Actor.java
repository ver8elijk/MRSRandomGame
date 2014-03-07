package com.ver8elijk.cherno.actor;

import java.util.Random;

import com.ver8elijk.cherno.graphics.Screen;
import com.ver8elijk.cherno.level.Level;

public abstract class Actor {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {

	}

	public void render(Screen screen) {

	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}
}
