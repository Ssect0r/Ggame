package com.mygdx.game.com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Ggame;

import tools.ImageButtonStyle;
import tools.InputController;
import tools.MyImageButton;

public class Hud {

    boolean pressed = false;

    private Viewport viewport;
    private Ggame ggame;

    public Stage stage;

    private Skin skin;
    private Table table;

    private Label useLabel;
    private Label lookLabel;
    private Label walkLabel;
    private Image image;
    private Label useButton;
    private Label lookButton;
    private Label walkButton;


    public InputController inputControllerHud;

    private SpriteBatch sb;


//    TextButton textButton;
    public MyImageButton imageUseButton;
    public MyImageButton imageWalkButton;
    public MyImageButton imageLookButton;

    private Drawable imageUse;
    private Drawable accepted;
    private Drawable imageWalk;
    private Drawable imageLook;

    private Texture imageUseTexture;
    private Texture imageAcceptedTexture;

    Texture imageWalkTexture;
    Texture imageLookTexture;

    public Hud(SpriteBatch sb)
    {

        this.sb = sb;
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport=new FitViewport(Ggame.VIRTUAL_WIDTH,Ggame.VIRTUAL_HEIGHT,new OrthographicCamera());
//        inputControllerHud = new InputController();

        stage = new Stage(viewport,sb);
//        inputControllerHud= new InputController();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();

        imageUseTexture = new Texture(Gdx.files.internal("use.bmp"));
        imageAcceptedTexture = new Texture(Gdx.files.internal("accepted.bmp"));
        imageWalkTexture = new Texture(Gdx.files.internal("move.bmp"));
        imageLookTexture = new Texture(Gdx.files.internal("look.bmp"));

        imageUse = new TextureRegionDrawable(new TextureRegion(imageUseTexture));
        accepted = new TextureRegionDrawable(new TextureRegion(imageAcceptedTexture));
        imageWalk = new TextureRegionDrawable(new TextureRegion(imageWalkTexture));
        imageLook = new TextureRegionDrawable(new TextureRegion(imageLookTexture));


        // LISTENERY BUTTONOW *****************************************************************************

        imageUseButton  = new MyImageButton(imageUse,accepted,accepted);
        imageUseButton.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pressed=true;

                useLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));
                lookLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));
                walkLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));
                System.out.println(imageUseButton.getHeight());


                return super.touchDown(event, x, y, pointer, button);
            }
        });

        imageLookButton = new MyImageButton(imageLook,accepted,accepted);
        imageLookButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return super.touchDown(event, x, y, pointer, button);
            }
        });
        imageWalkButton = new MyImageButton(imageWalk,accepted,accepted);







        Pixmap pixmap = new Pixmap(1,1, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        skin.add("white",new Texture(pixmap));

        skin.add("default" , new BitmapFont());

        // DODAWANIE DO TABELI ********************************************************************************
        table = new Table();


        table.bottom();
        table.left();
        table.setFillParent(true);
        table.setSkin(skin);

        useLabel = new Label(" USE",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lookLabel = new Label(" LOOK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        walkLabel = new Label(" WALK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(lookLabel).left().padBottom(10);
        table.add(walkLabel).left().padBottom(10);
        table.add(useLabel).left().padBottom(10);

        table.row();

        table.add(imageLookButton).size(64).left();
        table.add(imageWalkButton).size(64).left();
        table.add(imageUseButton).size(64).left();

        table.row();



        stage.addActor(table);


    }

    public void update(int width, int height)
    {

        viewport.update(width, height);

    }



//    public Vector2 getInput()
//    {
//        Vector3 inputScreen = new Vector3(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),0);
//        Vector3 unprojected = stage.getCamera().unproject(inputScreen);
//        return new Vector2(unprojected.x,unprojected.y);
//    }

}
