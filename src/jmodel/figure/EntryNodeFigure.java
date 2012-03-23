package jmodel.figure;

import jmodel.model.EntryNode;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 21/03/2012
 * Time: 19:23
 */
public class EntryNodeFigure extends Figure {
    private EntryNode node;

    public EntryNodeFigure(EntryNode node) {
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
        this.checkWidth(fontWidth);

        int x, y;

        // add title
        x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
        y = this.getY() + fontHeight;
        Point point = new Point(x, y);
        this.addString(title, point);
        y += fontHeight;

        this.setHeight(y - this.getY());

        // add boarder
        this.addShape(new Rectangle2D.Float(this.getX(), this.getY(), this.getWidth(), this.getHeight()));

        this.node.setHeight(this.getHeight());
        this.node.setWidth(this.getWidth());
    }


}
