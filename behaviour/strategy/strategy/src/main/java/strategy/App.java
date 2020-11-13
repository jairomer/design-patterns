package strategy;

import strategy.Animal.Flight.Bird;
import strategy.Animal.Flight.Dog;
import strategy.Animal.Flight.ItFlys;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dog dog      = new Dog();
        Bird bird    = new Bird();

        dog.tryToFly();
        bird.tryToFly();

        dog.setFlyingType(new ItFlys());
        dog.tryToFly();
    }
}
