package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.Ggame;

public class Player {



    static final int PLAYER_WIDTH_PIXEL = 32;
    static final int PLAYER_HEIGHT_PIXEL = 48;
    static final float PLAYER_WIDTH = PLAYER_WIDTH_PIXEL *2;
    static final float PLAYER_HEIGHT = PLAYER_HEIGHT_PIXEL * 2;

    static final float PLAYER_SPEED = 120;

    Texture playerTextureSheet;

    Sprite sprite;

    private World world;
    private Body body;

    private Ggame ggame;

    float destinationX;
    float destinationY;

    float height;
    float width;

   public  Animation[] animation;

    int normalStatePlayer;

    public Animation[] getAnimation() {
        return animation;
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

    public Player(Ggame ggame, World world)
    {

        playerTextureSheet = new Texture("playerSprite.png");
        sprite = new Sprite(playerTextureSheet);

        height = sprite.getHeight();
        width = sprite.getWidth();

        this.world=world;
        this.ggame=ggame;
        animation = new Animation[16];
        TextureRegion[][] textureRegion = TextureRegion.split(playerTextureSheet,PLAYER_WIDTH_PIXEL,PLAYER_HEIGHT_PIXEL);

        this.sprite.setPosition(ggame.VIRTUAL_WIDTH/2 - sprite.getWidth()/2,ggame.VIRTUAL_HEIGHT/2 - sprite.getHeight()/2);

        animation[0] = new Animation(PLAYER_SPEED,textureRegion[0][0]);

    }

    void CreateBody()
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type=BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(this.sprite.getX(),this.sprite.getY());

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/45,sprite.getHeight()/45);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density=1;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();
    }

    public void movePlayer(float dt)
    {

        Vector2 direction = new Vector2(this.sprite.getX() - destinationX, this.sprite.getY() - destinationY);
        direction.nor();
        this.sprite.setPosition(this.sprite.getX() - direction.x,this.sprite.getY()-direction.y);

        System.out.println("X =" +destinationX + "Y =" +destinationY + " ActualX =" +this.sprite.getX() + "ActualY =" +this.sprite.getY());
        
    }
}
