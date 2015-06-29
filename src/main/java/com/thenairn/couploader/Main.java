/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader;

import com.thenairn.couploader.gui.OptionsFrame;
import com.thenairn.couploader.user.ShortcutRegister;
import java.util.Properties;
import javax.swing.JFrame;

/**
 *
 * @author thomas
 */
public class Main {

    private final static Object obj = new Object();

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("jna.nosys", "true");
        
        ShortcutRegister.getInstance();
        
        JFrame jFrame = new OptionsFrame();
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
