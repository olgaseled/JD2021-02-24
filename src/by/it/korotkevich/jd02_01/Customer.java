package by.it.korotkevich.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Customer extends Thread implements ICustomer, IUseBasket {

    public Customer(int number) {
        super("Customer #" + number + " ");
    }


    @Override
    public void run() {
        enterMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterMarket() {
        System.out.println(this + "entered the store.");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "took a basket.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "is choosing goods.");
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "finished choosing goods.");
    }

    @Override
    public void putGoodsToBasket() {
        List<String> basketContent = new ArrayList<>();
        int numberOfGoods = Util.getRandom(1, 4);
        Set<String> goodsSet = Store.priceList.keySet();
        List<String> goodsList = new ArrayList<>(goodsSet);
        for (int i = 0; i < numberOfGoods; i++) {
            Util.sleep(Util.getRandom(500, 2000));
            int goodsSelection = Util.getRandom(1, goodsList.size());
            basketContent.add(goodsList.get(goodsSelection));
            System.out.println(this + "puts " + goodsList.get(goodsSelection).toLowerCase() + " inside his basket.");
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "leaves the store.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
