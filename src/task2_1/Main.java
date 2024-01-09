package task2_1;

import task2_1.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InCarF f = FactoryCar.getInstance();

        CarDao carJdbc = f.getCarDAO();

        List<Car> cars = carJdbc.getAll();

        for (Car car:cars) {
            System.out.println(car);
        }

        Car car = carJdbc.getById(1);

        System.out.println(car);

        carJdbc.updateYear(2024, 1);




    }

}
