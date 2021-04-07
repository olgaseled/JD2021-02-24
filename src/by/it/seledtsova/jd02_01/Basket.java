package by.it.seledtsova.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket extends Thread implements IUseBasket {



    @Override
    public void takeBasket() {
        System.out.println(this + "The buyer takes the basket");
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);

    }

    @Override
    public void putProductToTheBasket() {
        List<Integer> basketProduct=new ArrayList<>();
        int howMuchProducts=Util.getRandom(1,4);
        int pause = Util.getRandom(500, 2000); //
        Util.sleep(pause);
        for (int product = 0; product < basketProduct.size(); product++) {
            basketProduct.add(howMuchProducts);
        }
        System.out.println(this + "The buyer put"+howMuchProducts+"product to the basket");
    }

    @Override
    public String toString() {
        return "Basket{}";
    }
}
