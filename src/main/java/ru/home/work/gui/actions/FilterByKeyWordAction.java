package ru.home.work.gui.actions;

import ru.home.work.gui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterByKeyWordAction implements ActionListener {

    public static final String SEARCH = "Найти";
    private final MainWindow mainWindow;

    public FilterByKeyWordAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals(SEARCH)) {
            System.out.println(mainWindow.getKeyWordInput().getText());
        }
    }
}
