package task2_1.entity;

public class Car {

    private long id;
    private String model;
    private int modelYear;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}
