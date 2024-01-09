package task2_2;

import task2_2.entitys.Dog;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Dog nDog =  new Dog("Karl", "white", 25, 45, 1);

        IntDaoFactory factory = DaoFactoryDog.getInstance();

        DogDao dogDao = factory.getDogDao();

        dogDao.add(nDog);

        Dog rDog = dogDao.getById(2);
        System.out.println(rDog);

        dogDao.updateWeight(30, 1);
        dogDao.add(new Dog("Rex", "black", 35, 55, 2));

        List<Dog> dogs = dogDao.getAll();

        for (Dog d:dogs) {
            System.out.println(d);
        }

        dogDao.remove(1);

    }
}
