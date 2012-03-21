package jmodel.figure;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 23:21
 */
public abstract class Figure {
    private ArrayList<Shape> shapes;
    private ArrayList<String> strings;
    private ArrayList<Point> stringPoints;
    private ArrayList<Shape> handlers;
    private int x, y, width, height;

    public Figure() {
        this.shapes = new ArrayList<Shape>();
        this.strings = new ArrayList<String>();
        this.stringPoints = new ArrayList<Point>();
        this.handlers = new ArrayList<Shape>();
    }

    public abstract void update(Graphics g);

    public abstract void draw(Graphics g);
    
    public void addHandlers() {
        if(this.shapes.isEmpty()) {
            return;
        }
        
        this.handlers.add(new Rectangle2D.Float(this.x - 5, this.y - 5, 10, 10));
        this.handlers.add(new Rectangle2D.Float(this.x + this.width - 5, this.y + this.height - 5, 10, 10));
        this.handlers.add(new Rectangle2D.Float(this.x + this.width - 5, this.y - 5, 10, 10));
        this.handlers.add(new Rectangle2D.Float(this.x - 5, this.y + this.height - 5, 10, 10));
    }
    
    public void removeHandlers() {
        this.handlers.clear();
    }

    public ArrayList<Shape> getHandlers() {
        return this.handlers;
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void addString(String str, Point point) {
        this.strings.add(str);
        this.stringPoints.add(point);
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
    }

    public ArrayList<Point> getStringPoints() {
        return stringPoints;
    }

    public void setStringPoints(ArrayList<Point> stringPoints) {
        this.stringPoints = stringPoints;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
