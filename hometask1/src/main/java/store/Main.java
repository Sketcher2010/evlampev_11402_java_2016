package store;

import store.services.StoreService;
import store.services.StoreServiceFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        /* Для propeties-файла */
        StoreService storeService =
                StoreServiceFactory.getInstance().getService();

//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
//        StoreService storeService = context.getBean("Services", StoreService.class);

//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(StoreServiceConfig.class);
//
//        StoreService storeService = ctx.getBean(StoreService.class);
        //StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/sketcher2010/reps/java/hometask1/src/main/java/store/in.csv"));
        storeService.buy("item1");
        //System.out.println("123");
    }
}
