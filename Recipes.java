import java.awt.Color;

public class Recipes{

	private GTerm gt;
	
	
	//Recipes
	public Recipes() {
	
	this.gt= new GTerm (600,800);
	this.gt.setXY(20, 10);
	this.gt.addButton("Home",this,"GoHome");
	this.gt.setXY(160,10);
	this.gt.setFontSize(30);
	this.gt.print("Recipes");
	
	
	this.gt.setXY(20, 150);
	this.gt.setFontSize(15);
	this.gt.addTextField("", 200);
	this.gt.setXY(240, 150);
	this.gt.addButton("Search",  this,  "Search");
	this.gt.setXY(350, 150);
	this.gt.addButton("Pref.", this, "Preferences");
	
	//random shown recipes
	
	this.gt.setXY(20, 250);
	this.gt.addImageIcon("random recipes 1.png");
	this.gt.setFontSize(18);
	this.gt.setXY(230, 250);
	this.gt.print("Potato Asparagus & Mushroom Mash");
	this.gt.setFontSize(15);	
	this.gt.setXY(230, 269);
	this.gt.print("Breakfast Vegan healthy Easy");
	
	this.gt.setXY(20,500);
	this.gt.addImageIcon("random recipes 2.png");
	this.gt.setFontSize(18);
	this.gt.setXY(230, 500);
	this.gt.print("Savory Vegan Breakfast Bowl");
	this.gt.setFontSize(15);	
	this.gt.setXY(230, 519);
	this.gt.print("Breakfast Vegan healthy Easy");
	
	gt.setXY(0,0);
	gt.addImageIcon("background3.jpg");
	
	}
	
	public void Preferences() {
		
		
		
		this.gt= new GTerm (600,800);
		this.gt.setXY(20, 10);
		this.gt.addButton("Home",this,"GoHome");
		this.gt.setXY(160,10);
		this.gt.setFontSize(25);
		this.gt.print("Preferences");
		
		this.gt.setXY(20,100);
		this.gt.setFontSize(20);
		this.gt.print("Meal Type");
		
		this.gt.setXY(20,140);
		this.gt.setFontSize(18);
		this.gt.print("Breakfast Lunch Dinner Dessert Bakery Items");
		
		this.gt.setXY(20,210);
		this.gt.setFontSize(20);
		this.gt.print("Dietary Type");
		
		this.gt.setXY(20,250);
		this.gt.setFontSize(18);
		this.gt.print("Gluten-Free Keto-Diet Lactose-Free Vegan");
		
		this.gt.setXY(20,290);
		this.gt.setFontSize(20);
		this.gt.print("Cuisine");
		
		this.gt.setXY(20,330);
		this.gt.setFontSize(18);
		this.gt.print("Asian Greek Indian Healthy Chinese American");
		
		this.gt.setXY(20,370);
		this.gt.setFontSize(20);
		this.gt.print("Difficulty");
		
		this.gt.setXY(20,410);
		this.gt.setFontSize(18);
		this.gt.print("Easy Intermediate Expert");
		
		this.gt.setXY(20, 450);
		this.gt.addButton("Search", this, "PrefSearch");
		gt.setXY(0,0);
		gt.addImageIcon("background3.jpg");
	}

		public void PrefSearch() {
		gt.clear();
		String PrefSearch = gt.getInputString("Please enter your Preferences");
		this.gt.setXY(20, 10);
		this.gt.addButton("Home",this,"GoHome");
		this.gt.setXY(160,10);
		this.gt.setFontSize(30);
		this.gt.print("Recipes");
		this.gt.setXY(20, 150);
		this.gt.setFontSize(15);
		this.gt.addTextField("", 200);
		this.gt.setXY(240, 150);
		this.gt.addButton("Search",  this,  "Search");
		this.gt.setXY(350, 150);
		this.gt.addButton("Pref.", this, "Preferences");
		
		//random shown recipes
		
		this.gt.setXY(20, 250);
		this.gt.addImageIcon("pref recipes 1 .png");
		this.gt.setFontSize(18);
		this.gt.setXY(230, 250);
		this.gt.print("Mexican Chicken Dinner bowl");
		this.gt.setFontSize(15);	
		this.gt.setXY(230, 269);
		this.gt.print("Dinner Intermediate Gluten-Free ");
		
		this.gt.setXY(20,500);
		this.gt.addImageIcon("pizza recipes 3.jpg");
		this.gt.setFontSize(18);
		this.gt.setXY(230, 500);
		this.gt.print("Gluten-Free Margherita Pizza");
		this.gt.setFontSize(15);	
		this.gt.setXY(230, 519);
		this.gt.print("Dinner Intermediate Gluten-Free");
		gt.setXY(0,0);
		gt.addImageIcon("background3.jpg");	
			
			
		}
		
		public void Search() {
			gt.clear();
			this.gt.setXY(20, 10);
			this.gt.addButton("Home",this,"GoHome");
			this.gt.setXY(160,10);
			this.gt.setFontSize(30);
			this.gt.print("Recipes");
			this.gt.setXY(20, 150);
			this.gt.setFontSize(15);
			this.gt.addTextField("", 200);
			this.gt.setXY(240, 150);
			this.gt.addButton("Search",  this,  "Search");
			this.gt.setXY(350, 150);
			this.gt.addButton("Pref.", this, "Preferences");
			
			//random shown recipes
			
			this.gt.setXY(20, 250);
			this.gt.addImageIcon("pizza recipes 1 .jpg");
			this.gt.setFontSize(18);
			this.gt.setXY(230, 250);
			this.gt.print("Eazy-Cheezy Chicken Pizza");
			this.gt.setFontSize(15);	
			this.gt.setXY(230, 269);
			this.gt.print("Dinner Intermediate American ");
			
			this.gt.setXY(20,500);
			this.gt.addImageIcon("pizza recipes 2.jpg");
			this.gt.setFontSize(18);
			this.gt.setXY(230, 500);
			this.gt.print("Classic Peperoni Pizza");
			this.gt.setFontSize(15);	
			this.gt.setXY(230, 519);
			this.gt.print("Dinner Intermediate American");
			gt.setXY(0,0);
			gt.addImageIcon("background3.jpg");
			
		}
		
		public void GoHome() {
			
			this.gt= new GTerm (600,800);
			this.gt.setXY(160,10);
			this.gt.setFontSize(30);
			this.gt.print("Recipes");
			
			
			this.gt.setXY(20, 150);
			this.gt.setFontSize(15);
			this.gt.addTextField("", 200);
			this.gt.setXY(240, 150);
			this.gt.addButton("Search",  this,  "Search");
			this.gt.setXY(350, 150);
			this.gt.addButton("Pref.", this, "Preferences");
			
			//random shown recipes
			
			this.gt.setXY(20, 250);
			this.gt.addImageIcon("random recipes 1.png");
			this.gt.setFontSize(18);
			this.gt.setXY(230, 250);
			this.gt.print("Potato Asparagus & Mushroom Mash");
			this.gt.setFontSize(15);	
			this.gt.setXY(230, 269);
			this.gt.print("Breakfast Vegan healthy Easy");
			
			this.gt.setXY(20,500);
			this.gt.addImageIcon("random recipes 2.png");
			this.gt.setFontSize(18);
			this.gt.setXY(230, 500);
			this.gt.print("Savory Vegan Breakfast Bowl");
			this.gt.setFontSize(15);	
			this.gt.setXY(230, 519);
			this.gt.print("Breakfast Vegan healthy Easy");
			gt.setXY(0,0);
			gt.addImageIcon("background3.jpg");	
			
		}

	public static void main(String[] args) {
		Recipes proto1 = new Recipes();

		
	}
}
