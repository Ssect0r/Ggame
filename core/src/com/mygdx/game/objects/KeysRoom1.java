package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;
import tools.CollisionRect;

public class KeysRoom1 implements GameObject {


    float x,y;
    Sprite sprite;
    CollisionRect collisionRect;
    AbstractGameObject abstractGameObject;
    Ggame ggame;



    public KeysRoom1(Ggame ggame, float x, float y)
    {
        this.x=x;
        this.y=y;
        this.sprite= new Sprite(new Texture(Gdx.files.internal("keys.png")));
        abstractGameObject= new AbstractGameObject(this,sprite,x,y,true,false,true,false);
        collisionRect = new CollisionRect(this.x,this.y,40,40);
        System.out.println(sprite.getHeight());

    }

    @Override
    public void lookAtMe() {
        System.out.println("patrze i chuj");
        ggame.hud.getTalkingLabel().setText("Keys");
    }

    @Override
    public void useMe() {
        System.out.println(sprite.getHeight());
//    ggame.hud.getTable().getRow(0)
        this.abstractGameObject.isPicked=true;
        sprite.setPosition(160,160);
        collisionRect.setHeight(0);
        collisionRect.setWidth(0);
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

    @Override
    public void resetText() {

    }


    public Sprite getSprite() {
        return sprite;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
