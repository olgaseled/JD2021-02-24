package by.it.dudko.jd01_08oop;

public class Extramural extends Student {
    // int age;
    // String name;
    String jobInfo = "";

    public Extramural(String fullName, int age) {
        super(fullName, age);
        // this.age = age;
        // this.name = fullName;
    }

    @Override
    public void writeAdditionalInfo(String info) {
        this.jobInfo = prettifyInfo(info);
    }

    private String prettifyInfo(String info) {
        return info.replaceAll("\\s{2,}", " ");
    }

}
