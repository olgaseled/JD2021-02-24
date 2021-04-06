package by.it.khrolovich.jd02_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Customer extends Thread implements ICustomer, IUseBasket{

    //int number;//номер покупателя

    public Customer(int numberCustomer){
       /* this.number = numberCustomer;
        this.setName("Покупатель №"+numberCustomer+" ");
        start();*/
        //или
        super("Customer №"+numberCustomer+" ");
    }
    @Override
    public void run() {
        enterToMarket();
        takeBasket();//покупатель взял корзину
        int countOfGoods = Util.getRandom(1, 4);
        for (int i = 0; i < countOfGoods; i++) {
            chooseGoods();//выбрал товар
            putGoodsToBasket();//положил в корзину
           }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to the Store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"started to choose good");
        int pause = Util.getRandom(500, 2000);//от 0.5 до 2х секунд

        Util.Sleep(pause);//выбираем товар от 0.5 до 2х секунд
        System.out.println(this+"finished to choose good");
    }

    @Override
    public void goOut() {
        System.out.println(this +"go out from the Store");
    }

    @Override
    public String toString() {

        //return super.toString();
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this+"take the basket");
    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(this+"put to basket: ");
    }
}
