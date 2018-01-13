package com.mygdx.game.com.mygdx.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Ggame;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class MenuScreen implements Screen {

    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_Y = 200;


    final Ggame ggame;

    Texture playButtonActive;
    Texture playButtonInactive;
    Texture background;



    public MenuScreen(final Ggame ggame) {
        this.ggame=ggame;
        playButtonActive = new Texture(Gdx.files.internal("play_button_active.png"));
        playButtonInactive = new Texture(Gdx.files.internal("play_button_inactive.png"));
        background = new Texture(Gdx.files.internal("MenuBackground.png"));
        final MenuScreen menuScreen = this;

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                int x = Ggame.VIRTUAL_WIDTH / 2 - PLAY_BUTTON_WIDTH/2;
                if(ggame.cam.getInputInGameWorld().x < x + PLAY_BUTTON_WIDTH && ggame.cam.getInputInGameWorld().x >x && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT  && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y > PLAY_BUTTON_Y )
                {
                    menuScreen.dispose();
                    ggame.setScreen(ggame.gameScreen);
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ggame.batch.begin();
        ggame.batch.draw(background,0,0);
        update();
        int x = ggame.VIRTUAL_WIDTH / 2 - PLAY_BUTTON_WIDTH /2;
        if(ggame.cam.getInputInGameWorld().x < x + PLAY_BUTTON_WIDTH && ggame.cam.getInputInGameWorld().x >x && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT  && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y > PLAY_BUTTON_Y )
        {
            ggame.batch.draw(playButtonActive,x,PLAY_BUTTON_Y,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT);
        }
        else{
            ggame.batch.draw(playButtonInactive,x,PLAY_BUTTON_Y,PLAY_BUTTON_WIDTH,PLAY_BUTTON_HEIGHT);
        }

        ggame.batch.end();


    }

    @Override
    public void resize(int width, int height) {


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void update()
    {
        if(Gdx.input.isTouched())
        {
            System.out.println(ggame.cam.getInputInGameWorld().x + " = X" + ggame.cam.getInputInGameWorld().y + "= Y");
        }
    }

    @Override
    public void dispose() {
    Gdx.input.setInputProcessor(null);
    }
}
