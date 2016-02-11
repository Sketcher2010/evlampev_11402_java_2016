package store.services;


import store.dao.ItemsDao;

public class StoreServiceImpl implements StoreService {

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

