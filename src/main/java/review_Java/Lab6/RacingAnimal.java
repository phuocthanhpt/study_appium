package review_Java.Lab6;

import java.security.SecureRandom;

public class RacingAnimal {
    private int maxRacingSpeed;
    private String name;

    public int getMaxRacingSpeed() {
        return maxRacingSpeed;
    }

    public void setMaxRacingSpeed(int maxRacingSpeed) {
        this.maxRacingSpeed = maxRacingSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public RacingAnimal(int maxRacingSpeed, String name) {
//        this.maxRacingSpeed = maxRacingSpeed;
//        this.name = name;
//    }
//
//    public int speed() {
//        int randomSpeed = new SecureRandom().nextInt(this.maxRacingSpeed);
//        System.out.printf("%s is created with speed <%d>%n", this.name, randomSpeed);
//        return randomSpeed;
//    }

}
