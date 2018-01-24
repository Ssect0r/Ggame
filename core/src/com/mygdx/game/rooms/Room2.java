package com.mygdx.game.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.GameObject;

public class Room2 implements Room {


    Texture background;
    Rectangle backgroundRectangle;
    Rectangle floorRectangle;

    Ggame ggame;


    public Room2(Ggame ggame)
    {
        floorRectangle = new Rectangle(30,64,ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT-128);
        this.ggame=ggame;
        background = new Texture(Gdx.files.internal("Room2.png"));

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
        return null;
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
}
