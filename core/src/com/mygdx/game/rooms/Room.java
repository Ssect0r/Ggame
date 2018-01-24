package com.mygdx.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.objects.AbstractGameObject;
import com.mygdx.game.objects.GameObject;



public interface Room {



    public void renderRoom();
    public void changesInRoom();
    public Rectangle createFloor();
    public Texture textureRoom();
    public GameObject getItems(int index);
    public Sprite getSprite();
    public float roomX();
    public float roomY();

}
