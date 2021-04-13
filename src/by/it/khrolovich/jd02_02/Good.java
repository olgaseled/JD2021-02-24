package by.it.khrolovich.jd02_02;

public class Good {
    private String name;
    //отдельным классом, если добавятся характеристики


    public Good(String name) {
        //this.name = name;
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
