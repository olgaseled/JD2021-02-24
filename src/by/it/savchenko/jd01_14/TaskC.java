package by.it.savchenko.jd01_14;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {

        File dir = new File("C:\\Users\\yamax\\ideaProjects\\JD2021-02-24-v1\\src");
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
            System.out.println(lst);
        }
    }

}