package com.robert.pong;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {
	
	private Rectangle firstPong, secondPong;
	private float gameWidth, gameHeight;
	private Circle ball;
	private boolean started;
	private Vector2 ballOffset;
	
	public GameWorld(float width, float height) {
		
		gameWidth = width;
		gameHeight = height;
		firstPong = new Rectangle(10, height/2 - 15, 15, 80);
		secondPong = new Rectangle(width - 25, height/2 - 15, 15, 80);
		ball = new Circle(gameWidth/2, gameHeight/2, 7);
		started = false;
	}
	
	public Rectangle getFirstPong() {
		
		return firstPong;
	}
	
	public Rectangle getSecondPong() {
		
		return secondPong;
	}
	
	public Circle getBall() {
		
		return ball;
	}
	
	public void moveFirstUp() {
		
		if(firstPong.y + firstPong.height < gameHeight)
			firstPong.y += 10;
	}
	
	public void moveFirstDown() {
		
		if(firstPong.y > 0)
			firstPong.y -= 10;
	}
	
	public void moveSecondUp() {
		
		if(secondPong.y + secondPong.height < gameHeight)
			secondPong.y += 10;
	}
	
	public void moveSecondDown() {
		
		if(secondPong.y > 0)
			secondPong.y -= 10;
	}
	
	public void updateBall() {
		
		if(!started) {
			
			started = true;
			ballOffset = new Vector2();
			ballOffset.x = 2.0f;
			ballOffset.y = 2.0f;
		}
		else {
			
			ball.x += ballOffset.x;
			ball.y += ballOffset.y;
			float x = ball.x;
			float y = ball.y;
			
			if(x >= gameWidth - ball.radius)
				ballOffset.x = -ballOffset.x;
			else
				if(x <= ball.radius)
					ballOffset.x = -ballOffset.x;
			
			if(y >= gameHeight - ball.radius)
				ballOffset.y = -ballOffset.y;
			else
				if(y <= ball.radius)
					ballOffset.y = -ballOffset.y;
			
			if(Intersector.overlaps(ball, firstPong)) {
				
				if(ballOffset.y > 0.0)
					ballOffset.rotate(-90);
				else
					ballOffset.rotate(90);
			}
		}
	}
	
}
