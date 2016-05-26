package com.robert.pong;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents a Paddle in the game of Pong.
 * @author robert
 *
 */
public class Paddle {
	
	/**Use this value in the constructor to create the LEFT paddle.*/
	public static int ONE = 1;
	/**Use this value in the constructor to create the RIGHT paddle.*/
	public static int TWO = 2;
	
	private Rectangle rect;
	
	private int screenWidth, screenHeight;
	private int paddleWidth, paddleHeight;
	
	private Vector2 position;
	private static Vector2 speed = new Vector2(0.0f, 10.0f);
	
	/**
	 * Creates a paddle of the game pong.
	 * @param sW the width of the screen on which the paddle will be shown
	 * @param sH the height of the screen on which the paddle will be shown
	 * @param choice which paddle of the game will this instance represent
	 */
	public Paddle(int sW, int sH, int choice) {
		
		screenWidth = sW;
		screenHeight = sH;
		
		paddleWidth = screenWidth / 60;
		paddleHeight = screenHeight / 6;
		
		int x = 0;
		if(choice == ONE)
			x = 15;
		else
			if(choice == TWO)
				x = screenWidth - paddleWidth - 15;
		int y = (int) ((screenHeight-paddleHeight) / 2);
		
		position = new Vector2(x, y);
		
		rect = new Rectangle(x, y, paddleWidth, paddleHeight);
	}
	
	/**
	 * Gets the rectangle that represents this paddle.
	 * @return the rectangle representing this paddle.
	 */
	public Rectangle getRectangle() {
		
		return rect;
	}
	
	/**
	 * Gets the position of the bottom-left corner of this Paddle.
	 * @return the position of the bottom-left corner.
	 */
	public Vector2 getPosition() {
		
		return position;
	}
	
	/**
	 * Gets the width of this Paddle.
	 * @return the width of the paddle.
	 */
	public int getWidth() {
		
		return paddleWidth;
	}
	
	/**
	 * Gets the height of this Paddle.
	 * @return the height of the paddle.
	 */
	public int getHeight() {
		
		return paddleHeight;
	}

	/**
	 * Increases the paddles position on the Y axis.
	 */
	public void moveUp() {
		
		if(position.y + paddleHeight < screenHeight) {
			
			position.y += speed.y;
			rect.setPosition(position);
		}
	}
	
	/**
	 * Decreases the paddles position on the Y axis.
	 */
	public void moveDown() {
		
		if(position.y > 0) {
			
			position.y -= speed.y;
			rect.setPosition(position);
		}
	}
}
