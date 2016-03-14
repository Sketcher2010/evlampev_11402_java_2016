package ru.itis.inform.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import ru.itis.inform.store.dao.ItemsDao;

@ComponentScan("ru.itis.inform.store")
public class StoreServiceImpl implements StoreService {
    @Autowired
    ItemsDao itemsDao;

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        return itemsDao.select(itemName) != null;
    }
}


