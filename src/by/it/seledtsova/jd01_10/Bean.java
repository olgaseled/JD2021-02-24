package by.it.seledtsova.jd01_10;

//TaskA2.Создайте класс Bean которыйсодержитдвастатическихи дванестатическихметода.Имена sum max min avg с сигнатурой
// (int a, int b), какие именно из них статические выберите произвольно.Методы должны вычислять для своих параметров
// a и b сумму, максимум, минимум и среднее и возвращать результат какdouble.Трииз этих методов должны быть помечены
// ранее созданной аннотациейс разными значениями a и b

 class Bean {

     @Param(a=2, b=5)
     static double sum (int a,int b) {
         return a+b;
     }
     @Param(a=2, b=5)
     static double avg (int a,int b) {
         return (a+b)/2.0;
     }
     @Param(a=2, b=5)
     double min (int a,int b) {
         return a<b? a:b; // если оказалось а<b, то мы возвращаем а, иначе b
     }

     double max (int a,int b) { //если оказалось а>b,то мы возвращаем b, иначе a
         return a>b? a:b;
     }
}
