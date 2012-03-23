package jmodel.figure;

import jmodel.model.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 23/03/2012
 * Time: 21:35
 */
public class PointNodeFigure extends Figure {
    private PointNode node;

    public PointNodeFigure(PointNode node) {
        this.node = node;
    }

    public void update(Graphics g) {
        this.setX(this.node.getPointX());
        this.setY(this.node.getPointY());

        this.setWidth(0);

        Graphics2D g2d = (Graphics2D)g;
        FontMetrics metrics = g2d.getFontMetrics();
        int fontHeight = metrics.getHeight();
        int fontWidth;

        // check & set width
        String title = this.node.getTitle();
        fontWidth = metrics.stringWidth(title);
        this.checkWidth(fontWidth + 5);

        int x, y;

        // add title
        x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
        y = this.getY() + fontHeight + 5;
        Point point = new Point(x, y);
        this.addString(title, point);

        y += fontHeight;
        this.setHeight(y - this.getY());

        this.node.setGeometry(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        // add boarder
        this.addShape(new Ellipse2D.Float(this.getX(), this.getY(), this.getWidth(), this.getHeight()));
    }

}
