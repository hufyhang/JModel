package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 21/03/2012
 * Time: 19:24
 */
public class EntryNode extends Node {
    public EntryNode() {
        this.pointX = this.pointY = this.width = this.height = 0;
    }
    
    public EntryNode(String title, String id) {
        this.title = title;
        this.id = id;
    }
}
