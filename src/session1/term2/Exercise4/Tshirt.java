package session1.term2.Exercise4;

public class Tshirt {
    private int shirtID;
    private String description;
    private char size;
    private double price;
    private int quantityInStock;

    public Tshirt(int shirtID, String description, char size, double price, int quantityInStock) {
        this.shirtID = shirtID;
        this.description = description;
        this.size = size;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "shirtID=" + shirtID +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public void displayInformation() {
        System.out.println(toString());
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void addStock(int newStock){
        quantityInStock += newStock;
    }
}
