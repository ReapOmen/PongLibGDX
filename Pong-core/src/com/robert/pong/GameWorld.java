package com.robert.pong;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents the world of Pong. It handles collision and game objects.
 * @author robert
 *
 */
public class GameWorld {
	
	private Paddle firstPaddle, secondPaddle;
	
	private int gameWidth, gameHeight;
	
	private boolean start;
	
	private Ball ball;
	
	/**
	 * Creates a GameWorld, that is the backend of the game of Pong, for a certain screen size.
	 * @param width the width of the screen
	 * @param height the height of the screen
	 */
	public GameWorld(int width, int height) {
		
		gameWidth = width;
		gameHeight = height;
		
		firstPaddle = new Paddle(gameWidth, gameHeight, Paddle.ONE);
		secondPaddle = new Paddle(gameWidth, gameHeight, Paddle.TWO);
		
		ball = new Ball(gameWidth, gameHeight);
		
		start = false; // true when the game starts
	}
	
	/**
	 * Gets the first Paddle of this GameWorld (the left Paddle).
	 * @return the first Paddle of the game
	 */
	public Paddle getFirstPaddle() {
		
		return firstPaddle;
	}
	
	/**
	 * Gets the second Paddle of this GameWorld (the right Paddle).
	 * @return the second Paddle of the game
	 */
	public Paddle getSecondPaddle() {
		
		return secondPaddle;
	}
	
	/**
	 * Gets the Ball of this GameWorld.
	 * @return the Ball of the game
	 */
	public Ball getBall() {
		
		return ball;
	}
	
	/**
	 * Updates the position of the Ball and changes its direction when necessary.
	 */
	public void updateBall() {
		
		if(start) {
			
			ball.update();
			
			checkWallCollision();
			checkPaddleCollision(firstPaddle);
			checkPaddleCollision(secondPaddle);
		}
	}

	/**
	 * Checks whether the Ball collided with the upper/down side of the screen
	 * and rotates the speed vector of the ball accordingly.
	 */
	private void checkWallCollision() {
		
		float y = ball.getPosition().y;
		float rad = ball.getRadius();
		
		if(y + rad >= gameHeight || y - rad <= 0) {
			
			ball.setRotation(getWallRotation());
			
		}
	}
	
	/**
	 * Checks whether the Ball collided with any Paddle
	 * and rotates the speed vector of the ball accordingly.
	 */
	private void checkPaddleCollision(Paddle p) {

		if(Intersector.overlaps(ball.getCircle(), p.getRectangle())) {
			
			ball.setRotation(getPaddleRotation());
		}	
			
	}
	
	/**
	 * Gets the degrees by which the speed vector of the Ball should be rotated by
	 * when it hits a Paddle.
	 * @return the degrees for rotating the Ball.
	 */
	private float getPaddleRotation() {
		
		Vector2 speed = ball.getSpeed();
		float angle = Vector2.Y.angle(speed);
		return -angle*2;
	}
	
	
	/**
	 * Gets the degrees by which the speed vector of the Ball should be rotated by
	 * when it hits a wall.
	 * @return the degrees for rotating the Ball.
	 */
	private float getWallRotation() {
		
		Vector2 speed = ball.getSpeed();
		float angle = Vector2.X.angle(speed);
		return -angle*2;
	}

	/**
	 * Moves the first Paddle upwards (the left Paddle).
	 */
	public void moveFirstUp() {
		
		firstPaddle.moveUp();
	}
	
	/**
	 * Moves the second Paddle upwards (the right Paddle).
	 */
	public void moveSecondUp() {
		
		secondPaddle.moveUp();
	}
	
	/**
	 * Moves the first Paddle downwards (the left Paddle).
	 */
	public void moveFirstDown() {
		
		firstPaddle.moveDown();
	}
	
	/**
	 * Moves the second Paddle downwards (the right Paddle).
	 */
	public void moveSecondDown() {
		
		secondPaddle.moveDown();
	}
	
	/**
	 * Starts the game of Pong.
	 */
	public void start() {
		
		start = true;
		ball.randomiseRotation();
	}
	
	/**
	 * Returns a true value if the game started or false otherwise.
	 * @return true if the game of Pong has started, false otherwise
	 */
	public boolean hasStarted() {
		
		return start;
	}
	
}
