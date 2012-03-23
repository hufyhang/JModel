package jmodel.figure;

import jmodel.model.*;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 22/03/2012
 * Time: 16:10
 */
public class LineConnector extends Connector {
    private Connect connect;
    
    public LineConnector(Connect connect) {
        this.connect = connect;

        Node nodeA = this.connect.getNodeA();
        Node nodeB = this.connect.getNodeB();

        Point pointA = new Point(nodeA.getPointX() + nodeA.getWidth() / 2, nodeA.getPointY() + nodeA.getHeight() / 2);
        Point pointB = new Point(nodeB.getPointX() + nodeB.getWidth() / 2, nodeB.getPointY() + nodeB.getHeight() / 2);
        
        Line2D line = new Line2D.Float(pointA, pointB);
        this.connectors.add(line);
    }
}
