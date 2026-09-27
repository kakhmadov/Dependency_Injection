package kakhmadov;

import java.awt.event.ActionListener;

public interface UI {
    void setActionListener(ActionListener actionListener);
    void updateView();
}