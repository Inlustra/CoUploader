/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.gui;

import com.thenairn.couploader.gui.component.CoverPanel;
import com.thenairn.couploader.misc.GraphicsUtilities;
import com.thenairn.couploader.misc.X11FullscreenHelper;
import java.awt.AWTException;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;

/**
 *
 * @author thomas
 */
public class CoverFrame extends JFrame {

    private final CoverPanel panel;

    public CoverFrame() {
        this.setAlwaysOnTop(true);
        this.panel = new CoverPanel();
        this.panel.setPreferredSize(GraphicsUtilities.getScreenBounds().getSize());
        this.add(panel);
    }

    private void fullscreen() {
        GraphicsDevice d = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (d.isFullScreenSupported()) {
            this.setUndecorated(true);
            this.setResizable(false);
            this.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent arg0) {
                    CoverFrame.this.setAlwaysOnTop(true);
                }

                @Override
                public void focusLost(FocusEvent arg0) {
                    CoverFrame.this.setAlwaysOnTop(false);
                }
            });
            this.pack();
            d.setFullScreenWindow(this);
        } else {
            System.out.println("Assuming nix");
            this.setLocation(0, 0);
            this.setSize(GraphicsUtilities.getScreenBounds().getSize());
            this.pack();
            this.setVisible(true);
            X11FullscreenHelper.setFullScreenWindow(this, true);
        }
    }

    public void init(boolean transparent) throws AWTException {
        if (!transparent) {
            panel.setBackgroundImage(GraphicsUtilities.getScreens());
        } else {
            panel.setBackgroundImage(null);
        }
        this.fullscreen();
    }
}
