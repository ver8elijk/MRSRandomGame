package com.ver8elijk.Runfree.actor.projectiles;

import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.graphics.Sprite;

public class Arrow extends Projectile {

	public Arrow(int x, int y, double projectileDirection) {
		super(x, y, projectileDirection);
		speed = 4;
		range = 480;
		RoF = 2;
		damage = 5;
		damageType = 0;

		sprite = Sprite.arrow;
		newX = speed * Math.cos(angle);
		newY = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		x += newX;
		y += newY;
		if (calculateDistance() > range)
			remove();
	}

	public double calculateDistance() {
		double distance = 0;
		distance = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x)
				+ (yOrigin - y) * (yOrigin - y)));
		return distance;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x, (int) y, this);
	}
}
