package com.robert.pong;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public class InputHandler extends InputAdapter {
	
	private GameWorld world;
	
	public InputHandler(GameWorld world) {
		
		this.world = world;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		
		world.updateBall();
		return true;
	}
}
