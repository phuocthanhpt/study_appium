package review_Java.Lab8;

import java.security.SecureRandom;

public abstract class Animal {

    protected int speed;

    public Animal(int maxSpeed) {
        this.speed = new SecureRandom().nextInt(maxSpeed);
    }

    protected int getSpeed(){
        return speed;
    }

    protected abstract String getAnimalName();

}
