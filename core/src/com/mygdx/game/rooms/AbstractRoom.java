package com.mygdx.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.AbstractGameObject;
import com.mygdx.game.objects.GameObject;
import tools.MyImageButton;

public class AbstractRoom implements Room {

    float x, y;
    Ggame ggame;
    Sprite sprite;
    Texture background;
    Rectangle backgroundRectangle;
    Rectangle floorRectangle;

    public AbstractRoom(Ggame ggame, float x, float y) {
        this.ggame = ggame;
        this.x = x;
        this.y = y;


    }


    @Override
    public void renderRoom() {

    }

    @Override
    public void changesInRoom() {

    }

    @Override
    public Rectangle createFloor() {
        return null;
    }

    @Override
    public Texture textureRoom() {
        return null;
    }

    @Override
    public AbstractGameObject getItems(int index) {
        return null;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
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

