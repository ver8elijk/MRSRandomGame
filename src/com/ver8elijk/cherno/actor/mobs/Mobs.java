package com.ver8elijk.cherno.actor.mobs;

import com.ver8elijk.cherno.actor.Actor;
import com.ver8elijk.cherno.graphics.Sprite;

public abstract class Mobs extends Actor {
	protected Sprite sprite;
	protected int direction;
	protected boolean moving = false;

	public void move(int xMove, int yMove) {
		if (xMove > 0)
			direction = 1;
		if (xMove < 0)
			direction = 3;
		if (yMove > 0)
			direction = 2;
		if (yMove < 0)
			direction = 0;
		if (!colliding()) {
			x += xMove;
			y += yMove;
		}
	}

	public void update() {

	}

	public void render() {

	}

	private boolean colliding() {
		return false;
	}
}
