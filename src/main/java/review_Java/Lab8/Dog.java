package review_Java.Lab8;

import java.security.SecureRandom;

public class Dog extends Animal {
    int speed;

    public Dog(int maxSpeed){
        this.speed = new SecureRandom().nextInt(maxSpeed);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "speed=" + speed +
                '}';
    }

    @Override
    protected int speed() {
        return speed;
    }
}
