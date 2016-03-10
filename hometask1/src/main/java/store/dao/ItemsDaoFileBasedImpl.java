package store.dao;

import org.apache.log4j.Logger;
import store.dao.models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemsDaoFileBasedImpl implements ItemsDao{

    BufferedReader bufferedReader;
    ArrayList<Item> items;
    Logger log = Logger.getLogger("ItemsDaoFileBasedImpl");
    String filepath;

    public ItemsDaoFileBasedImpl(String filePath) throws IOException {
        log.info("Start parsing.");
        items = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String itemName = line;
            double price = Double.parseDouble(bufferedReader.readLine());
            items.add(new Item(itemName, price));
            log.info("Item "+itemName+" has been added with price "+price+".");
        }
        log.info("Finish parsing.");
    }

    public void delete(String itemName) {
        Item item = this.select(itemName);
        if (item != null) {
            items.remove(item);
            log.info("Item "+itemName+" has been deleted.");
        } else {
            log.info("Nothing has been deleted.");
        }
    }

    public Item select(String itemName) {
        for (Item itmeit: items) {
            if (itmeit.getName().equals(itemName))
                return itmeit;
        }
        return null;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }
}