import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class YourPantry {

	private GTerm gt;


	private int NumProductCategories;
	private int CurrentNumProductCategories;
	
	private String[] ProductNames;
	private char[] Grade;
	private double[] Weight;
	private double[] Prices;
	
	private int indexOfInputTextField;

	public YourPantry() {

		this.gt = new GTerm(660, 600);

		this.NumProductCategories = 100;
		this.CurrentNumProductCategories = 0;

		this.ProductNames = new String[this.NumProductCategories];
		this.Grade = new char[this.NumProductCategories];
		this.Weight = new double[this.NumProductCategories];
		this.Prices = new double[this.NumProductCategories];

		this.gt.setBackgroundColor(220, 130, 100);
		this.gt.setFontSize(22);
		this.gt.println("Your Pantry");
		this.gt.setXY(0, 50);
		this.gt.setFontSize(18);
		this.gt.println("Browse the table and select the food you need to purchase.");
		this.gt.println("You can use the search function to quickly filter.");
		this.gt.println("Refer to the template given below");
		this.gt.println("E.g: apple");
		this.gt.println("");

		this.indexOfInputTextField = this.gt.addTextField("", 300);
		this.gt.println("");
		this.gt.addTable(380, 350, "Name\tGrade\tWeight(.KG)\tPrice(.$)");

		this.gt.setXY(390, 250);
		this.gt.addButton("More Information", this, "MoreInformation");		
		this.gt.setXY(390, 300);
		this.gt.addButton("search", this, "SearchProductFromEntry");
		this.gt.setXY(390, 350);
		this.gt.addButton("Refresh", this, "Refresh");
		this.gt.setXY(390, 400);
		this.gt.addButton("load", this, "Load");
		this.gt.setXY(390, 450);
		this.gt.addButton("Buy", this, "Buy");
		this.gt.println("");
	}
	
	public void Load() {
		try {
			String filename = this.gt.getFilePath();
			if (filename != null) {
				BufferedReader inputFile = new BufferedReader(new FileReader(this.gt.getFilePath()));

				String rawInput = inputFile.readLine();

				while (rawInput != null) {
					// ---------------------------------------
					String[] fieldOfProduct = rawInput.split(",");
					String names = fieldOfProduct[0];
					char grade = fieldOfProduct[1].charAt(0);
					double weights = Double.parseDouble(fieldOfProduct[2]);
					double prices = Double.parseDouble(fieldOfProduct[3]);
					
					addProduct(names, grade, weights, prices);
					// ----------------------------------------
					rawInput = inputFile.readLine();
				}

				inputFile.close();
			}
		} catch (Exception e) {
			this.gt.showErrorDialog("Something went wrong when reading the file." + e.getMessage());
		}
		Refresh();
	}	

	public void Buy() {
		String edit = this.gt.getSelectedRowFromTable(0);
		String[] fieldsOfProducts = edit.split("\t");
		String name = fieldsOfProducts[0];
		int i = getProductIndexByName(name);
		double trueprice;
		this.Weight[i] = Double.parseDouble(this.gt.getInputString("Please enter the weight to be purchased:"));
		while (this.Weight[i] <= 0) {
			this.Weight[i] = Integer.parseInt(this.gt.getInputString(
					"Error! The weight of the product should not be less than or equal to 0, please enter again."));
		}
		trueprice = this.Weight[i] * this.Prices[i];
		
		this.gt.showMessageDialog("Completed the purchase. You spent " + trueprice + " dollars");
	}
	
	public void SearchProductFromEntry() {
		String searchTargetName = this.gt.getTextFromEntry(0);
		
		this.gt.clearRowsOfTable(0);
		int i = 0;
		
		while(i < this.CurrentNumProductCategories) {
			if(this.ProductNames[i].contains(searchTargetName)) {
				String rowData = this.ProductNames[i] + "\t" + this.Grade[i] + "\t" + this.Weight[i] + "\t" + this.Prices[i];
				this.gt.addRowToTable(0, rowData);
			}
			i++;
		}

	}
	
	public void addProduct(String names, char grade, double weights, double prices) {
		int i = getProductIndexByName(names);
		if(i<0) {
			this.ProductNames[this.CurrentNumProductCategories] = names;
			this.Grade [this.CurrentNumProductCategories] = grade;
			this.Weight[this.CurrentNumProductCategories] = weights;
			this.Prices[this.CurrentNumProductCategories] = prices;
			this.CurrentNumProductCategories++;
		}else {
			this.gt.showErrorDialog("Error!");
		}
	}

	public void Refresh() {

		this.gt.clearRowsOfTable(0);
		int i = 0;
		while (i < this.CurrentNumProductCategories) {
			String rowData = this.ProductNames[i] + "\t" + this.Grade[i] + "\t" + this.Weight[i] + "\t" + this.Prices[i];
			this.gt.addRowToTable(0, rowData);
			i++;
		}
	}
	
	public int getProductIndexByName(String search) {

		int FindSearch = 0;
		while ((FindSearch < this.CurrentNumProductCategories)
				&& (this.ProductNames[FindSearch].compareTo(search) != 0)) {
			FindSearch++;
		}


		if (FindSearch >= this.CurrentNumProductCategories) {
			FindSearch = -1;
		}
		return FindSearch;
	}

//	public void removeSelectedProduct() {
//		String remove = this.gt.getSelectedRowFromTable(0);
//		String[] fieldsOfProducts = remove.split("\t");
//		String searchTargetName = fieldsOfProducts[0];
//
//		int i = getProductIndexByName(searchTargetName);
//
//		if (i >= 0) {
//			while (i < this.CurrentNumProductCategories - 1) {
//				
//				this.ProductNames[i] = this.ProductNames[i + 1];
//				this.Grade[i] = this.Grade[i + 1];
//				this.Weight[i] = this.Weight[i + 1];
//				this.Prices[i] = this.Prices[i + 1];
//				i++;
//			}
//			this.CurrentNumProductCategories--;
//			Refresh();
//		} else {
//			this.gt.showErrorDialog("No this product information found!");
//		}
//
//	}

//	public void Edit() {
//		String edit = this.gtbuy.getSelectedRowFromTable(0);
//		String[] fieldsOfProducts = edit.split("\t");
//		String name = fieldsOfProducts[0];
//
//		if (edit != null) {
//
//			int i = getProductIndexByName(name);
////			this.ProductNames[i] = this.gt.getInputString("Please enter the name:");
////			this.Grade[i] = this.gt.getInputString("Please enter the grade:").charAt(0);
//			this.Weight[i] = Double.parseDouble(this.gtbuy.getInputString("Please enter the number:"));
//			while (this.Weight[i] <= 0) {
//				this.Weight[i] = Integer.parseInt(this.gtbuy.getInputString(
//						"Error! The number of the product should not be less than or equal to 0, please enter again."));
//			}
//
////			this.Prices[i] = Double.parseDouble(this.gt.getInputString("Please enter the price:"));
////			while (this.Prices[i] <= 0) {
////				this.Prices[i] = Double.parseDouble(this.gt.getInputString(
////						"Error! The price of the product should not be less than or equal to 0, please enter again."));
////			}
//
//
//			this.gtbuy.addRowToTable(0, this.ProductNames[i] + "\t" + this.Grade[i] + "\t" + this.Weight[i] + "\t" + this.Prices[i]);
//			Refresh();
//			this.gtbuy.setTextInEntry(0, "");
//
//		}
//
//	}

//	public void InventoryChanges() {
//
//		String rawInput = this.gt.getTextFromEntry(0);
//		String[] fieldsOfProducts = rawInput.split(",");
//
//		
//		String names = fieldsOfProducts[0];
//		char grade = fieldsOfProducts[1].charAt(0);
//
//		double weights = Double.parseDouble(fieldsOfProducts[2]);
//		while (weights <= 0) {
//			weights = Integer.parseInt(this.gt.getInputString(
//					"Error! The number of the product should not be less than or equal to 0, please enter again."));
//		}
//
//		double price = Double.parseDouble(fieldsOfProducts[3]);
//		while (price <= 0) {
//			price = Double.parseDouble(this.gt.getInputString(
//					"Error! The price of the product should not be less than or equal to 0, please enter again."));
//		}
//
//		this.ProductNames[this.CurrentNumProductCategories] = names;
//		this.Grade[this.CurrentNumProductCategories] = grade;
//		this.Weight[this.CurrentNumProductCategories] = weights;
//		this.Prices[this.CurrentNumProductCategories] = price;
//
//		this.gt.addRowToTable(0,names + "\t" + grade + "\t" + weights + "\t" + price);
//
//		this.gt.setTextInEntry(0, "");
//
//		this.CurrentNumProductCategories++;
//
//	}

	public void MoreInformation() {

		String selectedListItem = this.gt.getSelectedRowFromTable(0);
		if (selectedListItem != null) {
			String[] fieldOfProduct = selectedListItem.split("\t");
			String name = fieldOfProduct[0];
//			char grade = fieldOfProduct[1].charAt(0);
			double weights = Double.parseDouble(fieldOfProduct[2]);
			double Price = Double.parseDouble(fieldOfProduct[3]);


			double totalAmount = weights * Price;

			String message = name + "'s ";
			if (totalAmount > 20) {
				message += "total amount exceeds 20 dollars.";
			} else {
				message += "total amount insufficients 20 dollars.";
			}

			message += "The actual amount: " + totalAmount;
			this.gt.showMessageDialog(message);

		}

	}

	public static void main(String[] args) {
		YourPantry Hobj = new YourPantry();
	}
}
