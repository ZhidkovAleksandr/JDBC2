package task2_1;

import task2_1.entity.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAll();

    Car getById(int id);

    void updateYear(int year, int carId);

}
