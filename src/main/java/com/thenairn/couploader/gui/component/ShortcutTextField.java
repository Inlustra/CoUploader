/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.gui.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author thomas
 */
public class ShortcutTextField extends JTextField {

    public ShortcutTextField() {
        this("");
    }

    public ShortcutTextField(String string) {
        super(string);
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                ShortcutTextField.this.setText(KeyStroke.getKeyStrokeForEvent(ke).toString());
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                ShortcutTextField.this.setText(KeyStroke.getKeyStrokeForEvent(ke).toString());
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (KeyEvent.VK_PRINTSCREEN == ke.getKeyCode()) {
                    ShortcutTextField.this.setText(KeyStroke.getKeyStrokeForEvent(ke).toString());
                }
            }
        });
    }

}
