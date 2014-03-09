package com.ver8elijk.cherno.actor.mobs;

import com.ver8elijk.cherno.Game;
import com.ver8elijk.cherno.graphics.Screen;
import com.ver8elijk.cherno.graphics.Sprite;
import com.ver8elijk.cherno.input.Keyboard;
import com.ver8elijk.cherno.input.Mouse;

public class Player extends Mobs {
	private Keyboard input;
	private Sprite sprite;
	private int animateCount = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xMoveDirection = 0, yMoveDirection = 0;

		if (animateCount < 4096) {
			animateCount++;
		} else
			animateCount = 0;

		if (input.up)
			yMoveDirection--;
		if (input.down)
			yMoveDirection++;
		if (input.left)
			xMoveDirection--;
		if (input.right)
			xMoveDirection++;
		if (xMoveDirection != 0 || yMoveDirection != 0) {
			move(xMoveDirection, yMoveDirection);
			walking = true;
		} else
			walking = false;

		if (Mouse.getButton() == 1) {
			double projectileDirection = 0;
			double directionX = Mouse.getX() - Game.frameWidth
					* Game.renderScale / 2;
			double directionY = Mouse.getY() - Game.frameHeight
					* Game.renderScale / 2;
			projectileDirection = Math.atan2(directionY, directionX);
			shoot(x, y, projectileDirection);
		}

	}

	public void render(Screen screen) {
		int flip = 0;
		if (direction == 2) {
			sprite = Sprite.playerBack0;
			if (walking) {
				if (animateCount % 20 > 10) {
					sprite = Sprite.playerBack1;
				} else
					sprite = Sprite.playerBack2;
			}
		}

		if (direction == 0) {
			sprite = Sprite.playerFront0;
			if (walking) {
				if (animateCount % 20 > 10) {
					sprite = Sprite.playerFront1;
				} else
					sprite = Sprite.playerFront2;
			}
		}
		if (direction == 1) {
			sprite = Sprite.playerSide0;
			if (walking) {
				if (animateCount % 20 > 10) {
					sprite = Sprite.playerSide1;
				} else
					sprite = Sprite.playerSide2;
			}
		}
		if (direction == 3) {
			sprite = Sprite.playerSide0;
			if (walking) {
				if (animateCount % 20 > 10) {
					sprite = Sprite.playerSide1;
				} else
					sprite = Sprite.playerSide2;
			}
			flip = 1;
		}

		screen.renderPlayer(x, y, sprite, flip);
	}

}
