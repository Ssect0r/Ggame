package tools;

public class CollisionRect {

    float x,y;

    int width,height;

    public CollisionRect(float x , float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move (float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean collidesWith (CollisionRect rect) {
        return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
    }
    public boolean collidesWithOnWidth(CollisionRect rect){
        return x < rect.x + rect.width && x + width > rect.x;
    }

    public boolean collidesWithOnHeight(CollisionRect rect){
        return y<rect.y + rect.height && y+height>rect.y;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
