package jmodel.figure;

import jmodel.model.ClassNode;
import java.awt.*;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 20/03/2012
 * Time: 20:35
 */
public class ClassNodeFigure extends Figure {
    private ClassNode node;

    public ClassNodeFigure(ClassNode node) {
        this.node = node;
    }

    public void update(Graphics g) {
        this.setX(this.node.getPointX());
        this.setY(this.node.getPointY());
        this.setWidth(this.node.getWidth());
        this.setHeight(this.node.getHeight());

        Graphics2D g2d = (Graphics2D)g;
        FontMetrics metrics = g2d.getFontMetrics();
        int fontHeight = metrics.getHeight();
        int fontWidth;
        
        int x, y;
        
        // add title
        String title = this.node.getTitle();
        fontWidth = metrics.stringWidth(title);
        x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
        y = this.getY() + fontHeight;
        Point point = new Point(x, y);
        this.addString(title, point);
                
        // add separator
        x = this.getX();
        y = y + fontHeight;
        this.addShape(new Line2D.Float(x, y, x + this.getWidth(), y));
        
        // add attributes
        y = y + fontHeight;
        for(String attribute : this.node.getAttributes()) {
            fontWidth = metrics.stringWidth(attribute);
            x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
            this.addString(attribute, new Point(x, y));
            y += fontHeight;
        }
        
        // add separator
        x = this.getX();
        this.addShape(new Line2D.Float(x, y, x + this.getWidth(), y));
        
        // add signals
        y += fontHeight;
        for(String signal : this.node.getSignals()) {
            fontWidth = metrics.stringWidth(signal);
            x = this.getX() + (this.getWidth() / 2 - fontWidth / 2);
            this.addString(signal, new Point(x, y));
            y += fontHeight;
        }
        this.setHeight(y - this.getY());
        
        // add boarder
        this.addShape(new Rectangle2D.Float(this.getX(), this.getY(), this.getWidth(), this.getHeight()));
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        // draw background
        g2d.setPaint(Color.WHITE);
        g2d.fill(this.getShapes().get(this.getShapes().size() - 1));

        // draw shapes
        g2d.setPaint(Color.BLUE);
        for(Shape shape : this.getShapes()) {
            g2d.draw(shape);
        }

        // draw text
        g2d.setPaint(Color.BLACK);
        for(int index = 0; index != this.getStrings().size(); ++index) {
            Point point = this.getStringPoints().get(index);
            g2d.drawString(this.getStrings().get(index), point.x, point.y);
        }
        
        // draw handler
        g2d.setPaint(Color.RED);
        for(int index = 0; index != this.getHandlers().size(); ++index) {
            g2d.draw(this.getHandlers().get(index));
        }
    }
}
