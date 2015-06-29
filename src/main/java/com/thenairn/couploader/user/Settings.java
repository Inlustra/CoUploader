/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thenairn.couploader.user;

import java.util.prefs.Preferences;

/**
 *
 * @author thomas
 */
public class Settings {

    private static final Preferences prefs = Preferences.userNodeForPackage(com.thenairn.couploader.user.Settings.class);

    public static String getUploadClipboardKey() {
        return prefs.get("UPLOAD_CLIPBOARD", "control shift PLUS");
    }

    public static void setUploadClipboardKey(String key) {
        prefs.put("UPLOAD_CLIPBOARD", key);
    }
}
