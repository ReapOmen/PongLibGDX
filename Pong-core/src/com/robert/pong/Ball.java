package com.robert.pong;

import java.util.Random;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents the ball in the game of Pong.
 * @author robert
 *
 */
public class Ball {
	
	private Circle circ;
	
	private int screenWidth, screenHeight;
	
	private Vector2 position, speed;
	private Vector2 initialState; // the initial state of the ball
	
	/**
	 * Creates a ball that can be moved at a certain speed.
	 * @param gameWidth the width of the screen
	 * @param gameHeight the height of the screen
	 */
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
	
	/**
	 * Gets the circle that represents this ball.
	 * @return the circle representing this ball.
	 */
	public Circle getCircle() {
		
		return circ;
	}
	
	/**
	 * Rotates the speed vector by a random amount.
	 */
	public void randomiseRotation() {
		

		Random r = new Random();
		int x = r.nextInt(360);
		speed.rotate(x);
	}
	
	/**
	 * Updates the position of the ball using the speed vector.
	 */
	public void update() {
		
		position.add(speed);
		circ.setPosition(position);
	}
	
	/**
	 * Sets the rotation of the speed vector.
	 * @param degrees the amount of degrees the vector should be rotated
	 */
	public void setRotation(float degrees) {
		
		speed.rotate(degrees);
	}
	
	/**
	 * Gets the position vector of this ball (the coordinates of the center).
	 * @return the ball's current position.
	 */
	public Vector2 getPosition() {
		
		return position;
	}
	
	/**
	 * Gets the initial state vector (position) of this ball.
	 * @return the initial state vector of this ball.
	 */
	public Vector2 getInitialState() {
		
		return initialState;
	}
	
	/**
	 * Gets the speed vector of this ball.
	 * @return the speed vector of this ball.
	 */
	public Vector2 getSpeed() {
		
		return speed;
	}
	
	/**
	 * Gets the radius of this ball.
	 * @return the radius of this ball.
	 */
	public float getRadius() {
		
		return circ.radius;
	}

}
