package review_Java.Lab8;

public class Horse extends Animal {

    public Horse(int maxSpeed) {
        super(maxSpeed);
        System.out.println(this);
    }

    @Override
    protected String getAnimalName() {
        return "Horse";
    }

    @Override
    public String toString() {
        return getAnimalName() + "{" +
                "speed=" + speed +
                '}';
    }
}
