package ru.itis.inform.store;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(StoreServiceConfig.class);
        StoreService storeService = ctx.getBean(StoreService.class);
        storeService.buy("item1");
    }
}
