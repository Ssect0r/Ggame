package tools;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;

public class MyImageButton extends Button {

    private final Image image;
    private ImageButtonStyle imageButtonStyle;


    public MyImageButton(Skin skin)
    {
        this(skin.get(ImageButtonStyle.class));
        setSkin(skin);
    }


    public MyImageButton(String name, Skin skin)
    {
        this(skin.get(name, ImageButtonStyle.class));
        setSkin(skin);
    }

    public MyImageButton(ImageButtonStyle style)
    {
        super(style);
        image = new Image();
        image.setScaling(Scaling.fit);
        add(image);
        setStyle(style);


    }

    public MyImageButton (Drawable imageUp, Drawable imageDown, Drawable disabled) {

        this(new ImageButtonStyle(imageUp, imageDown, disabled));
    }

    public ImageButtonStyle getStyle () {
        return imageButtonStyle;
    }

    public ImageButtonStyle getImageButtonStyle() {
        return imageButtonStyle;
    }

    public void setPressed()
    {
       this.setDisabled(true);
    }
    //    public void updateImage () {
//        Drawable drawable = null;
//        System.out.println("no co jest" );
////        if (isPressed() && imageButtonStyle.imageDown != null)
////
////            drawable = imageButtonStyle.imageDown;
////        if (isChecked() && imageButtonStyle.imageChecked != null)
////            drawable = (imageButtonStyle.imageChecked != null && isOver()) ? imageButtonStyle.imageChecked : imageButtonStyle.imageChecked;
////
////        else if (imageButtonStyle.imageUp != null) //
////            drawable = imageButtonStyle.imageUp;
////        image.setDrawable(drawable);
//    }
}
