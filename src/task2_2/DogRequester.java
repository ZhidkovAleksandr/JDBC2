package task2_2;

import task2_2.entitys.Dog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogRequester implements DogDao {


    @Override
    public void add(Dog nDog) {

        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement;

        try {
            statement = connection.prepareStatement("INSERT INTO DaoDog(name, weight, height, color) VALUES (?, ?, ?, ?)");
            statement.setString(1, nDog.getName());
            statement.setInt(2, nDog.getWeight());
            statement.setInt(3, nDog.getHeight());
            statement.setString(4, nDog.getColor());
            boolean isOk = statement.execute();
            if (isOk) System.out.println("row has added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Dog> getAll() {


        Connection connection = null;
        connection = getConnection();

        List<Dog> dogs = new ArrayList<>();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * FROM DaoDog");
            while (resultSet.next()) {

                Dog dog = createNewdog(resultSet);

                dogs.add(dog);

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

        return dogs;


    }

    @Override
    public Dog getById(int id) {

        Connection connection = null;
        connection = getConnection();

        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("Select * From DaoDog Where id = ?");
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return createNewdog(resultSet);
            } else{
                return null;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    @Override
    public void updateWeight(int weight, int id) {

        Connection connection = null;
        connection = getConnection();

        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("UPDATE DaoDog SET weight = ? WHERE id = ?");
            statement.setInt(1,weight);
            statement.setInt(2,id);
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

    @Override
    public void remove(int id) {
        Connection connection = null;
        connection = getConnection();

        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("DELETE FROM DaoDog WHERE id = ?");
            statement.setInt(1,id);
            Integer resp = statement.executeUpdate();
            if (resp instanceof Integer) System.out.println("deleted: "+ resp + " rows");

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ForDao", "root", "skull_pass");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Dog createNewdog(ResultSet resultSet) {
        try {
            return new Dog(resultSet.getString("name"), resultSet.getString("color"), resultSet.getInt("weight"), resultSet.getInt("height"), resultSet.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

}
