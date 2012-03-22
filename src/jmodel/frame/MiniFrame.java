package jmodel.frame;

import jmodel.model.*;
import jmodel.figure.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Feifei Hang
 * Date: 21/03/2012
 * Time: 00:40
 */
public class MiniFrame extends JPanel {
    private Graphics graphics;
    private Model model;
    
    private ArrayList<Shape> shapes;
    private ArrayList<Shape> backgrounds;
    private ArrayList<Shape> handlers;
    private ArrayList<String> text;
    private ArrayList<Point> textLocations;
    
    private ArrayList<Connector> connectors;
    private ArrayList<Shape> connectorLine;
    
    private ArrayList<String> handlerList;
    private ArrayList<Figure> figures;

    Node currentNode;

    public MiniFrame(Graphics graphics) {
        super();
        this.registerMouseEvents();

        this.currentNode = null;
        this.graphics = graphics;
        model = new Model();
        this.shapes = new ArrayList<Shape>();
        this.text = new ArrayList<String>();
        this.textLocations = new ArrayList<Point>();
        this.handlers = new ArrayList<Shape>();
        this.backgrounds = new ArrayList<Shape>();
        this.figures = new ArrayList<Figure>();
        this.handlerList = new ArrayList<String>();
        this.connectors = new ArrayList<Connector>();
        this.connectorLine = new ArrayList<Shape>();
    }
    
    public MiniFrame(Model model, Graphics graphics) {
        super();
        this.registerMouseEvents();
        this.graphics = graphics;
        this.currentNode = null;
        this.setModel(model);
    }
    
    public void setModel(Model model) {
        this.model = model;
        this.ready();
    }
    
    public Node getSelectedNode() {
        return this.currentNode;
    }
    
    private void addDataset(ArrayList<Shape> shapes, ArrayList<Shape> handlers, 
                            ArrayList<String> text, ArrayList<Point> location) {
        for(Shape handler : handlers) {
            this.handlers.add(handler);
        }
        for(Shape shape : shapes) {
            this.shapes.add(shape);
        }
        for(String str : text) {
            this.text.add(str);
        }
        for(Point loc : location) {
            this.textLocations.add(loc);
        }
        this.backgrounds.add(this.shapes.get(this.shapes.size() - 1));
    }
    
    public void addHandlerById(String id) {
        Figure fig = this.getFigureById(id);
        if(fig != null) {
            this.handlerList.add(id);
        }
        repaint();
    }
    
    public void removeHandlerById(String id) {
        this.handlerList.remove(id);
    }

    public Figure getFigureById(String id) {
        Figure result = null;
        int index = -1;
        int counter = 0;
        for(Node node : this.model.getNodes()) {
            if(node.getId().equals(id)) {
                index = counter;
                break;
            }
            else {
                ++counter;
            }
        }
        result = this.figures.get(index);
        return result;
    }

    private void clearData() {
        this.figures.clear();
        this.shapes.clear();
        this.handlers.clear();
        this.text.clear();
        this.textLocations.clear();
        this.connectors.clear();
        this.connectorLine.clear();
    }

    public void ready() {
        this.clearData();
        for(Node node : this.model.getNodes()) {
            Figure fig = null;

            // if node is a ClassNode
            if(node.getClass() == ClassNode.class) {
                fig = new ClassNodeFigure((ClassNode)node);
            }

            // if node is an EntryNode
            if(node.getClass() == EntryNode.class) {
                fig = new EntryNodeFigure((EntryNode)node);
            }

            this.figures.add(fig);
        }
        
        for(Connect con : this.model.getConnects()) {
            Connector connector = null;

            // TODO: CONNECTOR TYPE
            connector = new LineConnector(con);

            this.connectors.add(connector);
        }
    }

    private void updateFigures(Graphics g) {
        this.clearData();
        for(Node node : this.model.getNodes()) {
            Figure fig = null;

            // if node is a ClassNode
            if(node.getClass() == ClassNode.class) {
                fig = new ClassNodeFigure((ClassNode)node);
                fig.update(g);
                if(this.handlerList.contains(node.getId())) {
                    fig.addHandlers();
                }
                this.addDataset(fig.getShapes(), fig.getHandlers(), fig.getStrings(), fig.getStringPoints());
            }
            
            // if node is an EntryNode
            if(node.getClass() == EntryNode.class) {
                fig = new EntryNodeFigure((EntryNode)node);
                fig.update(g);
                if(this.handlerList.contains(node.getId())) {
                    fig.addHandlers();
                }
                this.addDataset(fig.getShapes(), fig.getHandlers(), fig.getStrings(), fig.getStringPoints());
            }

            this.figures.add(fig);
        }

        for(Connect con : this.model.getConnects()) {
            Connector connector = null;

            // TODO: CONNECTOR TYPE
            connector = new LineConnector(con);
            for(Shape shape : connector.getConnectors()) {
                this.connectorLine.add(shape);
            }

            this.connectors.add(connector);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        // clear all
        super.paint(g);

        this.updateFigures(g);
        this.draw(g);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        // draw connector
        g2d.setPaint(Color.BLACK);
        for(Shape connector : this.connectorLine) {
            g2d.draw(connector);
        }
        
        // draw nodes' background
        g2d.setPaint(Color.WHITE);
        for(Shape back : this.backgrounds) {
            g2d.fill(back);
        }

        // draw shapes
        g2d.setPaint(Color.BLUE);
        for(Shape shape : this.shapes) {
            g2d.draw(shape);
        }

        // draw text
        g2d.setPaint(Color.BLACK);
        for(int index = 0; index != this.text.size(); ++index) {
            Point point = this.textLocations.get(index);
            g2d.drawString(this.text.get(index), point.x, point.y);
        }

        // draw handler
        g2d.setPaint(Color.RED);
        for(int index = 0; index != this.handlers.size(); ++index) {
            g2d.draw(this.handlers.get(index));
        }
    }

    private void registerMouseEvents() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                boolean isSelected = false;
                Point point = mouseEvent.getPoint();
                for(int index = 0; index != figures.size(); ++index) {
                    if(figures.get(index).getBackground().contains(point)) {
                        addHandlerById(model.getNodes().get(index).getId());
                        currentNode = model.getNodes().get(index);
                        isSelected = true;
                    }
                    else {
                        removeHandlerById(model.getNodes().get(index).getId());
                    }
                }
                if(!isSelected) {
                    currentNode = null;
                }
                repaint();
            }
        });
    }
    
}
