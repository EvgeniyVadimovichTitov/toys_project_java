package modelRepository;

public class Toy {

    private int id;
    private String name;
    private  int count = 1;
    private int frequency;

    public Toy(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }
    public Toy(int id, String name, int count, int frequency) {
        this(name, frequency);
        this.id = id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("%d - %s(amount - %d, frequency - %d)", id, name, count, frequency);
    }
}
