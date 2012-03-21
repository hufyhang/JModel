package jmodel.model;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 17:56
 *
 */
public class ClassNode extends Node{
    private ArrayList<String> attributes;
    private ArrayList<String> signals;

    public ClassNode() {
        this.attributes = new ArrayList<String>();
        this.signals = new ArrayList<String>();
        this.type = Model.MODEL_TYPE.CLASS;

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
}
