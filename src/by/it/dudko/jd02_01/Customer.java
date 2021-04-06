package by.it.dudko.jd02_01;

import java.util.List;

public class Customer extends Thread implements ICustomer, IUseBasket {

    Basket basket;

    public Customer(int number) {
        super(String.format("Customer #%d", number));
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        List<Good> goods = chooseGoods();
        putGoodsToBasket(goods);
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enters the store");
    }

    @Override
    public List<Good> chooseGoods() {
        System.out.println(this + " started choosing goods");
        List<Good> goods = CustomerUtil.getRandomGoods(Config.MAX_GOODS_IN_BASKET);
        int actionTime = CustomerUtil.getRandom(500, 2000);
        CustomerUtil.sleep(actionTime);
        System.out.println(this + " finished choosing goods");
        return goods;
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the store");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        int actionTime = CustomerUtil.getRandom(500, 2000);
        basket = new Basket();
        CustomerUtil.sleep(actionTime);
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket(List<Good> goods) {
        int actionTime;
        for (Good good : goods) {
            actionTime = CustomerUtil.getRandom(500, 2000);
            CustomerUtil.sleep(actionTime);
            basket.putGood(good);
            System.out.printf("%s put %s to the basket\n", this, good);
        }
    }
}
