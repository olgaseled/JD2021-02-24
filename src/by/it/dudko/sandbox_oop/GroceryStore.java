package by.it.dudko.sandbox_oop;

import java.util.Locale;
import java.util.Map;

public class GroceryStore extends Store<String, Double> {

    public GroceryStore(String name) {
        super(name, StoreTypes.GROCERY);
    }

    @Override
    public void assignGoods(Map<String, Double> goods) throws StoreException {
        super.assignGoods(goods);
    }

    @Override
    public void addProduct(String productName, Double productValue) {
        super.addProduct(productName, productValue);
    }

    @Override
    public void printGoods() {
        if (super.salesCutOff > 0) {
            System.out.printf("\n>>> Today's discount is %d%% <<<\n", salesCutOff);
        }
        System.out.printf("%-18s| %6s\n", "Product", "Price");
        for (Map.Entry<String, Double> product : super.goods.entrySet()) {
            double normalPrice = product.getValue();
            double discountPrice = normalPrice - normalPrice * salesCutOff / 100;
            System.out.printf(Locale.ENGLISH,
                    "%-18s| %6.2f\n", product.getKey(), discountPrice);
        }
    }
}
