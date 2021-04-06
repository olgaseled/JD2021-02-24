package by.it.papruga.jd02_01;

import java.util.*;


public class Customer extends Thread implements ICustomer, IUseBasket {

    public Customer(int number) {

        super("Customer #" + number + " ");

    }

    List<String> basket = new ArrayList<>();

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + "goes to the market");

    }

    @Override
    public void chooseGoods() {

        System.out.println(this + "started choose goods");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);


        List<String> goods = new ArrayList<>(Arrays.asList("apple", "milk", "bread", "fish"));

        int goodsCount = Util.getRandom(4);

        for (int i = 0; i < goodsCount; i++) {

            basket.add(goods.get(i));

        }

        if (goodsCount > 0) {
            System.out.println(this + "choose " + basket.toString()
                    .replace("[", "")
                    .replace("]", ""));
            putGoodsToBasket();
        }
        System.out.println(this + "finished choose goods");
    }

    @Override
    public void goOut() {

        System.out.println(this + "leaves this store");

    }

    @Override
    public void takeBasket() {

        System.out.println(this + "take basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);




    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(this + "put goods to basket");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);


    }

    @Override
    public String toString() {
        return this.getName();
    }
}
