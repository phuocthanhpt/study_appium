package review_Java.Lab6;

import java.security.SecureRandom;

public class RacingAnimal {
    int maxRacingSpeed;
    String name;

    public RacingAnimal(int maxRacingSpeed, String name) {
        this.maxRacingSpeed = maxRacingSpeed;
        this.name = name;
    }

    public int speed() {
        int randomSpeed = new SecureRandom().nextInt(this.maxRacingSpeed);
        System.out.printf("%s is created with speed <%d>%n", this.name, randomSpeed);
        return randomSpeed;
    }

}
