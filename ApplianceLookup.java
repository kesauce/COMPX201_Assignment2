import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class ApplianceLookup{
    public static void main(String[] args){

        // Checks to see if the program is running 
        boolean isRunning = true; 

        // Initialise the Appliance Tree
        ApplianceBST applianceBST = new ApplianceBST();

        // Initialising scanner
        Scanner scanner;
        
        try{
            // Initialising to read the appliance csv
            String filePath = "appliances.csv";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = "";


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

                 // Close the reader 
                 reader.close();
        }
        catch (Exception e){
            System.out.println("There was an error with the file processing.");
        }

        while(isRunning){
            try{
    
                // Initalise user input
                int userInput= 0;
                scanner = new Scanner(System.in);
    
                // Print out the list of console functions that the user can run
                System.out.println("--------------------");
                System.out.println("Main Menu: ");
                System.out.println("1. Search for an appliance");
                System.out.println("2. Add a new appliance");
                System.out.println("3. Remove an existing appliance");
                System.out.println("4. Display all appliances within a category");
                System.out.println("5. Display all appliances within a category in the same price range");
                System.out.println("6. Display all appliances within a category above a minimum price");
                System.out.println("7. Display all appliances within a category below a minimum price");
                System.out.println("8. Exit the program");
    
                // Loops through user input
                System.out.print("Enter a number that corresponds to your request: ");
                userInput = Integer.parseInt(scanner.nextLine());
                while(userInput <= 0 || userInput > 8){
                    System.out.println("Invalid input. Please try again.");
                    System.out.print("Enter a number that corresponds to your request: ");
                    userInput = Integer.parseInt(scanner.nextLine());
                }
    
    
                // Searches for an appliance
                if (userInput == 1){
    
                    System.out.println("--------------------");
                    System.out.println("Searching an appliance...");
                    
                    // Store the appliance the user wants to work with
                    Appliance newAppliance = createUserAppliance(scanner);
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
                        Thread.sleep(2000);
                    }
                
                // Adds a new appliance
                else if (userInput == 2){
                    System.out.println("--------------------");
                    System.out.println("Adding a new appliance...");
    
                    // Make a new appliance and insert new appliance into the tree
                    Appliance newAppliance = createUserAppliance(scanner);
                    applianceBST.insert(newAppliance);

                    System.out.println("Appliance added successfully.");
                    System.out.println("Returning to main menu...");
                    Thread.sleep(2000);

                }
                
                // Removes an appliance
                else if (userInput == 3){
                    System.out.println("--------------------");
                    System.out.println("Removing an existing appliance...");

                    // Make a new appliance and sees if it's in the bst
                    Appliance newAppliance = createUserAppliance(scanner);
                    if (applianceBST.search(newAppliance)){
                        
                        // Remove the appliance from the bst
                        applianceBST.remove(newAppliance);

                        System.out.println("Appliance removed successfully.");
                        System.out.println("Returning to main menu...");
                        Thread.sleep(2000);
                    }

                    // If appliance could not be found
                    else{
                        System.out.println("Specified appliance does not exist");
                        System.out.println("Returning to main menu...");
                        Thread.sleep(2000);

                    }
                }

                // Displays all appliances in a category 
                else if (userInput == 4){

                    System.out.println("----------");
                    System.out.println("Displaying all appliance in the same category...");

                    // Find the category the user wants to display
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    // Display all the appliances in that category
                    applianceBST.printCategory(category);

                    System.out.println("Returning to main menu...");
                    Thread.sleep(2000);
                }

                // Display all appliance in a category within a price range
                else if (userInput == 5){

                    System.out.println("----------");
                    System.out.println("Displaying all appliance in the same category within a price range...");

                    // Find the category the user wants to display and the price range
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter minimum price: ");
                    float min = Float.parseFloat(scanner.nextLine());
                    System.out.print("Enter maximum price: ");
                    float max = Float.parseFloat(scanner.nextLine());

                    // Display the price range
                    applianceBST.printCategoryWithPriceRange(category, min, max);

                    System.out.println("Returning to main menu...");
                    Thread.sleep(2000);
                }

                // Display all appliances in a category above a price
                else if (userInput == 6){

                    System.out.println("----------");
                    System.out.println("Displaying all appliance in the same category above a price...");

                    // Find the category the user wants to display and the price range
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter minimum price: ");
                    float min = Float.parseFloat(scanner.nextLine());

                    // Display the price range
                    applianceBST.printCategoryAbovePrice(category, min);

                    System.out.println("Returning to main menu...");
                    Thread.sleep(2000);
                }

                else if (userInput == 7){

                    System.out.println("----------");
                    System.out.println("Displaying all appliance in the same category below a price...");

                    // Find the category the user wants to display and the price range
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter maximum price: ");
                    float max = Float.parseFloat(scanner.nextLine());

                    // Display the price range
                    applianceBST.printCategoryBelowPrice(category, max);

                    System.out.println("Returning to main menu...");
                    Thread.sleep(2000);
                }

                else if (userInput == 8){
                    
                    // Stops the program
                    System.out.println("----------");
                    System.err.println("Program terminated...");
                    isRunning = false;
                    System.exit(0);
                }
            }
            catch (Exception e){
                System.out.println("An error occured. " + e.getMessage());
                System.out.println("Returning to main menu...");
                
            }
        }

    }

    private static Appliance createUserAppliance(Scanner scanner){
        try {
            // Get data from user
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter price: ");
            float price = Float.parseFloat(scanner.nextLine());

            // Make a new appliance and try to find an appliance with the same specs in the bst
            return new Appliance(category, price, name);
        } catch (Exception e) {
            System.out.println("Invalid input." + e.getMessage());
            return null;
        }
    }
}