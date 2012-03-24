package jmodel.model;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 22/03/2012
 * Time: 15:52
 */
public class Connect {
    private Node nodeA, nodeB;
    private String information;
    
    // TODO: connect type

    public Connect(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.information = "";
    }
    
    public Connect(Node nodeA, Node nodeB, String information) {
        this(nodeA, nodeB);
        this.information = information;
    }
    
    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return this.information;
    }
    
    public void setNodeA(Node node) {
        this.nodeA = node;
    }

    public void setNodeB(Node node) {
        this.nodeB = node;
    }
    
    public Node[] getNodes() {
        Node[] nodes = {nodeA, nodeB};
        return nodes;
    }
    
    public Node getNodeA() {
        return this.nodeA;
    }
    
    public Node getNodeB() {
        return this.nodeB;
    }
}
