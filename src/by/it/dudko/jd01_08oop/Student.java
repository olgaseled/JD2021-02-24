package by.it.dudko.jd01_08oop;

abstract class Student implements Learner {

    private final int age;
    private final String personalNumber;
    private final String fullName;

    public Student(String name, int age) {
        this.fullName = name;
        this.age = age;
        personalNumber = String.valueOf(Math.abs(name.hashCode()));
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void writeAdditionalInfo(String info) {
    }

    ;

    public void printStudentInfo() {
        System.out.printf("ФИО: %-30s\nВозраст: %2d\nНомер: %s\n",
                this.getFullName(),
                this.getAge(),
                this.getPersonalNumber()
        );
        System.out.println("===================================");
    }
}
