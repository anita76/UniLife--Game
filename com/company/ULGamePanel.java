package com.company;

import com.company.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by SophiaShen on 2017-06-17.
 */
public class ULGamePanel extends JPanel {
    //TODO

    UniLifeGame controller;

    public ULGamePanel(UniLifeGame controller) {
        this.controller = controller;
        setSize(UniLifeGame.WIDTH, UniLifeGame.HEIGHT);
        setBackground(new Color(120, 150, 255));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStudent(g);
        drawFallingObjects(g);
    }

    private void drawStudent(Graphics g){
        Student s = controller.getStudent();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(s.getX() - 50 , UniLifeGame.HEIGHT - 50, s.getX(), UniLifeGame.HEIGHT);
    }

    private void drawFallingObjects(Graphics g){
        List<FallingObject> objs = controller.getFallingObjects();
        for(FallingObject o : objs){
            drawFallingObject(o, g);
        }
    }

    private void drawLifeBars(Graphics g){
        Map<FallingObjectType, LifeBar> objs = controller.getBars();
        for(Map.Entry<FallingObjectType, LifeBar> o : objs.entrySet()){
            drawLifeBar(o, g);
        }
    }

    private void drawFallingObject(FallingObject o, Graphics g){
        switch(o.getType()){
            case Coffee:
                g.setColor(Color.DARK_GRAY);
                break;
            case Book:
                g.setColor(Color.blue);
                break;
            case Sleep:
                g.setColor(Color.magenta);
                break;
            case Vodka:
                g.setColor(Color.RED);
                break;
            case Food:
                g.setColor(Color.GREEN);
                break;
        }
        g.fillRect(o.getX() - 5 , o.getY() - 5, o.getX(), o.getY());
    }

    private void drawLifeBar(Map.Entry<FallingObjectType, LifeBar> o, Graphics g){
        switch(o.getKey()){
            case Book:
                g.setColor(Color.blue);
                break;
            case Sleep:
                g.setColor(Color.magenta);
                break;
            case Food:
                g.setColor(Color.GREEN);
                break;
        }
        //g.fillRect(100 - 5 , o.getY() - 5, 100, o.getY());
    }
}

