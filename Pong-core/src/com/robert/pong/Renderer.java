package com.robert.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Represents the visual side of the world and takes care of the rendering of the GameWorld.
 * @author robert
 *
 */
public class Renderer {
	
	private ShapeRenderer2 sr;
	private GameWorld world;
	
	/**
	 * Creates a renderer which will render everything from the GameWorld provided.
	 * @param w the GameWorld which will be renderer.
	 */
	public Renderer(GameWorld w) {
		
		world = w;
		sr = new ShapeRenderer2();
	}
	
	/**
	 * Renders/draws everything that exists in the GameWorld provided in the constructor.
	 */
	public void render() {
		
		handleInput();
		
		world.updateBall();
		sr.drawPaddle(world.getFirstPaddle());
		sr.drawPaddle(world.getSecondPaddle());
		sr.drawBall(world.getBall());
	
	}
	
	/**
	 * Handles different types of input.
	 */
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
