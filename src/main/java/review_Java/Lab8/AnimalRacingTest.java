package review_Java.Lab8;

public class AnimalRacingTest {
    public static void main(String[] args) {
        Animal horse = new Horse(75);
        Animal tiger = new Tiger(100);
        Animal dog = new Dog(60);

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
