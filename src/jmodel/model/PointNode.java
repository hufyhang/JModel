package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 23/03/2012
 * Time: 21:31
 */
public class PointNode extends Node {
    public PointNode() {
        this.pointX = this.pointY = 0;
    }
    
    public PointNode(String title, String id) {
        this();
        this.title = title;
        this.id = id;
    }
}
