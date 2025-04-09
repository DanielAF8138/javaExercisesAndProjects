public class Cartester {
    public static void main(String[] args) {
        Car car1;
        Car car2;

        car1 = new Car("Ford", 1997);
        car2 = new Car("Toyota", 2014);

        car1.accelerate();

        System.out.println(car1.toString());
        System.out.println(car2.toString());
    }

}