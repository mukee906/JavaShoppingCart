import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingCartSystem extends JFrame implements ActionListener {
	// Create a cart object
	Cart ShoppingCart = new Cart();

	// Define GUI components
	JLabel lblItemName, lblItemPrice, lblTaxRate, lblPriceWithTax, lblTotalPrice, lblTotalPriceWithTax, lblListItems,
			lblWelcome, lblWelcomeImage, lblItemType;
	JTextField tfItemName, tfItemPrice, tfTaxRate;
	JButton btnAddItem, btnTotalPrice, btnTotalPriceTax, btnOpenStore, btnCheckout, btnExit;
	JComboBox<String> cbItemType;
	JPanel panelItemName, panelItemPrice, panelTaxRate, panelItemDetails, panelAddItem, layout, layout0, layout1,
			layout2, panelTotalPrice, panelTotalTaxPrice, panelItemType;
	GridBagConstraints gbcWelcome, gbcButtonSize, gbcItem, gbcItemDetails, gbcAddItem, gbcCheckout, gbcTotalPrice;
	CardLayout cardLayout;
	GridBagLayout gBagLayout;

	// constructor for GUI components
	ShoppingCartSystem() {
		ImageIcon imageIcon = new ImageIcon("Cart.png");
		lblWelcomeImage = new JLabel(imageIcon);
		lblWelcomeImage.setPreferredSize(new Dimension(144, 101));

		// label welcome
		lblWelcome = new JLabel("THE MSN STORE");
		lblWelcome.setFont(new Font("Wide Latin", Font.BOLD, 32));
		lblWelcome.setForeground(clrButton);
		lblWelcome.setOpaque(false);

		// create lable and field for item name
		lblItemName = new JLabel("Item Name:");
		tfItemName = new RoundedTextField(13, radius, clrInputField);
		outputField(lblItemName, ofFontSize, false);
		inputField(tfItemName);

		// create label and field for price
		lblItemPrice = new JLabel("Price in AED:");
		tfItemPrice = new RoundedTextField(13, radius, clrInputField);
		outputField(lblItemPrice, ofFontSize, false);
		inputField(tfItemPrice);

		// create field for item type
		lblItemType = new JLabel("Item Type: ");
		outputField(lblItemType, ofFontSize, false);
		String[] itemTypes = { "Physical Item", "Digital Item" };
		cbItemType = new JComboBox<>(itemTypes);
		cbItemType.setFont(new Font("Century Gothic", Font.BOLD, 13));
		cbItemType.setBackground(clrInputField);

		// create label and field for tax rate
		lblTaxRate = new JLabel("Tax Rate (%): ");
		tfTaxRate = new RoundedTextField(13, radius, clrInputField);
		outputField(lblTaxRate, ofFontSize, false);
		inputField(tfTaxRate);

		// Create button objects
		btnOpenStore = new RoundedButton("OPEN", 30, clrButton);
		btnAddItem = new RoundedButton("ADD", 30, clrButton);
		btnCheckout = new RoundedButton("CHECKOUT", radius, clrButton);
		btnTotalPrice = new RoundedButton("Total Price", radius, clrButton);
		btnTotalPriceTax = new RoundedButton("Total + Tax", radius, clrButton);
		btnExit = new RoundedButton("EXIT", radius, clrButton);

		// customize buttons
		customIsolatedButton(btnOpenStore);
		customIsolatedButton(btnAddItem);
		customIsolatedButton(btnCheckout);
		customIsolatedButton(btnTotalPrice);
		customIsolatedButton(btnTotalPriceTax);
		customIsolatedButton(btnExit);
		btnAddItem.setMargin(new Insets(2, 12, 3, 12));
		btnOpenStore.setMargin(new Insets(2, 36, 3, 36));

		// labels for prices with and without tax
		lblPriceWithTax = new JLabel();
		outputField(lblPriceWithTax, btnFontSize, true);
		lblTotalPrice = new JLabel();
		outputField(lblTotalPrice, btnFontSize, true);
		lblTotalPriceWithTax = new JLabel();
		outputField(lblTotalPriceWithTax, btnFontSize, true);

		// lable for list of items added
		lblListItems = new JLabel();
		outputField(lblListItems, ofFontSize, true);
		lblListItems.setPreferredSize(new Dimension(480, 20));

		// bind action listener to each of the buttons
		btnOpenStore.addActionListener(this);
		btnAddItem.addActionListener(this);
		btnCheckout.addActionListener(this);
		btnTotalPrice.addActionListener(this);
		btnTotalPriceTax.addActionListener(this);
		btnExit.addActionListener(this);

		// layout for item details
		gbcWelcome = new GridBagConstraints();
		gbcWelcome.gridx = 0;
		gbcWelcome.gridwidth = 500;
		gbcWelcome.gridheight = 300;
		gbcWelcome.fill = GridBagConstraints.NONE;
		gbcWelcome.insets = new Insets(5, 0, 40, 0);

		gbcItem = new GridBagConstraints();
		gbcItem.gridx = 0;
		gbcItem.gridwidth = 700;
		gbcItem.anchor = GridBagConstraints.WEST;

		gbcItemDetails = new GridBagConstraints();
		gbcItemDetails.gridx = 0;
		gbcItemDetails.gridwidth = 700;
		gbcItemDetails.insets = new Insets(10, 20, 0, 0);
		gbcItemDetails.anchor = GridBagConstraints.WEST;

		gbcAddItem = new GridBagConstraints();
		gbcAddItem.gridx = 0;
		gbcAddItem.gridwidth = 700;
		gbcAddItem.insets = new Insets(20, 100, 0, 0);

		gbcCheckout = new GridBagConstraints();
		gbcCheckout.gridx = 0;
		gbcCheckout.gridwidth = 700;
		gbcCheckout.insets = new Insets(0, 30, 0, 0);
		gbcCheckout.anchor = GridBagConstraints.EAST;

		gbcTotalPrice = new GridBagConstraints();
		gbcTotalPrice.gridx = 0;
		gbcTotalPrice.gridwidth = 700;
		gbcTotalPrice.insets = new Insets(0, 0, 20, 0);
		gbcTotalPrice.anchor = GridBagConstraints.WEST;

		gbcButtonSize = new GridBagConstraints();
		gbcButtonSize.gridx = 0;
		gbcButtonSize.gridwidth = 700;
		gbcButtonSize.insets = new Insets(30, 0, 30, 0);

		// panel for item details
		gBagLayout = new GridBagLayout();
		panelItemDetails = new JPanel(gBagLayout);
		panelItemDetails.setOpaque(false);

		// panels for item name, price, and tax
		panelItemName = new JPanel(gBagLayout);
		panelItemName.setOpaque(false);
		panelItemName.add(lblItemName, gbcItem);
		panelItemName.add(tfItemName, gbcItem);

		panelItemPrice = new JPanel(gBagLayout);
		panelItemPrice.setOpaque(false);
		panelItemPrice.add(lblItemPrice, gbcItem);
		panelItemPrice.add(tfItemPrice, gbcItem);

		panelTaxRate = new JPanel(gBagLayout);
		panelTaxRate.setOpaque(false);
		panelTaxRate.add(lblTaxRate, gbcItem);
		panelTaxRate.add(tfTaxRate, gbcItem);

		// Panel for Item Type
		panelItemType = new JPanel(gBagLayout);
		panelItemType.setOpaque(false);
		panelItemType.add(lblItemType, gbcItem);
		panelItemType.add(cbItemType, gbcItem);

		// add item info to item details panel
		panelItemDetails.add(panelItemName, gbcItemDetails);
		panelItemDetails.add(panelItemPrice, gbcItemDetails);
		panelItemDetails.add(panelTaxRate, gbcItemDetails);
		panelItemDetails.add(panelItemType, gbcItemDetails);

		// add item button and text field
		panelAddItem = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelAddItem.setOpaque(false);
		panelAddItem.add(btnAddItem);
		panelAddItem.add(lblPriceWithTax);

		// total price panel
		panelTotalPrice = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelTotalPrice.setOpaque(false);
		panelTotalPrice.add(btnTotalPrice);
		panelTotalPrice.add(lblTotalPrice);

		// total tax price panel
		panelTotalTaxPrice = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelTotalTaxPrice.setOpaque(false);
		panelTotalTaxPrice.add(btnTotalPriceTax);
		panelTotalTaxPrice.add(lblTotalPriceWithTax);

		// first frame layout
		layout0 = new JPanel(new GridBagLayout());
		layout0.setBackground(clrBackGround);
		layout0.add(lblWelcomeImage, gbcWelcome);
		layout0.add(lblWelcome, gbcWelcome);
		layout0.add(btnOpenStore, gbcWelcome);

		// second frame layout
		layout1 = new JPanel(new GridBagLayout());
		layout1.setBackground(clrBackGround);
		layout1.add(panelItemDetails, gbcItemDetails);
		layout1.add(panelAddItem, gbcAddItem);
		layout1.add(btnCheckout, gbcCheckout);

		// third frame layout
		layout2 = new JPanel(gBagLayout);
		layout2.setBackground(clrBackGround);
		layout2.add(panelTotalPrice, gbcTotalPrice);
		layout2.add(panelTotalTaxPrice, gbcTotalPrice);
		layout2.add(lblListItems, gbcButtonSize);
		layout2.add(btnExit, gbcCheckout);

		// add frames to card layout
		cardLayout = new CardLayout();
		layout = new JPanel(cardLayout);
		layout.add(layout0, "First");
		layout.add(layout1, "Second");
		layout.add(layout2, "Third");

		// settig the frame
		JFrame frame = new JFrame("Shopping Cart System");
		frame.setSize(700, 450);
		frame.add(layout);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// actions after button click
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String itemName;
		Double itemPrice, taxRate;

		// get item details and handle exceptions
		try {
			itemName = tfItemName.getText();
			itemPrice = Double.parseDouble(tfItemPrice.getText());
			taxRate = Double.parseDouble(tfTaxRate.getText());

		} catch (Exception ex) {
			ex = null;
			itemName = "";
			itemPrice = 0.0;
			taxRate = 0.0;
		}

		// Create the correct type of item based on user selection
		Item tempItem1;
		if ("Physical Item".equals(cbItemType.getSelectedItem())) {
			tempItem1 = new PhysicalItem(itemName, itemPrice, taxRate); // Correct instantiation for physical items
		} else {
			tempItem1 = new DigitalItem(itemName, itemPrice); // Correct instantiation for digital items
			tfTaxRate.setText("");
			tfTaxRate.setEditable(false);
		}
		// select and execute each button
		if (s.equals("ADD") && !itemName.isEmpty()) {
			ShoppingCart.addItems(tempItem1);

			// clear input fields
			tfItemName.setText("");
			tfItemPrice.setText("");
			tfTaxRate.setText("");

			// display price with tax
			String tempPriceWithTax = Double.toString(tempItem1.calculatePriceWithTax());//
			lblPriceWithTax.setText("   AED  " + tempPriceWithTax);

		} else if (s.equals("Total Price") && ShoppingCart.getItemsCount() != 0) {
			// display total price
			String tempTotalPrice = Double.toString(ShoppingCart.calculateTotalPrice());
			lblTotalPrice.setText("   AED  " + tempTotalPrice);

		} else if (s.equals("Total + Tax") && ShoppingCart.getItemsCount() != 0) {
			// display total price with tax
			String tempTotalTaxPrice = Double.toString(ShoppingCart.calculateTotalwithTax());
			lblTotalPriceWithTax.setText("   AED  " + tempTotalTaxPrice);

		} else if (s.equals("OPEN")) {
			// shift to the second frame
			cardLayout.show(layout, "Second");

		} else if (s.equals("CHECKOUT")) {
			// shift to the third frame
			cardLayout.show(layout, "Third");

			// list items added to the cart
			String itemList = "  Added Items:  ";
			for (int i = 0; i < ShoppingCart.getItemsCount(); i++) {
				itemList = "" + itemList + (i + 1) + "." + ShoppingCart.itemsInCart[i].getItemName() + "   ";
			}
			lblListItems.setText(itemList);

		} else if (s.equals("EXIT")) {
			System.exit(ABORT);
		}
	}

	// define custom sizes
	static int radius = 15;
	static int btnFontSize = 16;
	static int ofFontSize = 14;

	// custom colors
	static Color clrBackGround = new Color(61, 90, 128);
	static Color clrLabel = new Color(224, 251, 252);
	static Color clrInputField = new Color(152, 193, 217);
	static Color clrButton = new Color(224, 251, 252);
	static Color clrIsolatedButton = new Color(224, 251, 252);

	// custom button field
	static void customIsolatedButton(JButton btn) {
		btn.setForeground(clrBackGround);
		btn.setFont(new Font("Century Gothic", Font.BOLD, btnFontSize));
		btn.setMargin(new Insets(2, 30, 3, 30));
	}

	// custom output field
	static void outputField(JLabel lbl, int fontSize, boolean isBold) {
		Font font;
		if (isBold)
			font = new Font("Century Gothic", Font.BOLD, fontSize);
		else
			font = new Font("Century Gothic", Font.PLAIN, fontSize);
		lbl.setPreferredSize(new Dimension(320, 20));
		lbl.setFont(font);
		lbl.setForeground(clrLabel);
	}

	// custom input field
	static void inputField(JTextField tf) {
		tf.setMargin(new Insets(3, 10, 2, 10));
		tf.setFont(new Font("Century Gothic", Font.BOLD, 14));
		tf.setForeground(new Color(41, 50, 65));
	}

	public static void main(String[] args) {
		ShoppingCartSystem system = new ShoppingCartSystem();
		system.dispose();
	}
}

// class to create custom textfield
class RoundedTextField extends JTextField {
	private int cornerRadius;
	private Color componentColor;

	public RoundedTextField(int columns, int radius, Color color) {
		super(columns);
		this.cornerRadius = radius;
		this.componentColor = color;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(componentColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
		super.paintComponent(g2);
		g2.dispose();
	}

	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(componentColor);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
		g2.dispose();
	}

	public void setComponentColor(Color color) {
		this.componentColor = color;
		repaint();
	}
}

// class to create custom button
class RoundedButton extends JButton {
	private int cornerRadius;
	private Color buttonColor;

	public RoundedButton(String text, int radius, Color color) {
		super(text);
		this.cornerRadius = radius;
		this.buttonColor = color;
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(buttonColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
		super.paintComponent(g2);
		g2.dispose();
	}

	@Override
	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(buttonColor);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
		g2.dispose();
	}

	public void setButtonColor(Color color) {
		this.buttonColor = color;
		repaint();
	}
}
