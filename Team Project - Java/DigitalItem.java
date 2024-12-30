public class DigitalItem extends Item {
    public DigitalItem(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }
    //private double taxRate=0.0;

    public double getTaxRate() {
        return 0.0; // digital items have  no tax
    }


    @Override
    public double calculatePriceWithTax() {
        return getItemPrice(); // No tax for digital items
    }
}
