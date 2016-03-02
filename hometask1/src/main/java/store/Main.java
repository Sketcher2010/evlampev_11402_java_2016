package store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import store.services.StoreService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        StoreService storeService = context.getBean("buy", StoreService.class);
        //StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/sketcher2010/reps/java/hometask1/src/main/java/store/in.csv"));
        storeService.buy("item1");
    }
}
