package by.it.belazarovich.jd02_01;

public interface ICustomer {

    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goOut();            //отправился на выход(мгновенно)

}
