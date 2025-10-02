package cc.ku.ict.module3.statics;

public class CarRaceMain {
    public static void main(String[] args) {

        System.out.println("Currently active (there is no object yet): " + Car.getActiveCars());

        Car c1 = new Car("Car A");
        Car c2 = new Car("Car B");
        Car c3 = new Car("Car C");

        System.out.println("Currently active (get using class): " + Car.getActiveCars());

        // static methods can also be called by objects
        System.out.println("Currently active (get using object): " + c1.getActiveCars());

        c2.leaveRace();

        System.out.println("Currently active: " + Car.getActiveCars());
    }
}