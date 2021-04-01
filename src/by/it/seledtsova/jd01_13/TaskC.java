package by.it.seledtsova.jd01_13;
/*
Нужно написать в TaskC программу, которая будет вводитьвещественные числас консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в обратном порядке.
Используйте Scanner, ноон должен создаваться только один рази обязательнов методе main.
Код по чтениючиселс клавиатуры должен быть в методеstatic void readData().
Если пользователь ввёлкакой-то текст, вместо вводачисла, то метод readData() долженперехватить исключение, сделать паузу Thread.sleep(100)и вывести на экран все ранеевведенные числа.
Числа нужно выводить без форматирования,через пробел, в порядке обратном вводу.
После 5 допущенных ошибок программа должна завершиться, пробрасываяошибку в JVM.
 */

import java.util.Scanner;

public class TaskC {
    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }

    private static void readData() {
    }
}

/*
try{
    Threead.sleep(100);
        } catch (InterruptedException e){
e.printStackTrace();}
}
 */
