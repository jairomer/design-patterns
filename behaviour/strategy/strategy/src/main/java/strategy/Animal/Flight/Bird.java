package strategy.Animal.Flight;

public class Bird extends Animal {
    public void sing() {
        System.out.println("**Bird sings**");
    }

    public Bird() {
        super();
        flyingType = new ItFlys();
    }
}
