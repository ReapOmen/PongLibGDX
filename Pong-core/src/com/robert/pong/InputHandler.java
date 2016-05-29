package com.robert.pong;

import com.badlogic.gdx.InputAdapter;

/**
 * Represents a handler that takes care of certain types of input.
 * @author robert
 *
 */
public class InputHandler extends InputAdapter {
	
	private GameWorld world;
	
	/**
	 * Creates a new InputHandler that will work with the GameWorld provided.
	 * @param world a GameWorld to which this InputHandler will refer to.
	 */
	public InputHandler(GameWorld world) {
		
		this.world = world;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		
		world.start();
		return true;
	}
}
