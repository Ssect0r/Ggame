package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.Player;

import static com.mygdx.game.objects.Player.PLAYER_HEIGHT;
import static com.mygdx.game.objects.Player.PLAYER_WIDTH;

public class GameScreen implements Screen {

    Ggame ggame;
    Texture backgroud;
//    Hud hud;
    Player player;
    World world;
    Vector2 destination;
    float stateTime;



    public GameScreen(Ggame ggame)
    {
        this.ggame=ggame;
        backgroud = new Texture(Gdx.files.internal("GAME_ROOM_2.png"));
        world= new World(new Vector2(0,0),true);
        player = new Player(ggame, world);

    }

    public void update(float delta)
    {
        if(Gdx.input.isTouched())
        {
            destination=new Vector2(ggame.cam.getInputInGameWorld().x - PLAYER_WIDTH/2, ggame.VIRTUAL_HEIGHT -1 -ggame.cam.getInputInGameWorld().y - PLAYER_HEIGHT/2);
            //destination=new Vector2(Gdx.input.getX() - player.getWidth()/2, ggame.VIRTUAL_HEIGHT - 1 - Gdx.input.getY() - player.getHeight()/2);
            player.setDestination(destination.x,destination.y);
            System.out.println(Gdx.input.getX() + " = X" + Gdx.input.getY() + "= Y");
        }
        player.movePlayer(delta);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.15f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //ggame.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        //ggame.cam.update();
        stateTime+=delta;
        ggame.batch.begin();

        ggame.batch.draw(backgroud,0,0);

        update(delta);
        ggame.batch.draw(player.animation[player.actualAnimation].getKeyFrame(stateTime,true),player.getCollisionRect().getX(),player.getCollisionRect().getY(),PLAYER_WIDTH,PLAYER_HEIGHT);

      //  player.draw(ggame.batch);
        ggame.batch.end();
        ggame.hud.stage.draw();
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

    @Override
    public void dispose() {

    }


}
