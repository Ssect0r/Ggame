package com.mygdx.game.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Ggame;
import com.mygdx.game.objects.GameObject;

public class Room2  {


    Texture background;
    Rectangle backgroundRectangle;
    Rectangle floorRectangle;

    Ggame ggame;


    public Room2(Ggame ggame)
    {
        floorRectangle = new Rectangle(30,64,ggame.VIRTUAL_WIDTH,ggame.VIRTUAL_HEIGHT-128);
        this.ggame=ggame;
        background = new Texture(Gdx.files.internal("SECOND_ROOM.png"));

    }


}
