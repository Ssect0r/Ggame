package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;
import tools.CollisionRect;
import tools.MyImageButton;

public class DeskRoom1 implements GameObject   {

    float x,y;
    Sprite sprite;
    CollisionRect collisionRect;
    String name;
    //InputAdapter inputAdapter;



    Ggame ggame;
    AbstractGameObject abstractGameObject;

    public DeskRoom1(Ggame ggame,float x, float y) {

        this.ggame= ggame;
        this.x = x;
        this.y = y;
        this.sprite =new Sprite(new Texture(Gdx.files.internal("Desk.png")));
        collisionRect = new CollisionRect(this.objectX(),this.objectY(),(int)sprite.getWidth(),(int)sprite.getHeight()-60);
        abstractGameObject = new AbstractGameObject(this,sprite,x,y,true,false,false,false);
        name = "DeskRoom1";


        //collisionRect = new CollisionRect(x,y,(int)sprite.getWidth(),(int)sprite.getHeight());
    }


    @Override
    public void setActionOnMe(Ggame ggame) {

   abstractGameObject.setActionOnMe(ggame);
}

    @Override
    public void avoidMe() {

        if(this.getCollistionRectObj().collidesWith(ggame.gameScreen.getPlayer().getCollisionRect()))
        {
            ggame.hud.getTalkingLabel().setText("Uwazaj !");
            if(this.getCollistionRectObj().collidesWithOnHeight(ggame.gameScreen.getPlayer().getCollisionRect())){
                ggame.gameScreen.getPlayer().setDestination(this.getCollistionRectObj().getX() + this.getCollistionRectObj().getWidth(), this.getCollistionRectObj().getY() );
            }
            if(this.getCollistionRectObj().collidesWithOnWidth(ggame.gameScreen.getPlayer().getCollisionRect()))
            {
                ggame.gameScreen.getPlayer().setDestination(ggame.gameScreen.getPlayer().getCollisionRect().getX() , this.getCollistionRectObj().getY() + this.getCollistionRectObj().getHeight());
            }


        }
    }

    @Override
    public void blockPlayer() {

    }

    @Override
    public void lookAtMe() {
    ggame.hud.getTalkingLabel().setText("Niesamowite, ale jest to szafka");


    }

    @Override
    public CollisionRect getCollistionRectObj() {
        return collisionRect;
    }


    @Override
    public void useMe() {
//        resetText();
        if (ggame.hud.getActionId() == 3) {
            if (abstractGameObject.isUsable() == true) {

                if (this.collisionRect.collidesWith(ggame.gameScreen.getPlayer().getCollisionRect())) {
                    System.out.println("Stykamy się");
                } else {
                    System.out.println("Jestem zbyt daleko");
                }
            } else {
                abstractGameObject.useMe();
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void useItemOnMe() {

    }

    public void resetText()
    {
        ggame.hud.getTalkingLabel().setText("");
    }


    public AbstractGameObject getAbstractGameObject() {
        return abstractGameObject;
    }

    @Override
    public float objectX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    @Override
    public float objectY() {
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

    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }



    //    public boolean isUsable() {
//        return isUsable;
//    }
//
//    public void setUsable(boolean usable) {
//        isUsable = usable;
//    }
//
//    public boolean isInRange() {
//        return isInRange;
//    }
//
//    public void setInRange(boolean inRange) {
//        isInRange = inRange;
//    }
//
//    public boolean isDoesNeedsDifferentItem() {
//        return doesNeedsDifferentItem;
//    }
//
//    public void setDoesNeedsDifferentItem(boolean doesNeedsDifferentItem) {
//        this.doesNeedsDifferentItem = doesNeedsDifferentItem;
//    }
//
//    public boolean isPickable() {
//        return isPickable;
//    }
//
//    public void setPickable(boolean pickable) {
//        isPickable = pickable;
//    }
//
//    public boolean isPicked() {
//        return isPicked;
//    }
//
//    public void setPicked(boolean picked) {
//        isPicked = picked;
//    }
}
