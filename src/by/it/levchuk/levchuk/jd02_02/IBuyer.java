package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

public interface IBuyer {

        void enterToMarket();    //вошел в магазин (мгновенно)

        void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

        void goOut();     //отправился на выход(мгновенно)

}
