package mts.register;

import mts.register.rest.MarriageController;
import mts.register.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"springContext.xml"}
        );

        MarriageController controller = context.getBean("controller", MarriageController.class);
        controller.findMarriageCert(new MarriageRequest());

    }
}
