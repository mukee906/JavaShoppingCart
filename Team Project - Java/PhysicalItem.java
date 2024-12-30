public class PhysicalItem extends Item {
    private  double taxRate;

    public PhysicalItem(String itemName, double itemPrice, double taxRate) {
        super(itemName, itemPrice);
        this.taxRate = taxRate;
    }

    public  double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double calculatePriceWithTax() {
        return getItemPrice()+ TaxCalculator.calculateTax(this);
    }
}
