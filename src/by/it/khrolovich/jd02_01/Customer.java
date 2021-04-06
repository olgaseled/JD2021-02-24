package by.it.khrolovich.jd02_01;

public class Customer extends Thread implements ICustomer {

    //int number;//номер покупателя

    public Customer(int numberCustomer){
       /* this.number = numberCustomer;
        this.setName("Покупатель №"+numberCustomer+" ");
        start();*/
        //или
        super("Customer №"+numberCustomer+" ");
    }
    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to the Store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"started to choose goods");
        int pause = Util.getRandom(500, 2000);//от 0.5 до 2х секунд
        Util.Sleep(pause);//выбираем товар от 0.5 до 2х секунд
        System.out.println(this+"finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this +"go out from the Store");
    }

    @Override
    public String toString() {

        //return super.toString();
        return this.getName();
    }
}
