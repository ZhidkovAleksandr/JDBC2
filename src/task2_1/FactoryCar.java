package task2_1;

import task2_2.DaoFactoryDog;
import task2_2.IntDaoFactory;

public class FactoryCar implements InCarF {

    private static InCarF factory;

    private FactoryCar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized InCarF getInstance() {
        if (factory == null) {
            factory = new FactoryCar();
        }
        return factory;
    }

    @Override
    public CarDao getCarDAO() {
        return new CarJdbc();
    }
}
