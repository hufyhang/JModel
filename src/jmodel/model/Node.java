package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 21/03/2012
 * Time: 00:24
 */
public abstract class Node {
    String title;
    String id;
    Model.MODEL_TYPE type; // should fit to the type of model this node belongs to

    int pointX, pointY, width, height;

    public Node() {
        this.title = "";
        this.id = "";
        this.type = Model.MODEL_TYPE.NONE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Model.MODEL_TYPE getType() {
        return type;
    }

    public void setType(Model.MODEL_TYPE type) {
        this.type = type;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public void setGeometry(int x, int y, int width, int height) {
        this.setPointX(x);
        this.setPointY(y);             
        this.width = width;
        this.height = height;
    }


    public void setLocation(int x, int y) {
        this.setPointX(x);
        this.setPointY(y);
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return this.height;
    }
}
