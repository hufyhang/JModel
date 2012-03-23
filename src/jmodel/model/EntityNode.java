package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 21/03/2012
 * Time: 19:24
 */
public class EntityNode extends Node {
    public EntityNode() {
        this.pointX = this.pointY = 0;
    }
    
    public EntityNode(String title, String id) {
        this();
        this.title = title;
        this.id = id;
    }
}
