public class ApplianceBST {
    
    // Initialise the root of the tree
    public Node root;

    public void insert(Appliance a){
        // Insert the appliance into the tree
        root = insertSubtree(root, a);
    }
    /**
     * Inserts a new appliance into the tree.
     * @param currentRoot The current root of the tree/subtree.
     * @param a The new appliance to insert.
     * @return The new current root of the tree/subtree.
     */
    private Node insertSubtree(Node currentRoot, Appliance a){
        // When the tree is null
        if (currentRoot == null){
            currentRoot = new Node(a);
        }

        // If the value is smaller then add it to the left subtree
        else if (a.compareTo(currentRoot.value) < 0){
            currentRoot.left = insertSubtree(currentRoot.left, a);
        }

        // If the value is greater then add it to the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            currentRoot.right = insertSubtree(currentRoot.right, a);
        }

        return currentRoot;
    }

    /**
     * Remove an appliance from the tree.
     * @param a The appliance to remove.
     */
    public void remove(Appliance a){
        // Create a current node to traverse the tree
        Node currentNode = root;

        // Create a previous node to keep track of the parent node
        Node previousNode = null;

        // If the appliance is in the tree
        if(search(a)){
            // Find the current root of the appliance we want to remove
            while(currentNode.value.equals(a) == false){
                if(a.compareTo(currentNode.value) < 0){
                    previousNode = currentNode;
                    currentNode = currentNode.left;
                }
                else if(a.compareTo(currentNode.value) > 0){
                    previousNode = currentNode;
                    currentNode = currentNode.right;
                }
            }

            // If the appliance is the leaf node, remove it
            if(currentNode.left == null && currentNode.right == null){

                // If it's the root node, remove it
                if(currentNode == root){
                    root = null;
                }

                // If it's the left child, remove it
                else if(previousNode.left == currentNode){
                    previousNode.left = null;
                }

                // If it's the right child, remove it
                else{
                    previousNode.right = null;
                }
            }

            // If the appliance has only one child, remove it and replace it with the child
            else if (currentNode.left == null ^ currentNode.right == null) {
                // If it's the root node, remove it
                if (currentNode == root) {
                    // If the left child is null, set the root to the right child
                    if (currentNode.left == null) {
                        root = currentNode.right;
                    }
                    // If the right child is null, set the root to the left child
                    else {
                        root = currentNode.left;
                    }
                }

                // If there's a left child, replace the parent with the left
                if (currentNode.left != null) {
                    if (previousNode.left == currentNode) {
                        previousNode.left = currentNode.left;
                    } else {
                        previousNode.right = currentNode.left;
                    }
                }

                // If there's a right child, replace the parent with the right
                else {
                    if (previousNode.left == currentNode) {
                        previousNode.left = currentNode.right;
                    } else {
                        previousNode.right = currentNode.right;
                    }
                }
            }

            // If the appliance has two children, find the leftmost node of the right subtree
            else {
                // Find the leftmost node of the right subtree
                previousNode = currentNode;
                Node leftmostNode = currentNode.right;

                while (leftmostNode.left != null) {
                    previousNode = leftmostNode;
                    leftmostNode = leftmostNode.left;
                }

                // Replace the value of the current node with the leftmost node's value
                currentNode.value = leftmostNode.value;

                // If the leftmost node has a right child, move the right child up
                if (previousNode.left == leftmostNode) {
                    previousNode.left = leftmostNode.right;
                } 
                // If the leftmost node is the immediate right child of the current node we want to 
                else {
                    previousNode.right = leftmostNode.right;
                }
            }
            
            
        }

        else{
            System.out.println("Appliance not found in the tree.");
        }
    }

    /**
     * Searches for an appliance in the tree.
     * @return True if the appliance is found, false otherwise.
     * @param a The appliance to search.
     */	
    public boolean search(Appliance a){
        return searchSubtree(root, a);
    }
    /**
     * Searches for an appliance in the tree.
     * @param currentRoot The current root of the tree/subtree.
     * @param a The appliance to search for.
     * @return True if the appliance is found, false otherwise.
     */
    private boolean searchSubtree(Node currentRoot, Appliance a){
        // Checks if the current root is null
        if (currentRoot == null){
            return false;
        }

        // Checks if the current root is the appliance we are looking for
        else if (currentRoot.value == a){
            return true;
        }

        // Do recursive search in the left subtree
        else if (a.compareTo(currentRoot.value) < 0){
            return searchSubtree(currentRoot.left, a);
        }

        // Do recursive search in the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            return searchSubtree(currentRoot.right, a);
        }

        return false;

    }

    /**
     * Gets the height of the subtree.
     * @return
     */
    public int getHeight(){
        return getHeightSubtree(root);
    }
    /**
     * Returns the height of the tree/subtree.
     * @param currentNode The current node of the tree/subtree.
     * @return The height of the tree/subtree.
     */
    private int getHeightSubtree(Node currentNode){

        // If the root is empty, return 0
        if (currentNode == null){
            return 0;
        }

        // Use recursion to count from bottom up
        else{
            // Find the greater height between the left and right subtree and add 1 to the bigger number
            return Math.max(getHeightSubtree(currentNode.left), getHeightSubtree(currentNode.right)) + 1;
        }
    }

    /**
     * Gets the minimum value of the tree/subtree.
     * @return The minimum value of the tree/subtree.
     */
    public Appliance getMinimum(){
        //Finds the leftmost node of the tree
        Node currentNode = root;

        // While the left child is not null, go to the left child
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    /**
     * Gets the maximum value of the tree/subtree.
     * @return The maximum value of the tree/subtree.
     */
    public Appliance getMaximum(){
        //Finds the rightmost node of the tree
        Node currentNode = root;

        // While the right child is not null, go to the right child
        while(currentNode.right != null){
            currentNode = currentNode.right;
        }

        return currentNode.value;
    }

    /*
     * Prints the tree by calling recursively.
     */
    public void print(){
        printSubtree(root);
    }
    /**
     * Prints the tree by using in-order traversal.
     */
    private void printSubtree(Node curentNode){
        // If the root is null then return
        if (curentNode == null){
            return;
        }

        // Process left subtree
        printSubtree(curentNode.left);

        // Print the root
        System.out.println(curentNode.value);

        // Process right subtree
        printSubtree(curentNode.right);

    }

    /**
     * Displays the appliances in category from lowest price to highest price.
     * @param category The category of the appliances to display.
     */
    public void printCategory(String category){
        // Create a StringBuilder to store the appliances
        StringBuilder appliancesInCategorySB = new StringBuilder();
        appliancesInCategorySB.append("The following appliances are in " + category + ":\n");

        // Start comparing from the root node
        Node currentNode = root;

        // Call the recursive function
        appliancesInCategorySB.append(printCategorySubtree(currentNode, category));
        
        // Prints out the result and formats it by removing extra empty lines
        System.out.println(appliancesInCategorySB.toString().replace("\n\n", "\n"));
    }

    private String printCategorySubtree(Node currentNode, String category){
        
        // Stops when the current node is null
        if (currentNode == null){
            return "";
        }

        // If the current node == category
        else if (currentNode.value.getCategory().equals(category)){
            // Process the node and process its children
            return currentNode.value.toString() + "\n" + printCategorySubtree(currentNode.left, category) + "\n" + printCategorySubtree(currentNode.right, category);
        }

        // If the current node != category and comes before category
        else if(currentNode.value.getCategory().compareTo(category) < 0){
            // Process right subtree
            return printCategorySubtree(currentNode.right, category);
        }

        // If the current node != category and comes after category
        else{
            // Process left subtree
            return printCategorySubtree(currentNode.left, category);
        }
    }
    
}