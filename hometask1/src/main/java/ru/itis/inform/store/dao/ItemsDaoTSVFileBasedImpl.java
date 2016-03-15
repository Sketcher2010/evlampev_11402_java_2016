package ru.itis.inform.store.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class ItemsDaoTSVFileBasedImpl implements ItemsDao {

    BufferedReader bufferedReader;
    ArrayList<Item> items;
    Logger log = Logger.getLogger("ItemsDaoCSVFileBasedImpl");
    String filePath = "/home/sketcher2010/reps/java/hometask1/src/main/resources/in.tsv";

    public ItemsDaoTSVFileBasedImpl() throws IOException {
        log.info("start parsing");
        items = new ArrayList<>();
        bufferedReader = new BufferedReader(new FileReader(this.filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] itemBody = line.split("\\t");
            items.add(new Item(itemBody[0], Double.parseDouble(itemBody[1])));
            log.info("Item "+itemBody[0]+" has been added with price "+Double.parseDouble(itemBody[1])+".");
        }
        log.info("Finish parsing.");
    }

    @Override
    public void delete(String itemName) {
        Item item = this.select(itemName);
        if (item != null) {
            items.remove(item);
            log.info("Item "+itemName+" has been deleted.");
        } else {
            log.info("Nothing has been deleted.");
        }
    }

    @Override
    public Item select(String itemName) {
        for (Item itmeit: items) {
            if (itmeit.getName().equals(itemName))
                return itmeit;
        }
        return null;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
