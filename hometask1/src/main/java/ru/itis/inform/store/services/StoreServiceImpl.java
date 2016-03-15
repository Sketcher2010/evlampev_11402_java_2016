package ru.itis.inform.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.itis.inform.store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {
    @Autowired
    @Qualifier("ItemsDaoCsvFileBasedImpl")
    ItemsDao itemsDao;

    public StoreServiceImpl() {}

    public void buy(String itemName) {
        itemsDao.delete(itemName);
    }

    public boolean isExist(String itemName) {
        return itemsDao.select(itemName) != null;
    }
}


