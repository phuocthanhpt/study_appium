package review_Java.Lab6;

import java.security.SecureRandom;

public class RacingAnimal {
    int speed;

    public RacingAnimal(int maxRacingSpeed) {
        this.speed = new SecureRandom().nextInt(maxRacingSpeed);
    }

    public int getSpeed() {
        return speed;
    }
}
