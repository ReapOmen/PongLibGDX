package com.robert.pong;

import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class Ball {
	
	private Circle circ;
	private int screenWidth, screenHeight;
	private Vector2 position, speed;
	private Vector2 initialState;
	
	public Ball(int gameWidth, int gameHeight) {
		
		screenWidth = gameWidth;
		screenHeight = gameHeight;
		
		float x = screenWidth/2.0f;
		float y = screenHeight/2.0f;

		position = new Vector2(x, y);
		initialState = new Vector2(x, y);
		speed = new Vector2(3.5f, 3.5f);
		
		
		circ = new Circle(x, y, 7);
	}
	
	public Circle getCircle() {
		
		return circ;
	}
	
	public void randomiseRotation() {
		

		Random r = new Random();
		int x = r.nextInt(360);
		speed.rotate(x);
	}
	
	public void update() {
		
		position.add(speed);
		circ.setPosition(position);
	}
	
	public void setRotation(float degrees) {
		
		speed.rotate(degrees);
		System.out.println("Rotated by: " + degrees);
	}
	
	public void setPosition(Vector2 f) {
		
		position.x = f.x;
		position.y = f.y;
		circ.setPosition(position);
	}
	
	public Vector2 getPosition() {
		
		return position;
	}
	
	public Vector2 getInitialState() {
		
		return initialState;
	}
	
	public Vector2 getSpeed() {
		
		return speed;
	}
	
	public float getRadius() {
		
		return circ.radius;
	}

}
