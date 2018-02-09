package com.mygdx.game.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.mygdx.game.Ggame;
import tools.CollisionRect;
import tools.MyImageButton;

import java.awt.*;

import static com.badlogic.gdx.graphics.Color.WHITE;

public class DoorsRoom1 implements GameObject {

    boolean isUsable;
    boolean doesNeedsDifferentItem;
    boolean isPickable;


    boolean isOpened;
    String name;
    Texture texture1;
    Texture texture2;

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
        name = "doorsRoom1";
        this.isPickable=isPickable;
        this.doesNeedsDifferentItem=doesNeedsDifferentItem;


        this.isOpened=false;
        //sprite=new Texture();
        texture1=new Texture(Gdx.files.internal("Doors_right.png"));
        texture2 = new Texture(Gdx.files.internal("DoorsLeft.png"));
        this.sprite = new Sprite(texture1);
        collisionRect = new CollisionRect(this.objectX(),this.objectY(),(int)sprite.getWidth(),(int)sprite.getHeight());
        System.out.println(collisionRect.getY());
        abstractGameObject = new AbstractGameObject(this,sprite,x,y,true,true,false,false);
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
        ggame.hud.getTalkingLabel().setText("Drzwi, zamknięte");
    }

    @Override
    public void useMe() {
        if(ggame.hud.getActionId()==3 ) {
            if (abstractGameObject.isUsable() == true) {

                if (this.collisionRect.collidesWith(ggame.gameScreen.getPlayer().getCollisionRect())) {

                    if(isOpened==true){
                        System.out.println("esle otwarcia");
                        abstractGameObject.sprite.set(new Sprite(texture2));
                        ggame.gameScreen.setRoomTo1();


                    }

                    if(ggame.gameScreen.getActualRoom()==ggame.gameScreen.getRooms().get(0) && isOpened==false) {

                        if(ggame.hud.isItemChoosed()==true && ggame.hud.getActualAction().equals("keys")) {
                            System.out.println("if huda");
                            isOpened = true;
                            ggame.hud.getTalkingLabel().setText("Udalo mi sie otworzyc drzwi");
                            ggame.hud.removeItemFromHud();

                        }

                        else{
                            System.out.println("else");
                            ggame.hud.getTalkingLabel().setText("Zamkniete");
                        }

                    }


                    if(ggame.gameScreen.getActualRoom()==ggame.gameScreen.getRooms().get(1) && ggame.gameScreen.getRooms().get(1).getItems(0).getCollistionRectObj().collidesWith(ggame.gameScreen.getPlayer().getCollisionRect())  )
                    {
                        System.out.println("lelelelelle");

                        abstractGameObject.sprite.flip(true,false);
                        sprite.flip(true,true);
                        ggame.gameScreen.setRoomTo0();
                    }
                } else {
                    ggame.hud.getTalkingLabel().setText("Jestem zbyt daleko!");
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

    @Override
    public void setActionOnMe(Ggame ggame) {
     abstractGameObject.setActionOnMe(ggame);
    }


    @Override
    public CollisionRect getCollistionRectObj() {
        return collisionRect;
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
    // ********************************************************************************************* // *********************************************************************************************


}
