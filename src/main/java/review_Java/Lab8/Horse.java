package review_Java.Lab8;

import java.security.SecureRandom;

public class Horse extends Animal {
    int speed;

    public Horse(int maxSpeed) {
        this.speed = new SecureRandom().nextInt(maxSpeed);
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                '}';
    }

    @Override
    protected int speed() {
        return speed;
    }
}
