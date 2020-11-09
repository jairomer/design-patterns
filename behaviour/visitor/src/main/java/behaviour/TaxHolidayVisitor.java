package visitor;

import java.text.DecimalFormat;

class TaxHolidayVisitor implements Visitor {

    DecimalFormat df = new DecimalFormat("#.##");
    
    // This is created so that each item is sent to the right version of visit(). 
    public TaxHolidayVisitor() {}

    public double visit(Liquor liquorItem) {
        System.out.println("Liquor Item: Proce with Tax");
        return Double.parseDouble(df.format((liquorItem.getPrice() * .10) + liquorItem.getPrice()).replace(",", "."));
    }

    public double visit(Tobacco tobaccoItem) {
        System.out.println("Tobacco Item: Price with Tax");
        return Double.parseDouble(df.format((tobaccoItem.getPrice() * .30) + tobaccoItem.getPrice()).replace(",", "."));
    }
     
    public double visit(Necessity necessityItem) {
        System.out.println("Necessity Item: Price with Tax");
        return Double.parseDouble(df.format(necessityItem.getPrice()).replace(",", "."));
    }
}