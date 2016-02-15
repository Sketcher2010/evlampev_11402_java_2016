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
            double price = Double.parseDouble(bufferedReader.readLine());
            items.add(new Item(itemName, price));
        }
    }

    public void delete(String itemName) {
        Item item = this.select(itemName);
        if (item != null)
            items.remove(item);
    }

    public Item select(String itemName) {
        for (Item itmeit: items) {
            if (itmeit.getName().equals(itemName))
                return itmeit;
        }
        return null;
    }
}