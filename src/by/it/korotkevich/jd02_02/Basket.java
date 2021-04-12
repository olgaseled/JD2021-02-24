package by.it.korotkevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Basket {


    static void putGoodsToBasket(Customer customerName, int goodsAmount) {
        List<Good> basketContents = new ArrayList<>();
        for (int i = 0; i < goodsAmount; i++) {
            Util.sleep(Util.getRandom(500, 2000));
            Good oneGood = GoodsList.getAGood();
            basketContents.add(oneGood);
            System.out.println(customerName + "puts " + Good.toLowerCase(oneGood) + " inside his basket.");
        }
    }
}
