package review_Java.Lab7_1;

import java.util.ArrayList;
import java.util.List;

public class AnimalWithBuilderTest {

    public static void main(String[] args){
        AnimalWithBuilder.Builder builder = new AnimalWithBuilder.Builder();
        AnimalWithBuilder tiger = builder.setName("Tiger").getMaxSpeed(100).withWings(false).build();
        AnimalWithBuilder horse = builder.setName("Horse").getMaxSpeed(75).withWings(false).build();
        AnimalWithBuilder dog = builder.setName("Dog").getMaxSpeed(60).withWings(false).build();
        AnimalWithBuilder blackBird = builder.setName("Black Bird").getMaxSpeed(150).withWings(true).build();
        AnimalWithBuilder dragon = builder.setName("Dragon").getMaxSpeed(500).withWings(true).build();

        List<AnimalWithBuilder> animalList = new ArrayList<>();
        animalList.add(tiger);
        animalList.add(horse);
        animalList.add(dog);
        animalList.add(blackBird);
        animalList.add(dragon);

        // Racing
        int bestSpeed = 0;
        String winner = "";
        System.out.println("Animals without wings racing...");
        for(AnimalWithBuilder animal: animalList){
            if(!animal.getWings()){
                int speed = animal.getSpeed();
                String name = animal.getName();
                System.out.printf("%s - speed %d%n", name, speed);
                if(speed >= bestSpeed){
                    bestSpeed = speed;
                    winner = name;
                }
            }
        }

        System.out.printf("Winner is %s - with speed %d%n", winner, bestSpeed);
    }


}
