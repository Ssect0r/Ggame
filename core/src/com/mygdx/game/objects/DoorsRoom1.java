package com.mygdx.game.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;
import tools.CollisionRect;

public class DoorsRoom1 implements GameObject {

    boolean isUsable;
    boolean doesNeedsDifferentItem;
    boolean isPickable;


    float x,y;
    Sprite sprite;
    CollisionRect collisionRect;

    AbstractGameObject abstractGameObject;

    Ggame ggame;

    public DoorsRoom1(Ggame ggame, float x, float y)
    {
        this.ggame = ggame;
        this.x=x;
        this.y=y;
        this.isUsable=isUsable;

        this.isPickable=isPickable;
        this.doesNeedsDifferentItem=doesNeedsDifferentItem;

        //sprite=new Texture();

        this.sprite = new Sprite(new Texture(Gdx.files.internal("Doors_Right.png")));
        collisionRect = new CollisionRect(ggame.VIRTUAL_WIDTH - sprite.getWidth(), ggame.VIRTUAL_HEIGHT/2-sprite.getHeight(),(int)sprite.getWidth(),(int)sprite.getHeight());
        abstractGameObject = new AbstractGameObject(this,sprite,x,y,true,false,false,false);
    }

    @Override
    public void resetText() {

    }

    @Override
    public void lookAtMe() {
        ggame.hud.getTalkingLabel().setText("Drzwi, zamknięte");
    }

    @Override
    public void useMe() {

        ggame.gameScreen.setActualRoom(ggame.gameScreen.getRooms().get(1));
    }

    @Override
    public void useItemOnMe() {

    }

    @Override
    public void setActionOnMe(Ggame ggame) {
     abstractGameObject.setActionOnMe(ggame);
    }


    @Override
    public void avoidMe() {

    }

    @Override
    public void blockPlayer() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
