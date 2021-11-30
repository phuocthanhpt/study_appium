package review_Java.Lab8;

public class Dog extends Animal {

    public Dog(int maxSpeed) {
        super(maxSpeed);
        System.out.println(this);
    }

    @Override
    protected String getAnimalName() {
        return "Dog";
    }

    @Override
    public String toString() {
        return getAnimalName() + "{" +
                "speed=" + speed +
                '}';
    }
}
