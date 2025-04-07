public class Main {
    public static void main(String[] args) {
        // Create a new appliance
        Appliance appliance1 = new Appliance("Refrigerator", 1200.00f, "lg");
        Appliance appliance2 = new Appliance("Washing Machine", 800.00f, "sams");
        Appliance appliance3 = new Appliance("Microwave", 200.00f, "pana");
        Appliance standFreezer = new Appliance("Fridge", 1000.20f, "stand");
        Appliance standerFreezest = new Appliance("Fridge ", 300.00f, "stander");
        Appliance candle = new Appliance("Oven ", 100.20f, "candle"); 
        Appliance gasStove = new Appliance("Oven ", 10200.20f, "gas"); 
        Appliance heatPump = new Appliance("Aircon", 1030.20f, "heat"); 
    
        // Create a new appliance BST
        ApplianceBST bst = new ApplianceBST();

        // Insert appliances into the BST
        bst.insert(appliance1);
        bst.insert(appliance2);
        bst.insert(appliance3);
        bst.insert(standFreezer);
        bst.insert(standerFreezest);
        bst.insert(candle);
        bst.insert(gasStove);
        bst.insert(heatPump);


        // Print the BST
        StrBSTPrinter.printNode(bst.root);

        bst.remove(appliance3);

        // Print the BST
        StrBSTPrinter.printNode(bst.root);
    }
}