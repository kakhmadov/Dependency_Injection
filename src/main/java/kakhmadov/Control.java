package kakhmadov;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Control implements ActionListener {
    private final Model model;
    private final UI ui;

    @Autowired
    public Control(Model model, UI ui) {
        this.model = model;
        this.ui = ui;
    }

    @PostConstruct
    public void init() {
        // TODO Step 3: Wird später implementiert (ui.setActionListener(this))
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.model == null || this.ui == null) {
            throw new IllegalStateException("Not every dependency is injected");
        }
        if (e.getActionCommand().equals("increment")) {
            this.model.setCounter(this.model.getCounter() + 1);
            this.ui.updateView();
        }
    }
}