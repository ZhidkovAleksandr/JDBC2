package task2_2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DaoFactoryDog implements IntDaoFactory {

    private static IntDaoFactory factory;

    private DaoFactoryDog() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IntDaoFactory getInstance() {
        if (factory == null) {
            factory = new DaoFactoryDog();
        }
        return factory;
    }

    @Override
    public DogDao getDogDao() {
        return new DogRequester();
    }
}
