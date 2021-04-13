package by.it.zmushko.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
    
    public Buyer(int name) {
        super("Name " + name);
    }

    @Override
    public void run() {
        enterToShop();
        takeBasket();
        chooseItems();
        goOutFromShop();
    }

    @Override
    public void enterToShop() {
        System.out.println(this.getName() + " Enter in shop ");
    }

    @Override
    public void chooseItems() {
        System.out.println(this.getName() + " Start choose ");
        putGoodsToBasket();
        System.out.println(this.getName() + " End choose ");
    }

    @Override
    public void goOutFromShop() {
        System.out.println(this.getName() + " Out of the shop");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        for (int countGoods = 0; countGoods < Support.getRandom(1, 4); countGoods++) {
            System.out.println(this.getName() + " put in basket " + Support.getRandomGoods());
            Support.sleep(Support.getRandom(500, 2000));
        }
    }
}
