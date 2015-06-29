/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader;

import com.thenairn.couploader.gui.OptionsFrame;
import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 *
 * @author thomas
 */
public class Main {

    private final static Object obj = new Object();

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.setProperty("jna.nosys", "true");
        Provider provider = Provider.getCurrentProvider(true);
        provider.register(KeyStroke.getKeyStroke("control shift PLUS"), new HotKeyListener() {

            @Override
            public void onHotKey(HotKey hotkey) {
                
            }
        });
        JFrame jFrame = new OptionsFrame();
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
