package cc.ku.ict.module3.statics;

class Car {
    private String name;

    // A static variable shared by all Car objects (counts active cars in race)
    private static int activeCars = 0;

    // A final constant (maximum number of cars allowed in race)
    // Unlike regular variables, exposing constants as `public` does **not break encapsulation**,
    // since they are read-only.
    public static final int MAX_CARS = 10;

    // Constructor → new car joins the race
    public Car(String name) {
        this.name = name;
        if (activeCars < MAX_CARS) {
            activeCars++;
            System.out.println(name + " joined the race. Active cars: " + activeCars);
        } else {
            System.out.println("Cannot add " + name + ". Maximum cars reached!");
        }
    }

    // Method for leaving the race
    public void leaveRace() {
        if (activeCars > 0) {
            activeCars--;
            System.out.println(name + " left the race. Active cars: " + activeCars);
        }
    }

    // Static method to check number of active cars
    public static int getActiveCars() {
        return activeCars;
    }
}