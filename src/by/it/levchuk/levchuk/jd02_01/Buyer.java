package by.it.levchuk.levchuk.jd02_01;

/*crash-noobik
Liauchuk Aliaksandr*/

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {

        super("Покупатель №" + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Вошёл в магазин");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Взял корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "Выбирает товары");
        int timeout = Tools.getRandom(500, 2000);
        Tools.sleep(timeout);
        System.out.println(this + "Выбрал товары");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + "Положил товары в корзину");
    }

    @Override
    public void goOut() {

        System.out.println(this + "Покидает магазин");
    }

    @Override
    public String toString() {

        return this.getName();
    }
}
