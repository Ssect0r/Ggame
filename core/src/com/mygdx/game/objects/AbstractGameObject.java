package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;

public class AbstractGameObject implements  GameObject {

    Sprite sprite;
    float x,y;
    GameObject gameObject;

    boolean isUsable;
    boolean isInRange;
    boolean doesNeedsDifferentItem;
    boolean isPickable;
    boolean isPicked;


    public AbstractGameObject(GameObject gameObject,Sprite sprite, float x, float y,boolean isUsable,boolean doesNeedsDifferentItem,boolean isPickable,boolean isPicked)
    {
        this.gameObject = gameObject;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.isUsable=isUsable;
        this.doesNeedsDifferentItem=doesNeedsDifferentItem;
        this.isPickable=isPickable;
        this.isPicked=isPicked;
    }

    @Override
    public void lookAtMe() {

    }

    @Override
    public void useMe() {
System.out.println("Can't use it");


    }

    @Override
    public void useItemOnMe() {

    }

    @Override
    public void setActionOnMe(Ggame ggame ) {

                if(ggame.cam.getInputInGameWorld().x>this.x && ggame.cam.getInputInGameWorld().x < this.x + sprite.getTexture().getWidth() && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y <this.y + sprite.getHeight() && ggame.VIRTUAL_HEIGHT - ggame.cam.getInputInGameWorld().y > this.y )
        {
            switch (ggame.hud.getActionId())
            {
                case 1:
                    gameObject.lookAtMe();
                case 2:
                    //colision

                case 3:
                    gameObject.useMe();
                case 4:
                    gameObject.useItemOnMe();
            }

        }

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

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
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

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

    public boolean isInRange() {
        return isInRange;
    }

    public void setInRange(boolean inRange) {
        isInRange = inRange;
    }

    public boolean isDoesNeedsDifferentItem() {
        return doesNeedsDifferentItem;
    }

    public void setDoesNeedsDifferentItem(boolean doesNeedsDifferentItem) {
        this.doesNeedsDifferentItem = doesNeedsDifferentItem;
    }

    public boolean isPickable() {
        return isPickable;
    }

    public void setPickable(boolean pickable) {
        isPickable = pickable;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }


}
