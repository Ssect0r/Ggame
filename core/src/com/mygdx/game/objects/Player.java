package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Ggame;
import javafx.scene.shape.Rectangle;
import tools.CollisionRect;

public class Player {


    static final int PLAYER_WIDTH_PIXEL = 32;
    static final int PLAYER_HEIGHT_PIXEL = 48;
    public static final int PLAYER_WIDTH = PLAYER_WIDTH_PIXEL * 2;
    public static final int PLAYER_HEIGHT = PLAYER_HEIGHT_PIXEL * 2;

    public static final float PLAYER_ANIMATION_SPEED = 0.5f;

    Texture playerTextureSheet;

    Sprite sprite;

    CollisionRect collisionRect;

    private World world;
    private Body body;

    private Ggame ggame;

    float destinationX;
    float destinationY;

    float height;
    float width;

    TextureRegion[] textureFrames;
    TextureRegion[][] textureRegion;

    public Animation<TextureRegion>[] animation;
    public int actualAnimation = 0;


    public Player(Ggame ggame, World world) {
        playerTextureSheet = new Texture("playerSprite.png");
        collisionRect = new CollisionRect(ggame.VIRTUAL_WIDTH / 2, ggame.VIRTUAL_HEIGHT / 2
                - PLAYER_HEIGHT_PIXEL, PLAYER_WIDTH_PIXEL, PLAYER_HEIGHT_PIXEL);
        textureRegion = TextureRegion.split(playerTextureSheet, PLAYER_WIDTH_PIXEL, PLAYER_HEIGHT_PIXEL);
        animation = new Animation[5];
        animation[0] = new Animation<TextureRegion>(1f / 4f, textureRegion[0][0]);//idle
        animation[1] = new Animation<TextureRegion>(1f / 4f, textureRegion[0]);//going down
        animation[2] = new Animation<TextureRegion>(1f / 4f, textureRegion[1]);//going left
        animation[3] = new Animation<TextureRegion>(1f / 4f, textureRegion[2]);//going right
        animation[4] = new Animation<TextureRegion>(1f / 4f, textureRegion[3]);//going up
    }


    public void movePlayer(float dt) {
        Vector2 direction = new Vector2(collisionRect.getX() - destinationX,
                collisionRect.getY() - destinationY);
        direction.nor();
                if(destinationY>= collisionRect.getY() &&
                        destinationX ==collisionRect.getX())
                {
                    actualAnimation=4;
                }
                if(destinationY<collisionRect.getY() &&
                        destinationX==collisionRect.getX())
                {
                    actualAnimation=1;
                }
                if (destinationX >= collisionRect.getX() &&
                        destinationX - collisionRect.getX() > 1) {
                    actualAnimation = 3;
                }
                else if (destinationX < collisionRect.getX() &&
                        collisionRect.getX() - destinationX > 1) {
                    actualAnimation = 2;
                }
                else if ( collisionRect.getX()-destinationX<1 &&
                        destinationY-collisionRect.getY()<1){
                    actualAnimation = 0;
                }
                collisionRect.move(collisionRect.getX() - direction.x,
                        collisionRect.getY() - direction.y);
            }






    public CollisionRect getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(CollisionRect collisionRect) {
        this.collisionRect = collisionRect;
    }



    public Texture getTexture() {
        return playerTextureSheet;
    }

    public float getX()
    {
        return this.sprite.getX();
    }

    public float getY()
    {
        return this.sprite.getY();
    }

    public void setDestination(float x, float y)
    {
        this.destinationX = x;
        this.destinationY = y;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(float destinationX) {
        this.destinationX = destinationX;
    }

    public float getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(float destinationY) {
        this.destinationY = destinationY;
    }

    //
//    public Animation getAnimation() {
//        return animation;
//    }

}
