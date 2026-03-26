package jdbcproject;

public class Item {

    int id;
    String itemName;
    String description;
    String location;
    String status;

    public Item(String itemName, String description, String location, String status) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }
}