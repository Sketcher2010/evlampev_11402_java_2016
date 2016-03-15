package ru.itis.inform.store;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.inform.store.services.StoreService;

import java.io.IOException;

public class Main {

    @Autowired
    static StoreService storeService;

    public static void main(String[] args) throws IOException {
        storeService.buy("item1");
    }
}
