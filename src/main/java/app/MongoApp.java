package app;

import app.service.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/app-context.xml");
        AppService service = context.getBean("service", AppService.class);

        for (int i = 0; i < 10; i++) {
            service.findOnPrimary();
            service.findOnSecondary();
        }
    }
}
