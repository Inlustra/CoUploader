/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.misc;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author thomas
 */
public class GraphicsUtilities {

    /**
     * Take one big screenshot of the entire UI. On my Windows box monitors seem
     * to act like they are side by side on X, extending on Y. Seems, at least
     * on windows, to ignore any offset config setup in display properties.
     * @return 
     */
    public static BufferedImage getScreens() throws AWTException {
        Robot robot = new Robot();
        Rectangle rect = getScreenBounds();
        Rectangle screenRect = new Rectangle(-(rect.width / 2), 0, rect.width, rect.height);
        return robot.createScreenCapture(screenRect);
    }
    

    public static Rectangle getScreenBounds() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        Rectangle allScreenBounds = new Rectangle(0,0,0,0);
        for (GraphicsDevice screen : screens) {
            allScreenBounds = allScreenBounds.union(screen.getDefaultConfiguration().getBounds());
        }
        return allScreenBounds;
    }
}
