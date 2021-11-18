package review_Java.Lab6;

public class RacingAnimalTest {

    public static void main(String[] args) {
        RacingAnimal horse = new RacingAnimal(75, "Horse");
        RacingAnimal tiger = new RacingAnimal(100, "Tiger");
        RacingAnimal dog = new RacingAnimal(60, "Dog");

        int horseSpeed = horse.speed();
        int tigerSpeed = tiger.speed();
        int dogSpeed = dog.speed();

        if (horseSpeed > tigerSpeed && horseSpeed > dogSpeed) {
            System.out.printf("*** Racing winner is Horse, with speed: %d", horseSpeed);
        }
        if (tigerSpeed > dogSpeed && tigerSpeed > horseSpeed) {
            System.out.printf("*** Racing winner is Tiger, with speed: %d", tigerSpeed);
        }
        if (dogSpeed > tigerSpeed && dogSpeed > horseSpeed) {
            System.out.printf("*** Racing winner is Dog, with speed: %d", dogSpeed);
        }
    }
}
