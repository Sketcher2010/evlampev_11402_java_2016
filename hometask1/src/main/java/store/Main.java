package store;

import store.dao.ItemsDaoFileBasedImpl;
import store.services.StoreService;
import store.services.StoreServiceImpl;
import static org.mockito.Mockito.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StoreService ss = new StoreServiceImpl(new ItemsDaoFileBasedImpl("/home/sketcher2010/IdeaProjects/store/src/main/java/store/in.txt"));
        ss.buy("item1");
        System.out.println(ss.isExist("it"));
        System.out.println(ss.isExist("item1"));
        System.out.println(ss.isExist("item2"));

        
    }
}
