package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.DeskRoom1;
import com.mygdx.game.objects.Player;
import com.mygdx.game.rooms.AbstractRoom;
import com.mygdx.game.rooms.Room;
import com.mygdx.game.rooms.Room1;
import com.mygdx.game.rooms.Room2;
import tools.InputController;

import java.util.ArrayList;

import static com.mygdx.game.objects.Player.PLAYER_HEIGHT;
import static com.mygdx.game.objects.Player.PLAYER_WIDTH;

public class GameScreen implements Screen {

    Ggame ggame;
    Texture backgroud;
//    Hud hud;
    public Player player;
    World world;
    Vector2 destination;
    float stateTime;
    public InputController inputControllerGame;

//    Room[] rooms;
//    DeskRoom1 deskRoom1;
    Room1 room1;
    Room2 room2;
    ArrayList<Room> rooms;
    Room actualRoom;



    public GameScreen(Ggame ggame)
    {
        this.ggame=ggame;
        backgroud = new Texture(Gdx.files.internal("GAME_ROOM_2.png"));
        world= new World(new Vector2(0,0),true);
        player = new Player(ggame, world);
//        ggame.hud.stage.draw();
        //deskRoom1=new DeskRoom1(ggame,90,70,true,false,false);
        inputControllerGame = new InputController();
        Gdx.input.setInputProcessor(inputControllerGame);
        rooms = new ArrayList<Room>();
        room1 = new Room1(ggame);
        room2 = new Room2(ggame);
        rooms.add(room1);
        rooms.add(room2);
        actualRoom= rooms.get(0);

    }

    public void update(float delta) {

        if (ggame.hud.getActionId() == 2) {

            if (Gdx.input.isTouched()) {
                System.out.println("here");
                if ( getFloor().height> ggame.cam.getInputInGameWorld().y && ggame.VIRTUAL_HEIGHT-getFloor().height< ggame.cam.getInputInGameWorld().y && ggame.gameScreen.getFloor().width > ggame.cam.getInputInGameWorld().x) {
                    destination = new Vector2(ggame.cam.getInputInGameWorld().x - PLAYER_WIDTH / 2, ggame.VIRTUAL_HEIGHT - 1 - ggame.cam.getInputInGameWorld().y - PLAYER_HEIGHT / 2);
                    //destination=new Vector2(Gdx.input.getX() - player.getWidth()/2, ggame.VIRTUAL_HEIGHT - 1 - Gdx.input.getY() - player.getHeight()/2);

                    player.setDestination(destination.x, destination.y);

//            ggame.hud.update();
                }
            }
            player.movePlayer(delta);
        }
        else
        {
            if(actualRoom==rooms.get(0) && Gdx.input.isTouched() ) {
//                room1.getDeskRoom1().setActionOnMe(ggame);
               // room1.getDoorsRoom1().setActionOnMe(ggame);
//                room1.getKeysRoom1().setActionOnMe(ggame);
                actualRoom.getItems(0).setActionOnMe(ggame);
                actualRoom.getItems(1).setActionOnMe(ggame);
            //    actualRoom.getItems(2).setActionOnMe(ggame);
            }
            else if(actualRoom==rooms.get(1))
            {

            }
        }


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

        ggame.hud.stage.act(delta);

        ggame.batch.begin();

        update(delta);


        if(actualRoom==rooms.get(0)) {
            ggame.batch.draw(actualRoom.textureRoom(), 0, 0);
            ggame.batch.draw(actualRoom.getItems(0).getSprite().getTexture(), actualRoom.getItems(0).objectX(), actualRoom.getItems(0).objectY(), actualRoom.getItems(0).getSprite().getWidth(), actualRoom.getItems(0).getSprite().getHeight());
            ggame.batch.draw(actualRoom.getItems(1).getSprite().getTexture(), actualRoom.getItems(1).objectX(), actualRoom.getItems(1).objectY(), actualRoom.getItems(1).getSprite().getWidth(), actualRoom.getItems(1).getSprite().getHeight());
            ggame.batch.draw(player.animation[player.actualAnimation].getKeyFrame(stateTime, true), player.getCollisionRect().getX(), player.getCollisionRect().getY(), PLAYER_WIDTH, PLAYER_HEIGHT);

            // ggame.batch.draw(actualRoom.getItems(2).getSprite().getTexture(), actualRoom.getItems(2).objectX(), actualRoom.getItems(2).objectY(), actualRoom.getItems(2).getSprite().getWidth(), actualRoom.getItems(2).getSprite().getHeight());
        }
        if(actualRoom==rooms.get(1))
        {
            ggame.batch.draw(actualRoom.textureRoom(), 0, 0);
            ggame.batch.draw(player.animation[player.actualAnimation].getKeyFrame(stateTime, true), player.getCollisionRect().getX(), player.getCollisionRect().getY(), PLAYER_WIDTH, PLAYER_HEIGHT);

        }
           // ggame.batch.draw(player.animation[player.actualAnimation].getKeyFrame(stateTime, true), player.getCollisionRect().getX(), player.getCollisionRect().getY(), PLAYER_WIDTH, PLAYER_HEIGHT);
//        if(actualRoom==rooms.get(0))
//        {
//            ggame.batch.draw(actualRoom.textureRoom(),0,0);
//        }
// ggame.batch.draw(room1.getDoorsRoom1().getSprite().getTexture(),room1.getDoorsRoom1().getX(),room1.getDoorsRoom1().getY(),room1.getDoorsRoom1().getSprite().getWidth(), room1.getDoorsRoom1().getSprite().getHeight());
      //  ggame.batch.draw(room1.getKeysRoom1().getSprite().getTexture(),room1.getKeysRoom1().getX(),room1.getKeysRoom1().getY(),room1.getKeysRoom1().getSprite().getWidth(), room1.getKeysRoom1().getSprite().getHeight());
        //ggame.batch.draw(deskRoom1.getSprite().getTexture(),deskRoom1.getX(),deskRoom1.getY(),deskRoom1.getSprite().getWidth(),deskRoom1.getSprite().getHeight());
      //  player.draw(ggame.batch);
//        ggame.batch.draw(actualRoom.getItems(0).getSprite(),);
        ggame.batch.end();
        ggame.hud.stage.draw();



       // ggame.hud.stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        ggame.hud.update(width,height);
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        player = player;
    }

    public Rectangle getFloor()
    {
        System.out.println(actualRoom.createFloor().height);
        return actualRoom.createFloor();
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    public void setActualRoom(Room actualRoom) {
        this.actualRoom = actualRoom;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void setRoomTo1()
    {
        actualRoom=rooms.get(1);
    }


}
