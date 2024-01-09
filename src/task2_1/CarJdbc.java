package task2_1;

import task2_1.entity.Car;
import task2_2.entitys.Dog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarJdbc implements CarDao{

    @Override
    public List<Car> getAll() {

        Connection connection = null;
        Statement statement = null;
        connection = getConnection();

        List<Car> cars = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * FROM cars");
            while (resultSet.next()) {

                Car car = createNewCar(resultSet);
                cars.add(car);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }


        }

        return cars;




    }

    @Override
    public Car getById(int id)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Car car = null;

        connection = getConnection();

        try{
            preparedStatement = connection.prepareStatement("Select * From cars Where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return createNewCar(resultSet);
            }else{
                return null;
            }


        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateYear(int year, int carId) {

        Connection connection = null;
        connection = getConnection();

        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("UPDATE cars SET modelYear = ? WHERE id = ?");
            statement.setInt(1,year);
            statement.setInt(2,carId);
            Integer resp = statement.executeUpdate();
            if (resp instanceof Integer) System.out.println("updated: "+ resp + " rows");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "skull_pass");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Car createNewCar(ResultSet resultSet) {
        Car car = null;
        try {
            car = new Car();
            car.setId(resultSet.getInt("id"));
            car.setModel(resultSet.getString("model"));
            car.setModelYear(resultSet.getInt("modelYear"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return car;
    }
}
