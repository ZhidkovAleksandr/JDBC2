package task2_2.entitys;

public class Dog {

    private String name;
    private String color;
    private int weight;
    private int height;
    private int id;

    public Dog(String name, String color, int weight, int height, int id) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.height = height;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", id=" + id +
                '}';
    }
}
