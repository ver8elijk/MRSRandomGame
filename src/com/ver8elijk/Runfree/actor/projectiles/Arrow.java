package com.ver8elijk.Runfree.actor.projectiles;

import com.ver8elijk.Runfree.graphics.Screen;
import com.ver8elijk.Runfree.graphics.Sprite;

public class Arrow extends Projectile {

	public Arrow(int x, int y, double projectileDirection) {
		super(x, y, projectileDirection);
		speed = 2;
		range = 240;
		RoF = 2;
		damage = 5;
		damageType = 0;

		sprite = Sprite.rock;
		newX = speed * Math.cos(angle);
		newY = speed * Math.sin(angle);
	}

	public void update() {
		move();
	}

	protected void move() {
		x += newX;
		y += newY;
	}

	public void render(Screen screen) {
		screen.renderTile(x, y, sprite);
	}
}
