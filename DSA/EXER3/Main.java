public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.75),
            new Order(102, "Bob", 89.99),
            new Order(103, "Charlie", 430.00),
            new Order(104, "Diana", 15.50),
            new Order(105, "Ethan", 320.20)
        };

        
        Order[] bubbleOrders = orders.clone();
        Order[] quickOrders = orders.clone();

        BubbleSort.sort(bubbleOrders);
        QuickSort.sort(quickOrders, 0, quickOrders.length - 1);

        System.out.println("Bubble Sort Result:");
        for (Order o : bubbleOrders) System.out.println(o);

        System.out.println("\nQuick Sort Result:");
        for (Order o : quickOrders) System.out.println(o);
    }
}