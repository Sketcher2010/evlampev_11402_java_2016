package store.dao.models;

public class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Item other = (Item) obj;
        if (!this.name.equals(other.name))
            return false;
        return true;
    }
}
