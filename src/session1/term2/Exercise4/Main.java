package session1.term2.Exercise4;

public class Main {
    public static void main(String[] args) {

        Tshirt tshirt1 = new Tshirt(223388, "camiseta manga corta mujer Perkins", 'M',
                19.90, 100);
        tshirt1.displayInformation();
        tshirt1.addStock(5);
        tshirt1.setPrice(15);
        tshirt1.displayInformation();

    }
}
