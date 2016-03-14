package ru.itis.inform.store.services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoCsvFileBasedImpl;

import java.io.IOException;

@Configuration
public class StoreServiceConfig {

    @Bean
    public StoreService StoreService() throws IOException {
        return new StoreServiceImpl(this.ItemsDao());
    }

    @Bean
    public ItemsDao ItemsDao() throws IOException {
        return new ItemsDaoCsvFileBasedImpl("/home/sketcher2010/reps/java/hometask1/src/main/resources/in.csv");
    }
}
