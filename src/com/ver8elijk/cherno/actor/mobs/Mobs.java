package com.ver8elijk.cherno.actor.mobs;

import com.ver8elijk.cherno.actor.Actor;
import com.ver8elijk.cherno.graphics.Sprite;

public abstract class Mobs extends Actor {
	protected Sprite sprite;
	protected int direction;
	protected boolean moving = false;

	public void move(int xMove, int yMove) {
		if (xMove != 0 && yMove != 0) {
			move(xMove, 0);
			move(0, yMove);
			return;
		}
		if (xMove > 0)
			direction = 1;
		if (xMove < 0)
			direction = 3;
		if (yMove > 0)
			direction = 2;
		if (yMove < 0)
			direction = 0;
		if (!colliding(xMove, yMove)) {
			x += xMove;
			y += yMove;
		}
	}

	public void update() {

	}

	public void render() {

	}

	protected void shoot(int x, int y, double projectileDirection) {
		projectileDirection = Math.toDegrees(projectileDirection);
	}

	private boolean colliding(int xMove, int yMove) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) {
			int xCorner = ((x + xMove) + corner % 2 * 4 + 6) / 16;
			int yCorner = ((y + yMove) + corner / 2 * 4 + 9) / 16;
			if (level.getTile(xCorner, yCorner).solid())
				solid = true;
		}
		return solid;
	}
}
