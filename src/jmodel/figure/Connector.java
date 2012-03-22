package jmodel.figure;

import java.awt.*;
import java.util.ArrayList;

import jmodel.model.Connect;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 22/03/2012
 * Time: 16:06
 */
public abstract class Connector {
    private ArrayList<Connect> connects;
    ArrayList<Shape> connectors;

    public Connector() {
        this.connects = new ArrayList<Connect>();
        this.connectors = new ArrayList<Shape>();
    }

    public Connector(ArrayList<Connect> connects) {
        this();
        this.setConnects(connects);
    }

    public void setConnects(ArrayList<Connect> connects) {
        this.connects = connects;
    }

    public ArrayList<Shape> getConnectors() {
        return this.connectors;
    }
}
