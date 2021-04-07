package by.it.kirichenko.jd02_02;

import java.util.LinkedList;
import java.util.List;

public class Basket {
    private int numberBuyer;
    private List<String> listProductBuyer;

    Basket(int numberBuyer){
        this.numberBuyer = numberBuyer;
        listProductBuyer = new LinkedList<>();
    }

    void addProductInBasket(String nameProduct){
        listProductBuyer.add(nameProduct);
    }

    public String getBasket(){
        return listProductBuyer.toString();
    }
}
