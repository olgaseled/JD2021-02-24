package by.it.zmushko.jd02_02;

class Manager {

    private volatile static int countPeopleInShop = 0;
    private volatile static int countPeopleOutShop = 0;

    static synchronized void peopleCome() {
        countPeopleInShop++;
    }

    static void counterPeople(){
        synchronized (Manager.class){
            countPeopleOutShop++;
        }
    }

    static boolean storeOpen() {
        return countPeopleInShop != Constants.MAX_LIMIT_PEOPLE_IN_STORE;
    }

    static boolean storeClose() {
        return countPeopleOutShop == Constants.MAX_LIMIT_PEOPLE_IN_STORE;
    }


}
