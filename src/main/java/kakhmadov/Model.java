package kakhmadov;

import org.springframework.stereotype.Component;

@Component
public class Model {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}