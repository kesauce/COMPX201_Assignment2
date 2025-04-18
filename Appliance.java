/**
 * Class that represents an appliance, containing a category, price, and name.
 */
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

    /**
     * Formats the appliance to display the category, price, and name of a certain appliance.
     * @return Returns a formatted string.
     */
    public String toString() {
        // Adds padding to the category and name
        int maxPad = 40;
        int categoryPadding = maxPad - category.length();
        int namePadding = maxPad - name.length();

        StringBuilder categoryPad = new StringBuilder();
        categoryPad.append(" ".repeat(categoryPadding));

        StringBuilder namePad = new StringBuilder();
        namePad.append(" ".repeat(namePadding));

        return category + categoryPad + "|" + name + namePad + "|" + price;
    }

    /**
     * Compares two appliances by category then price then name.
     * @param other The other appliance to compare with.
     * @return -1, 0, or 1, depending on if the appliance comes before, or after the other appliance.
     */
    public int compareTo(Appliance other){
        // If self has a before category than other
        if (0 > this.category.compareTo(other.category)){
            return -1;
        }
        // If self has a after category than other
        else if (0 < this.category.compareTo(other.category)){
            return 1;
        }
        // If category is the same then comare by price
        else{
            // If self has a lower price than other
            if (this.price < other.price){
                return -1;
            }
            // If self has a higher price than other
            else if (this.price > other.price){
                return 1;
            }
            // If price is the same then compare by name
            else{
                return this.name.compareTo(other.name);
            }
        }
    }
}