package com.robert.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Renderer {
	
	private ShapeRenderer2 sr;
	private GameWorld world;
	
	public Renderer(GameWorld w) {
		
		world = w;
		sr = new ShapeRenderer2();
	}
	
	public void render() {
		
		handleInput();
		
		world.updateBall();
		sr.drawPaddle(world.getFirstPaddle());
		sr.drawPaddle(world.getSecondPaddle());
		sr.drawCircle(world.getBall());
	
	}

	private void handleInput() {
		
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			
			world.moveSecondUp();
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			
			world.moveSecondDown();
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)) {
			
			world.moveFirstUp();
		}
		
		if(Gdx.input.isKeyPressed(Keys.S)) {
			
			world.moveFirstDown();
		}
	}

}
