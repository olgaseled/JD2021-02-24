package by.it.papruga.jd02_01;


public class Good {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
