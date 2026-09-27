package kakhmadov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@View
public class Window extends JFrame implements UI {
    private Model model;
    private Control control; // TODO Step 3: Remove
    private JButton button;
    private JLabel label;

    @Autowired // TODO Step 1: Explizite Injektion
    public Window(Model model, Control control) {
        this.model = model;
        this.control = control;

        // kakhmadov.Window Settings
        this.setTitle("Zähler");
        this.setSize(240, 80);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        // Label
        this.label = new JLabel("");
        this.add(this.label);
        // Button
        this.button = new JButton();
        this.button.setText("+");
        this.button.setActionCommand("increment");

        this.setActionListener(this.control); // TODO Step 3: Remove
        this.add(this.button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        this.button.addActionListener(actionListener);
    }

    @Override
    public void updateView() {
        this.label.setText(String.valueOf(this.model.getCounter()));
    }
}