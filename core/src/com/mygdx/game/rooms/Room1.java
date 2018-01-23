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


import java.util.ArrayList;

public class Room1  {


    Texture background;
    Rectangle backgroundRectangle;
    Rectangle floorRectangle;

    Ggame ggame;
    DeskRoom1 deskRoom1;
    DoorsRoom1 doorsRoom1;
    KeysRoom1 keysRoom1;

    GameObject[] gameObjects;

    public Room1(Ggame ggame)
    {
        floorRectangle = new Rectangle(30,64,ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT-128);
        this.ggame=ggame;
        background = new Texture(Gdx.files.internal("GAME_ROOM_2.png"));
        //backgroundRectangle = new Rectangle(ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT);

        deskRoom1 = new DeskRoom1(ggame,90,100);
        doorsRoom1= new DoorsRoom1(ggame,ggame.VIRTUAL_WIDTH-100,ggame.VIRTUAL_HEIGHT/2 - 50);
        keysRoom1 = new KeysRoom1(ggame,50,100);
        gameObjects= new GameObject[3];

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
}
