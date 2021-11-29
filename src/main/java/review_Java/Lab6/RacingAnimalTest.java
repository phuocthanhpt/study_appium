package review_Java.Lab6;

public class RacingAnimalTest {

    public static void main(String[] args) {
        Horse horse = new Horse(75);
        Tiger tiger = new Tiger(100);
        Dog dog = new Dog(60);

        int horseSpeed = horse.getSpeed();
        int tigerSpeed = tiger.getSpeed();
        int dogSpeed = dog.getSpeed();

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
