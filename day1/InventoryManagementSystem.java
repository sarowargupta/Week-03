package com.week3.day1;
class InventoryItem {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryItem next;

    public InventoryItem(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    InventoryItem head;

    public InventoryLinkedList() {
        head = null;
    }

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position (index)
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        InventoryItem newItem = new InventoryItem(itemName, itemId, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            newItem.next = temp.next;
            temp.next = newItem;
        } else {
            System.out.println("Position out of bounds");
        }
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed ID " + itemId );
        } else {
            System.out.println("Item with ID " + itemId + " not found");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found");
    }

    // Search for an item by Item ID or Item Name
    public InventoryItem searchItem(String searchTerm) {
        InventoryItem temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(searchTerm) || temp.itemName.equalsIgnoreCase(searchTerm)) {
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
        return null;
    }

    // Calculate the total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        InventoryItem temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    // Sort the inventory by Item Name or Price
    public void sortInventory(String sortBy, boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, sortBy, ascending);
    }

    private InventoryItem mergeSort(InventoryItem head, String sortBy, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        InventoryItem middle = getMiddle(head);
        InventoryItem nextOfMiddle = middle.next;
        middle.next = null;

        InventoryItem left = mergeSort(head, sortBy, ascending);
        InventoryItem right = mergeSort(nextOfMiddle, sortBy, ascending);

        return merge(left, right, sortBy, ascending);
    }

    private InventoryItem merge(InventoryItem left, InventoryItem right, String sortBy, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        int comparison = 0;
        if (sortBy.equals("name")) {
            comparison = left.itemName.compareTo(right.itemName);
        } else if (sortBy.equals("price")) {
            comparison = Double.compare(left.price, right.price);
        }

        if (!ascending) comparison = -comparison;

        if (comparison <= 0) {
            left.next = merge(left.next, right, sortBy, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, sortBy, ascending);
            return right;
        }
    }

    private InventoryItem getMiddle(InventoryItem head) {
        if (head == null) return head;
        InventoryItem slow = head;
        InventoryItem fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Adding items to the inventory
        inventory.addItemAtEnd("Laptop", 101, 5, 700.00);
        inventory.addItemAtEnd("Smartphone", 102, 10, 300.00);
        inventory.addItemAtBeginning("Headphones", 103, 20, 50.00);
        inventory.addItemAtPosition("Mouse", 104, 15, 25.00, 1);

        // Display the inventory
        System.out.println("Inventory List:");
        inventory.displayInventory();

        // Search for an item
        System.out.println("\nSearching for Item with ID 102:");
        InventoryItem item = inventory.searchItem("102");
        if (item != null) {
            System.out.println("Found Item: " + item.itemName);
        }

        // Update quantity of an item
        inventory.updateQuantityById(102, 12);
        System.out.println("\nUpdated Inventory List:");
        inventory.displayInventory();

        // Remove an item
        inventory.removeItemById(104);
        System.out.println("\nInventory List After Removal:");
        inventory.displayInventory();

        // Calculate total inventory value
        double totalValue = inventory.calculateTotalValue();
        System.out.println("\nTotal Inventory Value: " + totalValue);

        // Sort inventory by price in ascending order
        inventory.sortInventory("price", true);
        System.out.println("\nSorted Inventory by Price (Ascending):");
        inventory.displayInventory();
    }
}

