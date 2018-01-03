package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Ggame;

public class Hud {

    Viewport viewport;

    Ggame ggame;

    Stage stage;

    Skin skin;
    Label useLabel;
    Label lookLabel;
    Label walkLabel;

    Color black;

    public Hud(SpriteBatch sb)
    {
        viewport=new FitViewport(Ggame.VIRTUAL_WIDTH,Ggame.VIRTUAL_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        Table table = new Table();
//        skin = new Skin();
//        black = skin.getColor();
        black = Color.BLACK;
//        skin.add("badlogic",new Texture(Gdx.files.internal("badlogic.jpg")));
        table.bottom();
        table.setFillParent(true);

        useLabel = new Label("USE",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lookLabel = new Label("LOOK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        walkLabel = new Label("WALK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(useLabel).expandX().padBottom(10);
        table.add(lookLabel).expandX().padBottom(10);
        table.add(walkLabel).expandX().padBottom(10);
        //table.setBackground();


        stage.addActor(table);



    }

    public void update(int width, int height)
    {
        viewport.update(width, height);
    }

}
