package com.robert.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class ShapeRenderer2 {

	private ShapeRenderer s;
	
	public ShapeRenderer2() {
		
		s = new ShapeRenderer();
	}
	
	public void drawRect(Rectangle r) {
		
		float x = r.getX();
		float y = r.getY();
		float w = r.getWidth();
		float h = r.getHeight();
		s.begin(ShapeType.Filled);
		s.rect(x, y, w, h);
		s.end();
	}
	
	public void drawCircle(Circle c) {
		
		float x = c.x;
		float y = c.y;
		float r = c.radius;
		s.begin(ShapeType.Filled);
		s.circle(x, y, r);
		s.end();
	}
}
