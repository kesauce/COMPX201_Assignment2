import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ApplianceLookup{
    public static void main(String[] args){

        try{

            // Initialising to read the appliance csv
            String filePath = "appliances.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";

            // Checks to see if the program is running 
            boolean isRunning = true; 

            // Initialise the Appliance Tree
            ApplianceBST applianceBST = new ApplianceBST();

            // While the application is running
            while(isRunning){

                // Read the header then read the next line
                reader.readLine();
                line = reader.readLine();
                
                // Read the entire csv file
                while (line != null){
                    // Split and store each value in a line to an array
                    String[] csvRow = line.split(",");

                    // Create a new appliance object with the data in the csv and insert it to the Appliance BST
                    Appliance newAppliance = new Appliance(csvRow[1], Float.parseFloat(csvRow[2]), csvRow[0]);
                    applianceBST.insert(newAppliance);

                    // Read the next line
                    line = reader.readLine();
                }

                // List out the tree values
                applianceBST.print();

                // Initalise user input
                int userinputer = 0;
                Scanner scanner = new Scanner(System.in);

                // Print out the list of console functions that the user can run
                System.out.println("--------------------");
                System.out.println("Main menu: ");
                System.out.println("1. Search for an appliance");
                System.out.println("2. Add a new appliance");
                System.out.println("3. Remove an existing appliance");
                System.out.println("4. Display all appliances within a category");
                System.out.println("5. Display all appliances within a category in the same price range");
                System.out.println("6. Display all appliances within a category above a minimum price");
                System.out.println("7. Display all appliances within a category below a minimum price");
                System.out.println("8. Exit the program");
                System.out.print("Enter a number that corresponds to your request: ");
                int userInput = Integer.parseInt(scanner.nextLine());

                // Searches for an appliance
                if (userInput == 1){

                    System.out.println("--------------------");
                    System.out.println("Searching an appliance...");

                    // Get data from user
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    float price = Float.parseFloat(scanner.nextLine());

                    // Make a new appliance and try to find an appliance with the same specs in the bst
                    Appliance newAppliance = new Appliance(category, price, name);
                    boolean applianceFound = applianceBST.search(newAppliance);

                    // Inform user if appliance was found
                    if (applianceFound){
                        System.out.println("Appliance was found in the system.");
                        System.out.println(newAppliance.toString());
                    }
                    else{
                        System.out.println("Appliance was not found in the system. Please make sure that spelling is correct. Input is case-sensitive.");
                    }

                    // Return or quit
                    System.out.println("Returning to main menu...");
                    Thread.sleep(300);
                }

                // Close the scanner
                //scanner.close();

            }

            // Close the reader 
            reader.close();
            
        }
        catch (Exception e){
            System.out.println("An error occured. " + e.getMessage());
        }

    }
}