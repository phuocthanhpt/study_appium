package review_Java.Lab7_1;

import java.security.SecureRandom;

public class AnimalWithBuilder {
    private String name;
    private int speed;
    private boolean hasWings;

    private AnimalWithBuilder(){}

    private AnimalWithBuilder(Builder builder){
        name = builder.name;
        speed = builder.speed;
        hasWings = builder.hasWings;
    }

    public String getName(){
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getWings(){
        return hasWings;
    }

    public static class Builder{
        private String name;
        private int speed;
        private boolean hasWings;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder getMaxSpeed(int maxSpeed){
            this.speed = new SecureRandom().nextInt(maxSpeed);
            return this;
        }

        public Builder withWings(boolean hasWings){
            this.hasWings = hasWings;
            return this;
        }

        public AnimalWithBuilder build() {
            return new AnimalWithBuilder(this);
        }
    }
}
