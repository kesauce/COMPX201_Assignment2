import java.io.BufferedReader;
import java.io.FileReader;

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

                // Store the header then read the next line
                String header = reader.readLine();
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

                // Stops the program
                isRunning = false;
            }

            // Close the reader
            reader.close();
            
        }
        catch (Exception e){
            System.out.println("An error occured: " + e.getMessage());
        }

    }
}