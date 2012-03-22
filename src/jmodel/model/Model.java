package jmodel.model;

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
    private ArrayList<Connect> connects;
    
    public Model() {
        this.nodes = new ArrayList<Node>();
        this.connects = new ArrayList<Connect>();
    }

    public void addConnect(Node nodeA, Node nodeB) {
        Connect con = new Connect(nodeA, nodeB);
        this.connects.add(con);
    }

    public ArrayList<Connect> getConnects() {
        return this.connects;
    }

    public ArrayList<Connect> getConnectsByNode(Node node) {
        ArrayList<Connect> cons = new ArrayList<Connect>();
        for(Connect con : this.getConnects()) {
            for(Node n : con.getNodes()) {
                if(n == node) {
                    cons.add(con);
                }
            }
        }
        return cons;
    }
    
    public ArrayList<Connect> getConnectsByNodeA(Node nodeA) {
        ArrayList<Connect> cons = new ArrayList<Connect>();
        for(Connect con : this.getConnects()) {
            if(con.getNodeA() == nodeA) {
                cons.add(con);
            }
        }
        return cons;
    }
    
    public ArrayList<Connect> getConnectsByNodeB(Node nodeB) {
        ArrayList<Connect> cons = new ArrayList<Connect>();
        for(Connect con : this.getConnects()) {
            if(con.getNodeB() == nodeB) {
                cons.add(con);
            }
        }
        return cons;
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
