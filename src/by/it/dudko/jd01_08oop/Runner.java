package by.it.dudko.jd01_08oop;

public class Runner {
    public static void main(String[] args) {
        Student stud1 = new Extramural("Сон Хын Мин", 28);
        Student stud2 = new Extramural("Сац Иван Ильич", 34);
        stud2.writeAdditionalInfo("ОАО Мотовело, слесарь-сборщик 3 разряда");

        stud1.printStudentInfo();
        stud2.printStudentInfo();
    }
}
