package by.it.kirichenko.jd02_01;

public interface BuyerActions {

    void storeEntrace();    //вошел в магазин (мгновенно)

    void productSelection();      //выбрал товар (от 0,5 до 2 секунд)

    void exitingStore();            //отправился на выход(мгновенно)

}
