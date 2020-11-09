package visitor; 

import java.text.DecimalFormat;

// Concrete class of Visitor 
//  A different version of the algorithm is applied for different types of objects. 
class TaxVisitor implements Visitor {

    DecimalFormat df = new DecimalFormat("#.##");
    
    // This is created so that each item is sent to the right version of visit(). 
    public TaxVisitor() {}

    public double visit(Liquor liquorItem) {
        System.out.println("Liquor Item: Proce with Tax");
        return Double.parseDouble(df.format((liquorItem.getPrice() * .18) + liquorItem.getPrice()).replace(",", "."));
    }

    public double visit(Tobacco tobaccoItem) {
        System.out.println("Tobacco Item: Price with Tax");
        return Double.parseDouble(df.format((tobaccoItem.getPrice() * .32) + tobaccoItem.getPrice()).replace(",", "."));
    }
     
    public double visit(Necessity necessityItem) {
        System.out.println("Necessity Item: Price with Tax");
        return Double.parseDouble(df.format(necessityItem.getPrice()).replace(",", "."));
    }
    
} 