
public class History {

	private GTerm gt;

	private int NumProductCategories;
	private int CurrentNumProductCategories;

	private String[] ShoppingListName;
	private String[] ProductNames;
	private int[] ProductNums;
	private double[] Prices;

	private int indexOfInputTextField;


	public History() {

		this.gt = new GTerm(660, 600);

		this.NumProductCategories = 100;
		this.CurrentNumProductCategories = 0;

		this.ShoppingListName = new String[NumProductCategories];
		this.ProductNames = new String[NumProductCategories];
		this.ProductNums = new int[NumProductCategories];
		this.Prices = new double[NumProductCategories];

		this.gt.setBackgroundColor(255, 250, 250);
		this.gt.setFontSize(18);

		this.gt.println("Shopping List");

		this.gt.setXY(0, 50);
		this.gt.println("Please enter the information to be recorded:");
		this.gt.println("Refer to the template given below");
		this.gt.println("Name of the shopping list, Item, Number, Price");
		this.gt.println("E.g: Testlist,apple,12,1.99");
		this.gt.println("");

		this.indexOfInputTextField = this.gt.addTextField("", 300);
		this.gt.println("");
		this.gt.addTable(380, 350, "List Name\tName\tNumber\tPrice");

		this.gt.setXY(390, 250);
	
//		this.gt.addButton("Search", this, "SearchProductFromEntry");
		this.gt.setXY(390, 300);
		this.gt.addButton("Determine", this, "InventoryChanges");
		this.gt.setXY(390, 350);
		this.gt.addButton("Refresh", this, "Refresh");
		this.gt.setXY(390, 400);
		this.gt.addButton("Remove", this, "removeSelectedProduct");
		this.gt.setXY(390, 450);
		this.gt.addButton("Edit", this, "Edit");
		this.gt.println("");
//		this.gt.setXY(0, 570);
//		this.gt.println("Note: When storing in the warehouse,");
//		this.gt.println("please add store(s) after the product name.");
//		this.gt.println("Note: When picking up goods from the warehouse,");
//		this.gt.println("please add extract(e) after the product name.");
	}

//	public void SearchProductFromEntry() {
//
//		String searchTargetName = this.gt.getTextFromEntry(0);
//
//		int i = getProductIndexByName(searchTargetName);
////		int i = this.CurrentNumProductCategories;
//		if (i >= 0) {
//			while(i<=this.CurrentNumProductCategories) {
//			   this.gt.clearRowsOfTable(0);
//			   String rowData = this.Data[i]+ "\t" + this.ProductNames[i] + "\t" + this.ProductNums[i] + "\t" + this.Prices[i];
//			   this.gt.addRowToTable(0, rowData);
//			   i++;
//			}
//
//		} else {
//			this.gt.showErrorDialog("There's no history about " + searchTargetName);
//			Refresh();
//		}
//	}

	public void Refresh() {

		this.gt.clearRowsOfTable(0);
		int i = 0;
		while (i < this.CurrentNumProductCategories) {
			String rowData = this.ShoppingListName[i]+ "\t" + this.ProductNames[i] + "\t" + this.ProductNums[i] + "\t"
					+ this.Prices[i];
			this.gt.addRowToTable(0, rowData);
			i++;
		}
	}

	public int getProductIndexByName(String search) {

		int FindSearch = 0;
		while ((FindSearch < this.CurrentNumProductCategories)
				&& (this.ShoppingListName[FindSearch].compareTo(search) != 0)) {
			FindSearch++;
		}


		if (FindSearch >= this.CurrentNumProductCategories) {
			FindSearch = -1;
		}
		return FindSearch;
	}

	public void removeSelectedProduct() {
		String remove = this.gt.getSelectedRowFromTable(0);
		String[] fieldsOfProducts = remove.split("\t");
		String searchTargetName = fieldsOfProducts[0];

		int i = getProductIndexByName(searchTargetName);

		if (i >= 0) {
			while (i < this.CurrentNumProductCategories - 1) {
				this.ShoppingListName[i] = this.ShoppingListName[i + 1];
				this.ProductNames[i] = this.ProductNames[i + 1];
				this.ProductNums[i] = this.ProductNums[i + 1];
				this.Prices[i] = this.Prices[i + 1];
				i++;
			}
			this.CurrentNumProductCategories--;
			Refresh();
		} else {
			this.gt.showErrorDialog("No this product information found!");
		}

	}

	public void Edit() {
		String edit = this.gt.getSelectedRowFromTable(0);
		String[] fieldsOfProducts = edit.split("\t");
		String name = fieldsOfProducts[0];

		if (edit != null) {

			int i = getProductIndexByName(name);
			this.ShoppingListName[i] = this.gt.getInputString("Please enter the shopping list name:");
			this.ProductNames[i] = this.gt.getInputString("Please enter the item name:");

			this.ProductNums[i] = Integer.parseInt(this.gt.getInputString("Please enter the item number:"));
			while (this.ProductNums[i] <= 0) {
				this.ProductNums[i] = Integer.parseInt(this.gt.getInputString(
						"Error! The number of the product should not be less than or equal to 0, please enter again."));
			}

			this.Prices[i] = Double.parseDouble(this.gt.getInputString("Please enter the price:"));
			while (this.Prices[i] <= 0) {
				this.Prices[i] = Double.parseDouble(this.gt.getInputString(
						"Error! The price of the product should not be less than or equal to 0, please enter again."));
			}


			this.gt.addRowToTable(0, this.ShoppingListName[i] + "\t" + this.ProductNames[i] + "\t" + this.ProductNums[i] + "\t" + this.Prices[i]);
			Refresh();
			this.gt.setTextInEntry(0, "");

		}

	}

	public void InventoryChanges() {

		String rawInput = this.gt.getTextFromEntry(0);
		String[] fieldsOfProducts = rawInput.split(",");

		String Sname = fieldsOfProducts[0];
		String name = fieldsOfProducts[1];

		int number = Integer.parseInt(fieldsOfProducts[2]);
		while (number <= 0) {
			number = Integer.parseInt(this.gt.getInputString(
					"Error! The number of the product should not be less than or equal to 0, please enter again."));
		}

		double price = Double.parseDouble(fieldsOfProducts[3]);
		while (price <= 0) {
			price = Double.parseDouble(this.gt.getInputString(
					"Error! The price of the product should not be less than or equal to 0, please enter again."));
		}

		this.ShoppingListName[this.CurrentNumProductCategories] = Sname;
		this.ProductNames[this.CurrentNumProductCategories] = name;
		this.ProductNums[this.CurrentNumProductCategories] = number;
		this.Prices[this.CurrentNumProductCategories] = price;

		this.gt.addRowToTable(0, Sname + "\t" + name + "\t" + number + "\t" + price);

		this.gt.setTextInEntry(0, "");

		this.CurrentNumProductCategories++;

	}

	public void MoreInformation() {

		String selectedListItem = this.gt.getSelectedRowFromTable(0);
		if (selectedListItem != null) {
			String[] fieldOfProduct = selectedListItem.split("\t");
			String data = fieldOfProduct[0];
			String name = fieldOfProduct[1];
			int number = Integer.parseInt(fieldOfProduct[2]);
			double Price = Double.parseDouble(fieldOfProduct[3]);


			double totalAmount = number * Price;

			String message = name + "'s ";
			if (totalAmount > 120) {
				message += "total amount exceeds 120 dollars.";
			} else {
				message += "total amount insufficients 120 dollars.";
			}

			message += "The actual amount: " + totalAmount;
			this.gt.showMessageDialog(message);

		}

	}

	public static void main(String[] args) {
		History Hobj = new History();
	}
}
