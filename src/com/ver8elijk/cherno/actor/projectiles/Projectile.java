package com.ver8elijk.cherno.actor.projectiles;

import com.ver8elijk.cherno.actor.Actor;
import com.ver8elijk.cherno.graphics.Sprite;

public abstract class Projectile extends Actor {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;

	public Projectile(int x, int y, double projectileDirection) {
		xOrigin = x;
		yOrigin = y;
		angle = projectileDirection;
	}
}
