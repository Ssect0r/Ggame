package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.com.mygdx.game.screens.Hud;
import com.mygdx.game.com.mygdx.game.screens.MenuScreen;
import tools.GameCamera;

public class Ggame extends Game {
	public static final int VIRTUAL_WIDTH = 480;
	public static final int VIRTUAL_HEIGHT=320;
	public static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
	public SpriteBatch batch;
	public BitmapFont font;
	public GameCamera cam;
	public Hud hud;


	@Override
	public void create () {
		batch = new SpriteBatch();
		cam = new GameCamera(VIRTUAL_WIDTH,VIRTUAL_HEIGHT);
		hud = new Hud(batch);
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void resize(int width, int height) {
		cam.update(width,height);
		hud.update(width,height);
		super.resize(width, height);
	}

	@Override
	public void render () {
		//cam.update();
		batch.setProjectionMatrix(cam.combined());
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
