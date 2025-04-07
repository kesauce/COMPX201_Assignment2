public class ApplianceBST {
    
    /**
     * Inserts a new appliance into the tree.
     * @param currentRoot The current root of the tree/subtree.
     * @param a The new appliance to insert.
     * @return The new current root of the tree/subtree.
     */
    public Node insert(Node currentRoot, Appliance a){
        // When the tree is null
        if (currentRoot == null){
            currentRoot = new Node(a);
        }

        // If the value is smaller then add it to the left subtree
        else if (a.compareTo(currentRoot.appliance) < 0){
            currentRoot.left = insert(currentRoot.left, a);
        }

        // If the value is greater then add it to the right subtree
        else if (a.compareTo(currentRoot.appliance) > 0){
            currentRoot.right = insert(currentRoot.right, a);
        }

        return currentRoot;
    }

    /**
     * Searches for an appliance in the tree.
     * @param currentRoot The current root of the tree/subtree.
     * @param a The appliance to search for.
     * @return True if the appliance is found, false otherwise.
     */
    public boolean search(Appliance a){
        return searchSubtree(root, a);
    }

    public boolean searchSubtree(Node currentRoot, Appliance a){
        // Checks if the root is null
        if (currentRoot == null){
            return false;
        }

        // Checks if the current root is the appliance we are looking for
        else if (currentRoot.appliance == a){
            return true;
        }

        // Do recursive search in the left subtree
        else if (a .compareTo(currentRoot.appliance) < 0){
            return searchSubtree(currentRoot.left, a);
        }

        // Do recursive search in the right subtree
        else if (a.compareTo(currentRoot.appliance) > 0){
            return searchSubtree(currentRoot.right, a);
        }

        return false;

    }
}