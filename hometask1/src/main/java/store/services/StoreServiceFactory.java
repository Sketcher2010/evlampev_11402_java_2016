package store.services;

import store.dao.ItemsDao;

import java.io.FileInputStream;
import java.util.Properties;


public class StoreServiceFactory {
    private Properties properties;
    public static StoreServiceFactory instance;
    private StoreService service;
    private ItemsDao dao;
    private String filePath;

    public StoreServiceFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("/home/sketcher2010/reps/java/hometask1/src/main/resources/store.properties"));

            String serviceClass = properties.getProperty("service.class");
            String daoClass = properties.getProperty("dao.class");
            String filePath = properties.getProperty("filePath");

            this.filePath = filePath;
            this.dao = (ItemsDao)Class.forName(daoClass).getConstructor(String.class).newInstance(this.filePath);
            this.service = (StoreService)Class.forName(serviceClass).getConstructor(ItemsDao.class).newInstance(this.dao);

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    static {
        instance = new StoreServiceFactory();
    }

    public StoreService getService() {
        return service;
    }

    public static StoreServiceFactory getInstance() {
        return instance;
    }

    public ItemsDao getDao() {
        return dao;
    }
}
