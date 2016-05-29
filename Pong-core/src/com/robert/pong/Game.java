package com.robert.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {
	
	private GameWorld world;
	private Renderer renderer;
	
	@Override
	public void create () {
		
		world = new GameWorld(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
		renderer = new Renderer(world);
		Gdx.input.setInputProcessor(new InputHandler(world));
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.render();
	}


}
