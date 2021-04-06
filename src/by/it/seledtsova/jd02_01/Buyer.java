package by.it.seledtsova.jd02_01;

/*
Напишите программу, моделирующую поток покупателей Buyerв магазине.
Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
 */

public class Buyer extends Thread implements IBuyer, Runnable {

    int buyerNumber; // номер покупателя

    public Buyer (int BuyerNumber) { // создали покупателя и присвоили ему номер
    this.setName("The buyer number №"+buyerNumber+" ");
    start(); // поток начал работу. Покупатель начал покупать
    }

    public void run(){   // выделили наш поток. Покупатель пришел в зал магазина,выбирает и покупает товар
        enterToMarket();
        chooseGoods();
        goOut();
    }

// Реализовали методы класса предка enterToMarket(), chooseGoods(), goOut()
    @Override
    public void enterToMarket() {
        System.out.println(this+"The buyer has entered to the supermarket");

    }
    @Override
    public void chooseGoods() {
        System.out.println(this+"The buyer star to choose products");

    }


    @Override
    public void goOut() {
        System.out.println(this+"The buyer has left the supermarket");
    }


    @Override
    public String toString() {
        return this.getName();
    }

}
