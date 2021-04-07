package by.it.kirichenko.jd02_01;

class Buyer extends Thread implements BuyerActions, BuyerActionsWithBasket {

    private int numberBuyer;
    Basket basket;

    public Buyer(int numberBuyer) {
        super("Buyer number " + numberBuyer + " ");
        this.numberBuyer = numberBuyer;
    }

    @Override
    public void run() {
        storeEntrace();
        takeBasket();
        productSelection();
        viewBasket();
        exitingStore();
    }

    private void viewBasket() {
        System.out.println(this + " take products: "+basket.getBasket());
    }

    @Override
    public void storeEntrace() {
        System.out.println(this + " entered the store.");
    }

    @Override
    public void productSelection() {
        System.out.println(this + " started choosing products.");

        int countProducts = Util.getRandom(1,4);

        for (int i = 0; i < countProducts; i++) {
            putProductInBasket();
        }

        System.out.println(this + " finished choosing products.");
    }

    @Override
    public void exitingStore() {
        System.out.println(this + " left the store.");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        basket = new Basket(numberBuyer);
        System.out.println(this + " take basket.");
    }

    @Override
    public void putProductInBasket() {
        String nameProduct = StoreWindow.getRandomProduct();
        basket.addProductInBasket(nameProduct);
        int timeout = Util.getRandom(500, 2000);
        Util.sleep(timeout);

    }
}
