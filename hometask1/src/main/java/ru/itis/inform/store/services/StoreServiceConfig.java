package ru.itis.inform.store.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
@ComponentScan("ru.itis.inform.store.dao")
@Configuration
public class StoreServiceConfig {
    public StoreService StoreService() throws IOException {
        return new StoreServiceImpl();
    }
}
