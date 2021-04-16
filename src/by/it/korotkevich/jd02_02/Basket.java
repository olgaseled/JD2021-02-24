package by.it.korotkevich.jd02_02;

import java.util.ArrayList;

public class Basket {

    private final ArrayList<Good> basketContents;

    public Basket() {
        this.basketContents =  new ArrayList<>(4);
    }

    ArrayList<Good> putGoodsToBasket(Customer customerName, int goodsAmount) {
        for (int i = 0; i < goodsAmount; i++) {
            Util.sleep(Util.getRandom(500, 2000));
            Good oneGood = GoodsList.getAGood();
            basketContents.add(oneGood);
            System.out.println(customerName + "puts " + Good.toLowerCase(oneGood) + " inside his basket.");
        }
        return this.basketContents;
    }

    ArrayList<Good> getBasketContents() {
        return basketContents;
    }
}
