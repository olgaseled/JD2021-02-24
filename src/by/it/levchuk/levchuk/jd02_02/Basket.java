package by.it.levchuk.levchuk.jd02_02;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Good> basketContents;

    public Basket() {
        this.basketContents =  new ArrayList<>(4);
    }

    ArrayList<Good> putGoodsToBasket(Buyer customerName, int goodsAmount) {
        for (int i = 0; i < goodsAmount; i++) {
            Tools.sleep(Tools.getRandom(500, 2000));
            Good oneGood = PriceList.getAGood();
            basketContents.add(oneGood);
            System.out.println(customerName + "положил " + Good.toLowerCase(oneGood) + " к себе в корзину");
        }
        return this.basketContents;
    }
    ArrayList<Good> getBasketContents() {
        return basketContents;
    }
}
