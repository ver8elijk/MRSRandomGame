package com.ver8elijk.Runfree.actor;

import java.util.Random;

import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.level.Level;

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

	public void init(Level level) {
		this.level = level;
	}
}
