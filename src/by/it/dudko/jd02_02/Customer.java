package by.it.dudko.jd02_02;

import java.util.List;

public class Customer extends Thread implements ICustomer, IUseBasket {

    double slowRatio = 1.0;
    boolean pensioner = false;
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
        Store.customersInStore++;
    }

    @Override
    public List<Good> chooseGoods() {
        System.out.println(this + " started choosing goods");
        int goodsCount = CustomerUtil.getRandom(1, Config.MAX_GOODS_IN_BASKET);
        List<Good> goods = CustomerUtil.getRandomGoods(goodsCount);
        int actionTime = CustomerUtil.getRandom(500, (int)(2000 * slowRatio));

        CustomerUtil.sleep(pensioner ? (int)(actionTime * 1.5) : actionTime);
        System.out.println(this + " finished choosing goods");
        return goods;
    }

    @Override
    public void goOut() {
        System.out.println(this + " leaves the store");
        Store.customersInStore--;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        basket = new Basket();
        int actionTime = CustomerUtil.getRandom(500, (int)(2000 * slowRatio));
        CustomerUtil.sleep(actionTime);
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket(List<Good> goods) {
        int actionTime;
        for (Good good : goods) {
            actionTime = CustomerUtil.getRandom(500, (int)(2000 * slowRatio));
            CustomerUtil.sleep(actionTime);
            basket.putGood(good);
            System.out.printf("%s put %s to the basket\n", this, good);
        }
    }
}
