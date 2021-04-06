//package by.it.savchenko.jd02_01;
//
//import java.util.*;
//
//public class Basket {
//    Map<String, Good> products = new HashMap<String, Good>();
//
//    public boolean add(Good product) {
//        if (product.isEmpty())
//            return false;
//        if (products.containsKey(product.getName())) {
//            Good old = products.get(product.getName());
//            old.setAmount(old.getAmount() + product.getAmount());
//            products.replace(product.getName(), old);
//        } else
//            products.put(product.getName(), product);
//        return true;
//    }
//
//    public boolean remove(Good product) {
//        if (product.isEmpty())
//            return false;
//        if (products.containsKey(product.getName())) {
//            Good old = products.get(product.getName());
//            int diff = old.getAmount() - product.getAmount();
//            old.setAmount((diff >= 0) ? diff : 0);
//            if (old.getAmount() != 0)
//                products.replace(product.getName(), old);
//            else
//                products.remove(product.getName());
//            return true;
//        } else
//            return false;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("\n");
//        int i = 1;
//        for (Map.Entry<String, Good> entry : products.entrySet()) {
//            Good value = entry.getValue();
//            sb.append(i).append(". ")
//                    .append(value.getName())
//                    .append(", количество: ")
//                    .append(value.getAmount())
//                    .append("\n");
//            i++;
//        }
//        return sb.toString();
//    }
//
//}
