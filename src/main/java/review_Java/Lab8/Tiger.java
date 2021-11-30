package review_Java.Lab8;

public class Tiger extends Animal {

    public Tiger(int maxSpeed) {
        super(maxSpeed);
        System.out.println(this);
    }

    @Override
    protected String getAnimalName() {
        return "Tiger";
    }

    @Override
    public String toString() {
        return getAnimalName() + "{" +
                "speed=" + speed +
                '}';
    }
}
