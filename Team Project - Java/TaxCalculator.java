public class TaxCalculator {
	
	TaxCalculator() {};

	// Overloaded method to calculate tax for a single item
	public static double calculateTax (Item item) {
		return item.getItemPrice() * item.getTaxRate() * 0.01;
	}

	// Overloaded method to calculate tax for an array of items
	public  static double calculateTax (Item[] items, int numberOfItems) {
		double totalTax = 0;
		for (int i = 0; i < numberOfItems; i++){
			totalTax += items[i].getItemPrice() * items[i].getTaxRate() * 0.01;
		}	
		return totalTax;
	}
	
}
