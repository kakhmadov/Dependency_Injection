package kakhmadov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final Model model;

    @Autowired
    public Main(Model model) {
        this.model = model;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
    }

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) {
        Class<?> windowClass = Window.class;
        if (windowClass.isAnnotationPresent(View.class)) {
            System.out.println("Reflection: Window class HAS @View annotation.");
        } else {
            System.out.println("Reflection: Window class does NOT have @View annotation.");
        }

        System.out.println("Hello from run method, model: " + this.model);

        Model m1 = context.getBean(Model.class);
        m1.setCounter(10);
        System.out.println("m1 Counter: " + m1.getCounter());

        Model m2 = context.getBean(Model.class);
        System.out.println("m2 Counter: " + m2.getCounter());
        System.out.println("Sind m1 und m2 gleich? " + (m1 == m2));
    }

}