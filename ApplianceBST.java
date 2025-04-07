public class ApplianceBST {
    
    // Initialise the root of the tree
    private Node root;

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
        else if (a.compareTo(currentRoot.value) < 0){
            currentRoot.left = insert(currentRoot.left, a);
        }

        // If the value is greater then add it to the right subtree
        else if (a.compareTo(currentRoot.value) > 0){
            currentRoot.right = insert(currentRoot.right, a);
        }

        return currentRoot;
    }

    public void remove(Appliance a){
        // Create a current node to traverse the tree
        Node currentNode = root;

        // If the appliance is in the tree
        if(search(a)){
            // Find the current root of the appliance we want to remove
            while(currentNode.value != a){
                if(a.compareTo(currentNode.value) < 0){
                    currentNode = currentNode.left;
                }
                else if(a.compareTo(currentNode.value) > 0){
                    currentNode = currentNode.right;
                }
            }

            // If the appliance is the leaf node, remove it
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            }

            // If the appliance has one child, remove it and replace it with the child
            else if(currentNode.left == null || currentNode.right == null){
                if(currentNode.left != null){
                    currentNode = currentNode.left;
                }
                else{
                    currentNode = currentNode.right;
                }
            }

            // If the appliance has two children, find the leftmost node of the right subtree
            else{
                // Default to the right child
                Node leftmostNode = currentNode.right;

                while(leftmostNode.left != null){
                    leftmostNode = leftmostNode.left;
                }

                // Replace the parent node with the leftmost child of the right subtree
                currentNode = leftmostNode;
            }
            
            
        }

        else{
            System.out.println("Appliance not found in the tree.");
        }
    }

    /**
     * Inserts a new appliance into the tree from the root
     * @param a The new appliance to insert.
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
    public boolean searchSubtree(Node currentRoot, Appliance a){
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
}