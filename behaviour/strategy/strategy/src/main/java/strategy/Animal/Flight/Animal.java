package strategy.Animal.Flight;

public class Animal {

    /* Composition:
    *   - No side effects.
    *   - Can be modified during runtime.
    * */
    public Flys flyingType;

    public void tryToFly() {
        System.out.println(flyingType.fly());
    }

    public void setFlyingType(Flys newFlyType) {
        flyingType = newFlyType;
    }
}
