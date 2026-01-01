package factoryPattern;

import commons.CarList;

public class EndUser {

    public static CarFactory carFactory;

    public static void main(String[] args) {
        carFactory = getCar("HONDA");
        carFactory.bookCar();
        carFactory.driveCar();
        carFactory.viewCar();
    }

    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList) {
            case HONDA:
                carFactory = new HondaHead();
                break;
            case HUYNDAI:
                carFactory = new HuyndaiHead();
                break;
            case FORD:
                carFactory = new FordHead();
                break;
        }
        return carFactory;

    }
}
