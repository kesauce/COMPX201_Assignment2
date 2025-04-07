public class Appliance {

    private String category;
    private float price;
    private String name;

    public Appliance(String category, float price, String name) {
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return category + " | " + name + " | " + price;
}