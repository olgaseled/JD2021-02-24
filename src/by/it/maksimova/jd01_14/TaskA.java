package by.it.maksimova.jd01_14;

import java.io.*;

public class TaskA {

    private static  String dir (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".", File.separator);
        return path+clDir;
    }

    public static void main(String[] args) {
    try(DataOutputStream output=new DataOutputStream(new BufferedOutputStream(
            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")))){
        for (int i = 0; i < 20; i++) {
            output.write((int)(Math.random()*25));
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    try(DataInputStream input=new DataInputStream(new BufferedInputStream(
            new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
        PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))){
    double sum=0;
    double count = 0;
    while (input.available()>0){
        int i= input.readInt();
        System.out.print(i+" ");
        out2.print(i+" ");
        sum+=i;
        count++;
    }
        System.out.println("\navg="+sum/count);
    out2.print("\navg="+sum/count);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
