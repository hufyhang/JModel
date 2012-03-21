package jmodel.model;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 17:56
 *
 */
public class ClassNode {
    private String title;
    private String id;
    private Model.MODEL_TYPE type; // should fit to the type of model this node belongs to
    private ArrayList<String> attributes;
    private ArrayList<String> signals;

    private int pointX, pointY, width, height;

    public ClassNode() {
        this.title = "";
        this.id = "";
        this.type = Model.MODEL_TYPE.NONE;
        this.attributes = new ArrayList<String>();
        this.signals = new ArrayList<String>();

        this.pointX = this.pointY = this.width = this.height = 0;
    }
    
    public ClassNode(String title, String id, Model.MODEL_TYPE type, String[] attributes, String[] signals) {
        this();

        ArrayList<String> attributesList = new ArrayList<String>();
        for(String item : attributes) {
            attributesList.add(item);
        }
        
        ArrayList<String> signalsList = new ArrayList<String>();
        for(String item : signals) {
            signalsList.add(item);
        }

        this.setTitle(title);
        this.setId(id);
        this.setType(type);
        this.setAttributes(attributesList);
        this.setSignals(signalsList);
    }
    
    public ClassNode(String title, String id, Model.MODEL_TYPE type, ArrayList<String> attributes, ArrayList<String> signals) {
        this();
        this.setTitle(title);
        this.setId(id);
        this.setType(type);
        this.setAttributes(attributes);
        this.setSignals(signals);
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

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<String> getSignals() {
        return signals;
    }

    public void setSignals(ArrayList<String> signals) {
        this.signals = signals;
    }

    public void addAttribute(String attribute) {
        this.getAttributes().add(attribute);
    }

    public void removeAttribute(int index) {
        this.getAttributes().remove(index);
    }
    
    public void addSignal(String signal) {
        this.getSignals().add(signal);
    }
    
    public void removeSignal(int index) {
        this.getSignals().remove(index);
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

    public void setGeometry(int x, int y, int width, int height) {
        this.setPointX(x);
        this.setPointY(y);
        this.setWidth(width);
        this.setHeight(height);
    }
}
