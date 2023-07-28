package com.pigsy;

import javax.swing.*;

public class FishGhostTab extends JTabbedPane {

    public FishGhostTab() {
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("+"));

        this.addTab("Interactsh", new JPanel());
    }

}
