package by.it.kirichenko.calc;


class ThreadLogger extends Thread  {
    ThreadLogger(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger logger = Logger.INSTANCE;
        logger.log(this.getName());
    }
}
