package by.it.dudko.sandbox_oop;

import java.util.HashMap;
import java.util.Map;


public abstract class Store<T1, T2> implements IStore {

    Currency currency = null;
    Map<T1, T2> goods = new HashMap<>();
    String name;
    StoreTypes type;
    int salesCutOff;

    public Store(String name) {
        this(name, StoreTypes.JUSTSTORE);
    }

    public Store(String name, StoreTypes type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void open() {
        System.out.printf("%s \"%s\" has opened",
                type.getPrettyName(), name);
    }

    @Override
    public void close() {
        System.out.printf("%s \"%s\" has closed",
                type.getPrettyName(), name);
    }

    @Override
    public void sales(double cutOffPercent) {
        salesCutOff = (int) Math.abs(cutOffPercent);
    }

    @Override
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void printGoods() {
    }

    private boolean isCurrencySet() {
        return currency != null;
    }

    public void assignGoods(Map<T1, T2> goods) throws StoreException {
        if (!isCurrencySet()) {
            throw new StoreException("Set currency before adding products");
        }
        for (Map.Entry<T1, T2> product : goods.entrySet()) {
            this.goods.put(product.getKey(), product.getValue());
        }
        System.out.println("Goods have placed to shelves");
    }

    public void addProduct(T1 productName, T2 productValue) {
        goods.put(productName, productValue);
    }




}
