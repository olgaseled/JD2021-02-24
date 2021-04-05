package by.it.kirichenko.jd02_01;

class Store {
    private static Store ourInstance = new Store();

    public static Store getInstance() {
        return ourInstance;
    }

    private Store() {
    }
}
