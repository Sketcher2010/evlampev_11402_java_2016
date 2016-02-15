package store;
import store.dao.ItemsDaoFileBasedImpl;
import store.services.StoreService;
import store.services.StoreServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/sketcher2010/reps/java/hometask1/src/main/java/store/in.txt"));
        ss.buy("item1");
    }
}
