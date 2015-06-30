/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader;

import com.thenairn.couploader.gui.CoverFrame;
import java.awt.AWTException;
import java.util.Properties;

/**
 *
 * @author thomas
 */
public class Main {

    private final static Object obj = new Object();

    public static void main(String[] args) throws AWTException {
        Properties props = System.getProperties();
        props.setProperty("jna.nosys", "true");

        //ShortcutRegister.getInstance();
        new CoverFrame().init(false);
        //JFrame jFrame = new OptionsFrame();
        //jFrame.pack();
        //jFrame.setVisible(true);
    }
}
