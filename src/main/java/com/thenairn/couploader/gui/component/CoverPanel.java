/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.gui.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author thomas
 */
public class CoverPanel extends JPanel {

    private BufferedImage image;
    private int currentX, currentY, oldX, oldY;

    public CoverPanel() {
        super();
        init();
    }

    public void setBackgroundImage(BufferedImage image) {
        this.image = image;
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                CoverPanel.this.mousePressed(evt);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                CoverPanel.this.mouseReleased(evt);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                CoverPanel.this.mouseDragged(evt);
            }
        });
    }

    private void mouseDragged(MouseEvent evt) {
        currentX = evt.getX();
        currentY = evt.getY();
        repaint();
    }

    private void mousePressed(MouseEvent evt) {
        currentX = evt.getX();
        currentY = evt.getY();
        oldX = evt.getX();
        oldY = evt.getY();
        repaint();
    }

    //mouse released//
    private void mouseReleased(MouseEvent evt) {
        currentX = evt.getX();
        currentY = evt.getY();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
        g.setColor(new Color(0f, 0f, 0f, 0.3f));
        Rectangle rect = normalize();
        Area outside = calculateRectOutside(new Rectangle2D.Double(rect.x, rect.y, rect.width, rect.height));
        g.setClip(outside);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    private Area calculateRectOutside(Rectangle2D r) {
    	Area outside = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    	outside.subtract(new Area(r));
    	return outside;
    }
    
    public BufferedImage getCutImage() {
        Rectangle rect = normalize();
        return image.getSubimage(rect.x, rect.y, rect.width, rect.height);
    }
    
    private Rectangle normalize() {
        Rectangle rect = new Rectangle();
        if(currentX < oldX) {
            rect.x = currentX;
            rect.width = oldX - currentX;
        } else {
            rect.x = oldX;
            rect.width = currentX - oldX;
        }
        if(currentY < oldY) {
            rect.y = currentY;
            rect.height = oldY - currentY;
        } else {
            rect.y = oldY;
            rect.height = currentY - oldY;
        }
        return rect;
    }

}
