package by.it.seledtsova.jd01_13;
/*
Нужно написать в TaskC программу, которая будет вводитьвещественные числас консоли, после каждой ошибки
 программа делает паузу в 100 мс и выводит накопленные числа в обратном порядке.
+Используйте Scanner, ноон должен создаваться только один рази обязательнов методе main.
+Код по чтениючиселс клавиатуры должен быть в методеstatic void readData().
Если пользователь ввёлкакой-то текст, вместо вводачисла, то метод readData() долженперехватить исключение,
 сделать паузу Thread.sleep(100)и вывести на экран все ранеевведенные числа.
Числа нужно выводить без форматирования,через пробел, в порядке обратном вводу.
После 5 допущенных ошибок программа должна завершиться, пробрасываяошибку в JVM.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    static Scanner scanner;


    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }

    private static void readData() throws Exception {
        List<Double> arrayList = new ArrayList<>();
        int mistakes = 0; // создали переменную, которая будет считать ошибки
// 1 2 3 4 5 e a r d 5 6 4 7 e

        while (true) {
            try {
                String number = scanner.nextLine(); // читает строку
                arrayList.add(Double.valueOf(number)); // добавляем в лист и переводим в число
            } catch (Exception e) {
                mistakes++; //  ошибки суммируются
                Thread.sleep(100); // пауза
                for (int i = arrayList.size(); i > 0; i--) {
                    System.out.print(arrayList.get(i - 1) + " ");
                }
                System.out.println(mistakes);
                if (mistakes >= 5) {
                    throw new Exception();
                }
            }
        }
    }
}






        /*
            if (sum < 0) {
                throw new ArithmeticException("Сумма меньше нуля. Найти квадратный корень нельзя"); // бросаемся ошибкой
            }
                break;
            }
        scanner.hasNext(String.valueOf(arrayList));
        int number=scanner.nextInt();
        if ();

        sleep(100);
    }
}

/*
try{
    Threead.sleep(100);
        } catch (InterruptedException e){
e.printStackTrace();}
}
 */
