package by.it.zmushko.jd02_01;

public class BuyerPensioner extends Buyer {

    public BuyerPensioner(int name) {
        super(name);
    }

    @Override
    public void enterToShop() {
        System.out.println("Pensioner " + this.getName() + " Enter in shop ");
    }

    @Override
    public void goOutFromShop() {
        System.out.println("Pensioner " + this.getName() + " Out of the shop");
    }

    @Override
    public void takeBasket() {
        System.out.println("Pensioner " + this.getName() + " take a basket");
    }

    @Override
    public void putGoodsToBasket() {
        for (int countGoods = 0; countGoods < Support.getRandom(1, 4); countGoods++) {
            System.out.println(this.getName() + " put in basket " + Support.getRandomGoods());
            Support.sleep(Support.getRandom((500 * Constants.PENSIONER_WALK_SPEED), (2000 * Constants.PENSIONER_WALK_SPEED)));
        }
    }
}
