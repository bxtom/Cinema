package com.tomek.util;

import javax.swing.*;

public class PanelsManager {
    public static void changePanel(JFrame frame, JPanel newPanel) {
        frame.setContentPane(newPanel);
        frame.invalidate();
        frame.validate();
    }
}
