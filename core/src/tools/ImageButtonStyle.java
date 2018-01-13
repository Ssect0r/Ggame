package tools;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ImageButtonStyle  extends Button.ButtonStyle {

    public Drawable imageUp, imageDown,  disabled;

    public ImageButtonStyle(){

    }

    public ImageButtonStyle(Drawable imageUp, Drawable imageDown, Drawable disabled)
    {
        super(imageUp,imageDown,disabled);
        this.imageUp=imageUp;
        this.imageDown=imageDown;
        this.disabled=disabled;
    }

    public ImageButtonStyle (ImageButtonStyle style) {
        super(style);
        this.imageUp = style.imageUp;
        this.imageDown = style.imageDown;
        this.disabled = style.disabled;
    }

    public ImageButtonStyle (Button.ButtonStyle style) {
        super(style);
    }
}
