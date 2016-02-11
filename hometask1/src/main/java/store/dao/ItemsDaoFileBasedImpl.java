package store.dao;

import store.dao.models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemsDaoFileBasedImpl implements ItemsDao{

    BufferedReader bufferedReader;
    ArrayList<Item> items;

    public ItemsDaoFileBasedImpl(String filePath) throws IOException {
        items = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String itemName = line;
            items.add(new Item(itemName));
        }
    }

    public void delete(String itemName) {
        items.remove(new Item(itemName)); //overridden equals() in Item class doesn't affect the amount field
    }

    public Item select(String itemName) {
        int i;
        if ((i = items.indexOf(new Item(itemName))) == -1) {
            return null;
        }else{
            return items.get(i);

        }
    }
}