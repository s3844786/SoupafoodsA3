import javax.swing.JOptionPane;

public class ShoppingList {

	private GTerm gt;

	private int NumProductCategories;
	private int CurrentNumProductCategories;

	private String[] ShoppingListName;
	private String[] ItemName;
	private int[] ItemNum;
	private double[] Prices;

	private int indexOfInputTextField;

	public ShoppingList() {

		this.gt = new GTerm(660, 600);

		this.NumProductCategories = 100;
		this.CurrentNumProductCategories = 0;

		this.ShoppingListName = new String[NumProductCategories];
		this.ItemName = new String[NumProductCategories];
		this.ItemNum = new int[NumProductCategories];
		this.Prices = new double[NumProductCategories];

		this.gt.setBackgroundColor(255, 250, 250);
		this.gt.setFontSize(18);

		this.gt.println("Shopping List");
		this.gt.println("Please enter the information to be recorded:");
		this.gt.println("Refer to the template given below");
		this.gt.println("Name of the shopping list, Item, Number, Price");
		this.gt.println("E.g: Testlist,apple,12,1.99");
		this.gt.println("");

//		this.gt.setXY(390, 50);
//		this.gt.addButton("apple", this, "apple");

		this.indexOfInputTextField = this.gt.addTextField("", 400);
		this.gt.println("");
		this.gt.addTable(380, 350, "List Name\tItems Name\tNumber\tPrice");
		this.gt.setXY(390, 200);
		this.gt.addButton("food", this, "food");
		this.gt.setXY(390, 150);
		this.gt.addButton("fruits", this, "fruits");
		this.gt.setXY(490, 200);
		this.gt.addButton("drinks", this, "drinks");
		this.gt.setXY(490, 150);
		this.gt.addButton("vegetables", this, "vegetables");

//		this.gt.setXY(390, 250);

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

	}
	public void vegetables() {
		int i, round;
		String items = " Your fav foods:";
		i = Integer.parseInt(this.gt.getInputString("Enter the number of your favorite vegetables"));

		String[] names;
		names = new String[i];

		round = i;
		i = 0;
		while (i < round) {

			names[i] = this.gt.getInputString("Enter items: " + i);

			i++;
		}

		i = 0;
		while (i < round) {

			items = items +names[i]+ ",";// This code is to put all the items and states together Sequentially

			i++;

		}
		this.gt.showMessageDialog(items);
	}

	public void food() {
		int i, round;
		String items = " Your fav foods:";
		i = Integer.parseInt(this.gt.getInputString("Enter the number of your favorite food"));

		String[] names;
		names = new String[i];

		round = i;
		i = 0;
		while (i < round) {

			names[i] = this.gt.getInputString("Enter items: " + i);

			i++;
		}

		i = 0;
		while (i < round) {

			items = items +names[i]+ ",";// This code is to put all the items and states together Sequentially

			i++;

		}
		this.gt.showMessageDialog(items);
	}
	public void fruits() {
		int i, round;
		String items = " Your fav fruits:";
		i = Integer.parseInt(this.gt.getInputString("Enter the number of your favorite fruits"));

		String[] names;
		names = new String[i];

		round = i;
		i = 0;
		while (i < round) {

			names[i] = this.gt.getInputString("Enter items: " + i);

			i++;
		}

		i = 0;
		while (i < round) {

			items = items +names[i]+ ",";// This code is to put all the items and states together Sequentially

			i++;

		}
		this.gt.showMessageDialog(items);
	}
	public void drinks() {
		int i, round;
		String items = " Your fav foods:";
		i = Integer.parseInt(this.gt.getInputString("Enter the number of your favorite drinks"));

		String[] names;
		names = new String[i];

		round = i;
		i = 0;
		while (i < round) {

			names[i] = this.gt.getInputString("Enter items: " + i);

			i++;
		}

		i = 0;
		while (i < round) {

			items = items +names[i]+ ",";// This code is to put all the items and states together Sequentially

			i++;

		}
		this.gt.showMessageDialog(items);
	}

	public void Refresh() {

		this.gt.clearRowsOfTable(0);
		int i = 0;
		while (i < this.CurrentNumProductCategories) {
			String rowData = this.ShoppingListName[i] + "\t" + this.ItemName[i] + "\t" + this.ItemNum[i] + "\t"
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
				this.ItemName[i] = this.ItemName[i + 1];
				this.ItemNum[i] = this.ItemNum[i + 1];
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
			this.ItemName[i] = this.gt.getInputString("Please enter the item name:");

			this.ItemNum[i] = Integer.parseInt(this.gt.getInputString("Please enter the item number:"));
			while (this.ItemNum[i] <= 0) {
				this.ItemNum[i] = Integer.parseInt(this.gt.getInputString(
						"Error! The number of the product should not be less than or equal to 0, please enter again."));
			}

			this.Prices[i] = Double.parseDouble(this.gt.getInputString("Please enter the price:"));
			while (this.Prices[i] <= 0) {
				this.Prices[i] = Double.parseDouble(this.gt.getInputString(
						"Error! The price of the product should not be less than or equal to 0, please enter again."));
			}

			this.gt.addRowToTable(0, this.ShoppingListName[i] + "\t" + this.ItemName[i] + "\t" + this.ItemNum[i] + "\t"
					+ this.Prices[i]);
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
		this.ItemName[this.CurrentNumProductCategories] = name;
		this.ItemNum[this.CurrentNumProductCategories] = number;
		this.Prices[this.CurrentNumProductCategories] = price;

		this.gt.addRowToTable(0, Sname + "\t" + name + "\t" + number + "\t" + price);

		this.gt.setTextInEntry(0, "");

		this.CurrentNumProductCategories++;

	}

	public static void main(String[] args) {
		ShoppingList Hobj = new ShoppingList();
	}
}
