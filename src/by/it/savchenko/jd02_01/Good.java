//package by.it.savchenko.jd02_01;
//
//public class Good {
//    private String name;
//    private int amount;
//
//    public Good(String name, int amount) {
//        this.name = name;
//        this.amount = amount;
//    }
//
//    public Good() {
//        this("", 0);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String newName) {
//        name = newName;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int newAmount) {
//        amount = newAmount;
//    }
//
//    public boolean isEmpty() {
//        return name.isBlank() || amount == 0;
//    }
//
//    public String toString() {
//        return "[name=" + name + ", amount=" + amount + "]";
//    }
//
//    public boolean equals(Object otherObject) {
//        if (this == otherObject)
//            return true;
//        if (otherObject == null)
//            return false;
//        if (getClass() != otherObject.getClass())
//            return false;
//        Good other = (Good) otherObject;
//        return this.name.equals(other.getName()) && this.amount == other.getAmount();
//    }
//
//    public int hashCode() {
//        return 22 * name.hashCode() + 11 * (amount + 3);
//    }
//
//}
//
