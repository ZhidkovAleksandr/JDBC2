package task2_2;

import task2_2.entitys.Dog;

import java.util.List;

public interface DogDao {

    void add(Dog nDog);
    List<Dog> getAll();

   Dog getById(int id);

    void updateWeight(int weight, int id);

    void remove(int id);

}
