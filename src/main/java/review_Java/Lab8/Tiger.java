package review_Java.Lab8;

import java.security.SecureRandom;

public class Tiger extends Animal {
    int speed;

    public Tiger(int maxSpeed) {
        this.speed = new SecureRandom().nextInt(maxSpeed);
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "Tiger{" +
                "speed=" + speed +
                '}';
    }

    @Override
    protected int speed() {
        return speed;
    }
}
