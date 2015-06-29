/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.user;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;

/**
 *
 * @author thomas
 */
public class ShortcutRegister {

    private static ShortcutRegister _instance;

    public static ShortcutRegister getInstance() {
        return _instance == null ? _instance = new ShortcutRegister() : _instance;
    }

    public ShortcutRegister() {
        this.provider = Provider.getCurrentProvider(true);
        init();
    }

    private final Provider provider;

    private void init() {
        provider.register(KeyStroke.getKeyStroke(Settings.getUploadClipboardKey()), new HotKeyListener() {

            @Override
            public void onHotKey(HotKey hotkey) {
                try {
                    System.out.println((String) Toolkit.getDefaultToolkit()
                            .getSystemClipboard().getData(DataFlavor.stringFlavor));
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(ShortcutRegister.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ShortcutRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void end() {
        provider.stop();
    }

    public void reinitialize() {
        provider.reset();
        init();
    }

}
