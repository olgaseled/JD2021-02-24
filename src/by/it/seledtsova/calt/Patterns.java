package by.it.seledtsova.calt;

public class Patterns {
    static final String OPERATION ="[-=+/*]"; //смотри ниже коментарии
    static final String SCALAR ="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR ="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static final String MATRIX ="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}"; // не учитываются отрицательные числа

}
    //создавали патерн в Regex Tester
    // создали патерн для скаляра с поиском знаков -+*/  (минут первый тк он еще может обозначать тире
   // [0-9]+\.?[0-9]* //патерн на числа [0-9]простое число от 0 до9, + оно встречается один или больше раз, \.? после
    //число может быть/не быть точка, [0-9]* после числа быть/не быть дробная часть от 0 до 9
    // вектор это число , после которого м.быть/не быть запятая ,? --> перед и после этой последовательностью стоит скобка ()+
// перед это пос-тью стоит скобка \{}
//матрица - это вектор м.быть/не быть , запятая --> и это повтор 1/более раз + --> перед/после стоит \{}