package com.robert.pong;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {
	
	private Paddle firstPaddle, secondPaddle;
	private int gameWidth, gameHeight;
	private boolean start;
	private Ball ball;
	
	public GameWorld(int width, int height) {
		
		gameWidth = width;
		gameHeight = height;
		
		firstPaddle = new Paddle(gameWidth, gameHeight, Paddle.ONE);
		secondPaddle = new Paddle(gameWidth, gameHeight, Paddle.TWO);
		
		ball = new Ball(gameWidth, gameHeight);
		
		start = false;
	}
	
	public Paddle getFirstPaddle() {
		
		return firstPaddle;
	}
	
	public Paddle getSecondPaddle() {
		
		return secondPaddle;
	}
	
	public Ball getBall() {
		
		return ball;
	}
	
	public void updateBall() {
		
		if(start) {
			
			ball.update();
			
			checkWallCollision();
			checkPaddleCollision(firstPaddle);
			checkPaddleCollision(secondPaddle);
		}
	}

	private void checkWallCollision() {
		
		float y = ball.getPosition().y;
		float rad = ball.getRadius();
		
		if(y + rad >= gameHeight || y - rad <= 0) {
			
			ball.setRotation(getWallRotation());
			
		}
	}
	
	private void checkPaddleCollision(Paddle p) {

		if(Intersector.overlaps(ball.getCircle(), p.getRectangle())) {
			
			ball.setRotation(getPaddleRotation());
		}	
			
	}
	
	private float getPaddleRotation() {
		
		Vector2 speed = ball.getSpeed();
		float angle = Vector2.Y.angle(speed);
		return -angle*2;
	}
	
	private float getWallRotation() {
		
		Vector2 speed = ball.getSpeed();
		float angle = Vector2.X.angle(speed);
		return -angle*2;
	}

	public void moveFirstUp() {
		
		firstPaddle.moveUp();
	}
	
	public void moveSecondUp() {
		
		secondPaddle.moveUp();
	}
	
	public void moveFirstDown() {
		
		firstPaddle.moveDown();
	}
	
	public void moveSecondDown() {
		
		secondPaddle.moveDown();
	}
	
	public void start() {
		
		start = true;
		ball.randomiseRotation();
	}
	
}
