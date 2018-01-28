package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Ggame;
import tools.CollisionRect;
import tools.MyImageButton;

public interface GameObject{

 public void lookAtMe();
 public void useMe();
 public void useItemOnMe();
 public void setActionOnMe(Ggame ggame);
 public void avoidMe();
 public void blockPlayer();
 public void resetText();
 public Sprite getSprite();
 public float objectX();
 public float objectY();
 public String getName();
 public CollisionRect getCollistionRectObj();


}
