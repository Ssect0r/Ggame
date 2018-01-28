package com.mygdx.game.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.DeskRoom1;
import com.mygdx.game.objects.DoorsRoom1;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.KeysRoom1;
import tools.MyImageButton;


import java.util.ArrayList;

public class Room1 implements Room {


    Texture background;
    Rectangle backgroundRectangle;
    Rectangle floorRectangle;

    Ggame ggame;
    DeskRoom1 deskRoom1;
    DeskRoom1 deskRoom2;
    DoorsRoom1 doorsRoom1;
    KeysRoom1 keysRoom1;

    GameObject[] gameObjects;

    public Room1(Ggame ggame)
    {
        floorRectangle = new Rectangle(35,40,ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT-120);
        this.ggame=ggame;
        background = new Texture(Gdx.files.internal("GAME_ROOM_2.png"));
        //backgroundRectangle = new Rectangle(ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT);

        deskRoom1 = new DeskRoom1(ggame,90,80);
        //deskRoom2 = new DeskRoom1(ggame,200,100);
        doorsRoom1= new DoorsRoom1(ggame,430,100);
        keysRoom1 = new KeysRoom1(ggame,50,140);

        gameObjects= new GameObject[4];

        gameObjects[0]=deskRoom1;
        gameObjects[1]=doorsRoom1;
        gameObjects[2]=keysRoom1;


//        objects[1]= new DeskRoom1(ggame, 200, 150, false, false, false);

    }



    public Ggame getGgame() {
        return ggame;
    }

    public void setGgame(Ggame ggame) {
        this.ggame = ggame;
    }

    public DeskRoom1 getDeskRoom1() {
        return deskRoom1;
    }

    public void setDeskRoom1(DeskRoom1 deskRoom1) {
        this.deskRoom1 = deskRoom1;
    }

    public DoorsRoom1 getDoorsRoom1() {
        return doorsRoom1;
    }

    public void setDoorsRoom1(DoorsRoom1 doorsRoom1) {
        this.doorsRoom1 = doorsRoom1;
    }

    public KeysRoom1 getKeysRoom1() {
        return keysRoom1;
    }

    @Override
    public void renderRoom() {

    }

    @Override
    public void changesInRoom() {

    }

    @Override
    public Rectangle createFloor() {
        return floorRectangle;
    }

    @Override
    public Texture textureRoom() {
        return background;
    }

    @Override
    public GameObject getItems(int index) {
        return gameObjects[index];
    }

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public float roomX() {
        return 0;
    }

    @Override
    public float roomY() {
        return 0;
    }

    public Rectangle getFloor() {
        return floorRectangle;
    }

    public void setFloorRectangle(Rectangle floorRectangle) {
        this.floorRectangle = floorRectangle;
    }
}
