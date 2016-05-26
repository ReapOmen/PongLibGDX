package com.robert.pong;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {
	
	private Paddle firstPaddle, secondPaddle;
	private int gameWidth, gameHeight;
	private Circle ball;
	private boolean started;
	private Vector2 ballOffset;
	
	public GameWorld(int width, int height) {
		
		gameWidth = width;
		gameHeight = height;
		
		firstPaddle = new Paddle(gameWidth, gameHeight, Paddle.ONE);
		secondPaddle = new Paddle(gameWidth, gameHeight, Paddle.TWO);
		
		ball = new Circle(gameWidth/2, gameHeight/2, 7);
		
		started = false;
	}
	
	public Paddle getFirstPaddle() {
		
		return firstPaddle;
	}
	
	public Paddle getSecondPaddle() {
		
		return secondPaddle;
	}
	
	public Circle getBall() {
		
		return ball;
	}
	
	public void updateBall() {
		
		if(!started) {
			
			started = true;
			ballOffset = new Vector2();
			ballOffset.x = 2.5f;
			ballOffset.y = 2.5f;
		}
		else {
			
			ball.x += ballOffset.x;
			ball.y += ballOffset.y;
			float x = ball.x;
			float y = ball.y;
			
			if(x >= gameWidth - ball.radius || x <= ball.radius) {
				started = false;
				ball.setPosition(gameWidth/2, gameHeight/2);
			}

			
			if(y >= gameHeight - ball.radius)
				ballOffset.y = -ballOffset.y;
			else
				if(y <= ball.radius)
					ballOffset.y = -ballOffset.y;
			
			if(Intersector.overlaps(ball, firstPaddle.getRectangle())) {
				
				if(ballOffset.y > 0.0)
					ballOffset.rotate(-90);
				else
					ballOffset.rotate(90);
			}
			
			if(Intersector.overlaps(ball, secondPaddle.getRectangle())) {
	
				if(ballOffset.y > 0.0)
					ballOffset.rotate(90);
				else
					ballOffset.rotate(-90);
			}
		}
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
	
}
