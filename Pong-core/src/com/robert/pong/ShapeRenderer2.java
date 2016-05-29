package com.robert.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

/**
 * Represents a ShapeRenderer that is used to draw objects of the game Pong.
 * @author robert
 *
 */
public class ShapeRenderer2 {

	private ShapeRenderer s;
	
	/**
	 * Creates a new ShapeRenderer2
	 */
	public ShapeRenderer2() {
		
		s = new ShapeRenderer();
	}
	
	/**
	 * Draws a paddle on the screen.
	 * @param p the paddle to be drawn on screen
	 */
	public void drawPaddle(Paddle p) {
		
		drawRect(p.getRectangle());
	}
	
	/**
	 * Draws a ball on the screen.
	 * @param b the ball to be drawn on screen
	 */
	public void drawBall(Ball b) {
		
		drawCircle(b.getCircle());
	}
	
	/**
	 * Draws a rectangle on the screen.
	 * @param r the rectangle to be drawn on screen
	 */
	public void drawRect(Rectangle r) {
		
		float x = r.getX();
		float y = r.getY();
		float w = r.getWidth();
		float h = r.getHeight();
		s.begin(ShapeType.Filled);
		s.rect(x, y, w, h);
		s.end();
	}
	
	/**
	 * Draws a circle on the screen.
	 * @param c the circle to be drawn on screen
	 */
	public void drawCircle(Circle c) {
		
		float x = c.x;
		float y = c.y;
		float r = c.radius;
		s.begin(ShapeType.Filled);
		s.circle(x, y, r);
		s.end();
	}
}
