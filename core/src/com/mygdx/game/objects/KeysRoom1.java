package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;
import tools.CollisionRect;
import tools.MyImageButton;


public class KeysRoom1 implements GameObject {




    float x,y;
    Sprite sprite;
    CollisionRect collisionRect;

    AbstractGameObject abstractGameObject;

    Ggame ggame;
    String name;

    public KeysRoom1(Ggame ggame, float x, float y)
    {
        this.ggame = ggame;
        this.x=x;
        this.y=y;
        name = "keys";
        this.sprite = new Sprite(new Texture(Gdx.files.internal("keys2.png")));
        collisionRect = new CollisionRect(this.objectX(),this.objectY(),(int)sprite.getWidth(),(int)sprite.getHeight());
        abstractGameObject = new AbstractGameObject(this,sprite,x,y,true,false,true,false);
    }

    @Override
    public float objectX() {
        return x;
    }

    @Override
    public float objectY() {
        return y;
    }

    @Override
    public void resetText() {

    }

    @Override
    public void lookAtMe() {
        ggame.hud.getTalkingLabel().setText("Klucze, moga sie przydac");
    }

    @Override
    public void useMe() {


        if(ggame.hud.getActionId()==3) {

            if (this.collisionRect.collidesWith(ggame.gameScreen.getPlayer().getCollisionRect())) {

                if(abstractGameObject.isPickable==true && abstractGameObject.isUsable==true) {

                    this.abstractGameObject.setPicked(true);
                    this.abstractGameObject.setPickable(false);

                    this.abstractGameObject.setSprite();
                   this.setX(-100);
                   this.setY(-100);
                    ggame.hud.getTalkingLabel().setText("To może się przydać");
                    ggame.hud.getItemOnHud(this);
                }

            } else {
                ggame.hud.getTalkingLabel().setText("Jestem zbyt daleko");
            }

        } else {
            abstractGameObject.useMe();
        }



        }


    @Override
    public CollisionRect getCollistionRectObj() {
        return collisionRect;
    }

    @Override
    public String getName() {
        return name;
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


    // *********************************************************************************************


    public void setSprite(Sprite sprite) {
        this.sprite = sprite;


    }
}