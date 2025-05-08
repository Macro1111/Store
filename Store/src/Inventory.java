public class Inventory {
    Product head = null;
    Product last = null;

    public void addProduct(String name, double price) {
        Product newProduct = new Product(name, price);
        if (head == null) {
            head = newProduct;
            last = newProduct;
        } else {
            last.next = newProduct;
            newProduct.previous = last;
            last = newProduct;
        }
    }

    public void listProducts() {
        if (head == null) {
            System.out.println("No products in inventory.");
            return;
        }

        Product current = head;
        while (current != null) {
            System.out.println(current.name + " - $" + current.price);
            current = current.next;
        }
    }

    public void sellProduct(String name) {
        Product current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("Sold: " + current.name + " for $" + current.price);

                if (current == head && current == last) {
                    head = null;
                    last = null;
                } else if (current == head) {
                    head = current.next;
                    head.previous = null;
                } else if (current == last) {
                    last = current.previous;
                    last.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Product not found: " + name);
    }
}