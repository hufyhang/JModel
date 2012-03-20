package jmodel.figure;

import jmodel.model.Node;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 20:35
 */
public class NodeClassFigure {
    private Node node;
    private int x, y, width, height;

    public NodeClassFigure(Node node) {
        this.node = node;
    }

    public void update(Graphics g) {
        this.x = this.node.getPointX();
        this.y = this.node.getPointY();
        this.width = this.node.getWidth();
        this.height = this.node.getHeight();

        Graphics2D g2d = (Graphics2D)g;
        FontMetrics metrics = g2d.getFontMetrics();
        int fontHeight = metrics.getHeight();

        // draw the title
        String title = this.node.getTitle();
        int fontWidth = metrics.stringWidth(title);
        this.x = this.node.getPointX() + (this.width / 2 - fontWidth / 2);
        this.y += fontHeight;
        g2d.drawString(this.node.getTitle(), this.x, this.y);

        // draw separator
        this.x = this.node.getPointX();
        this.y += fontHeight;
        g2d.drawLine(this.x, this.y, this.width + this.x, this.y);
        
        // draw attributes
        this.y += fontHeight;
        for(String item : this.node.getAttributes()) {
            fontWidth = metrics.stringWidth(item);
            this.x = this.node.getPointX() + (this.width / 2 - fontWidth / 2);
            g2d.drawString(item, this.x, this.y);
            this.y += fontHeight;
        }

        // draw separator
        this.x = this.node.getPointX();
        g2d.drawLine(this.x, this.y, this.width + this.x, this.y);

        // draw signals
        this.y += fontHeight;
        for(String item : this.node.getSignals()) {
            fontWidth = metrics.stringWidth(item);
            this.x = this.node.getPointX() + (this.width / 2 - fontWidth / 2);
            g2d.drawString(item, this.x, this.y);
            this.y += fontHeight;
        }

        // draw the boundary of this node
        g2d.draw(new Rectangle(this.node.getPointX(), this.node.getPointY(), this.width, this.x + fontHeight));
    }
}
