package com.robert.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Game extends ApplicationAdapter implements InputProcessor {
	
	private ShapeRenderer2 shape;
	private GameWorld world;
	private boolean start;
	
	@Override
	public void create () {
		
		world = new GameWorld(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
		shape = new ShapeRenderer2();
		start = false;
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Paddle r = world.getFirstPaddle();
		Paddle r2 = world.getSecondPaddle();
		Circle c = world.getBall();
		
		if(start)
			world.updateBall();
		
		shape.drawPong(r);
		shape.drawPong(r2);
		shape.drawCircle(c);
		
		handleInput();
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

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		start = true;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
