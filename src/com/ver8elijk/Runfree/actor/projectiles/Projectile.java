package com.ver8elijk.Runfree.actor.projectiles;

import com.ver8elijk.Runfree.actor.Actor;
import com.ver8elijk.Runfree.graphics.Sprite;

public abstract class Projectile extends Actor {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double newX, newY;
	protected double speed, range, RoF, damage, damageType;

	public Projectile(int x, int y, double projectileDirection) {
		this.x = x;
		this.y = y;
		xOrigin = x;
		yOrigin = y;
		angle = projectileDirection;

	}
}
