package store.services;
import org.springframework.context.annotation.*;
import store.dao.ItemsDao;
import store.dao.ItemsDaoCsvFileBasedImpl;

import java.io.IOException;

@Configuration
public class StoreServiceConfig {
    @Bean
    public StoreService StoreService() throws IOException {
        return new StoreServiceImpl(this.ItemsDao());
    }

    private ItemsDao ItemsDao() throws IOException {
        return new ItemsDaoCsvFileBasedImpl("/home/sketcher2010/reps/java/hometask1/src/main/resources/in.csv");
    }
}
