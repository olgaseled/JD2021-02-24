package by.it.dudko.sandbox_oop;

public enum StoreTypes {
    BAKERY, GROCERY, BUTCHERY, VEGETABLE, SWEET, SUPERMARKET, JUSTSTORE;

    public String getPrettyName() {
        switch (this) {
            case BAKERY:
                return "bakery";
            case GROCERY:
                return "grocery";
            case BUTCHERY:
                return "butchery shop";
            case VEGETABLE:
                return "vegetable shop";
            case SWEET:
                return "sweet-shop";
            case SUPERMARKET:
                return "supermarket";
            default:
                return "store";
        }
    }
}
