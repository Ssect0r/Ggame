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

    int actionId;

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
    private Label talkingLabel;
    private Label item1;
    private Label item2;
    private Label item3;
    private Label item4;

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
                unpress();
                setActionId(3);

                useLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));



                System.out.println(imageUseButton.getHeight());


                return super.touchDown(event, x, y, pointer, button);
            }
        });

        imageLookButton = new MyImageButton(imageLook,accepted,accepted);
        imageLookButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                unpress();
                lookLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));
                imageLookButton.setChecked(true);
                setActionId(1);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        imageWalkButton = new MyImageButton(imageWalk,accepted,accepted);
        imageWalkButton.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                unpress();
                walkLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.RED));
                imageWalkButton.setChecked(true);
               setActionId(2);
                return super.touchDown(event, x, y, pointer, button);
            }
        });







        Pixmap pixmap = new Pixmap(1,1, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        skin.add("white",new Texture(pixmap));

        skin.add("default" , new BitmapFont());

        // DODAWANIE DO TABELI ********************************************************************************
        table = new Table();


        table.bottom();
        table.right();
        table.setFillParent(true);
        table.setSkin(skin);

        talkingLabel = new Label(" ", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
//        talkingLabel.setWrap(true);
//        talkingLabel.pack();
        useLabel = new Label(" USE",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        lookLabel = new Label(" LOOK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        walkLabel = new Label(" WALK",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        item1 = new Label("Item1", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        item2 = new Label("Item2", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        item3 = new Label("Item3", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        item4 = new Label("Item4", new Label.LabelStyle(new BitmapFont(),Color.WHITE));

table.row();
        table.add(talkingLabel).padBottom(20).expandX();
        table.row();


        table.add(lookLabel).padBottom(10).padTop(10).right();
        table.add(walkLabel).padBottom(10).padTop(10).right();
        table.add(useLabel).padBottom(10).padTop(10).right();


        table.row();

        table.add(imageLookButton).size(50).right();
        table.add(imageWalkButton).size(50).right();
        table.add(imageUseButton).size(50).right();
        table.add(item1).size(50).right();
        table.add(item2).size(50).right();
        table.add(item3).size(50).right();
        table.add(item4).size(50).right();



        table.row();



        stage.addActor(table);


    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public void update(int width, int height)
    {

        viewport.update(width, height);

    }

    public void unpress()
    {
        imageWalkButton.setChecked(false);
        imageLookButton.setChecked(false);
        imageUseButton.setChecked(false);
        useLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        lookLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        walkLabel.setStyle(new Label.LabelStyle(new BitmapFont(),Color.WHITE));
    }

//    public Vector2 getInput()
//    {
//        Vector3 inputScreen = new Vector3(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),0);
//        Vector3 unprojected = stage.getCamera().unproject(inputScreen);
//        return new Vector2(unprojected.x,unprojected.y);
//    }


    public Label getTalkingLabel() {
        return talkingLabel;
    }

    public void setTalkingLabel(Label talkingLabel) {
        this.talkingLabel = talkingLabel;
    }

    public Table getTable() {
        return table;
    }
}
