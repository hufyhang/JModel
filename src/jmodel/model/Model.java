package jmodel.model;

import jmodel.ctrl.DataTypeController;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 17:50
 */
public class Model {
    public static enum MODEL_TYPE {NONE, CLASS};
    
    private ArrayList<Node> nodes;
    
    public Model() {
        this.nodes = new ArrayList<Node>();
    }
    
    public ArrayList<Node> getNodes() {
        return this.nodes;
    }
    
    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    
    public void addNode(Node node) {
        this.getNodes().add(node);
    }

    public void removeNode(int index) {
        this.getNodes().remove(index);
    }

    public void removeNode(String id) {
        int index = this.getNodeIndexById(id);
        if(index != -1) {
            this.getNodes().remove(index);
        }
    }
    
    protected int getNodeIndexById(String id) {
        for(int index = 0; index != this.getNodes().size(); ++index) {
            if(this.getNodes().get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }
}
