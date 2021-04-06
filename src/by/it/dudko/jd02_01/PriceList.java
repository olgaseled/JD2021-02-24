package by.it.dudko.jd02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;

public class PriceList<T1, T2> {

    Map<T1, T2> priceTable;

    public PriceList(Map<T1, T2> priceTable) {
        Iterator<Map.Entry<T1, T2>> iterator = priceTable.entrySet().iterator();
        //noinspection WhileLoopReplaceableByForEach
        while (iterator.hasNext()) {
            Map.Entry<T1, T2> product = iterator.next();
            this.priceTable.put(product.getKey(), product.getValue());
        }
    }

    public PriceList(String priceListLines) {
        try (
                BufferedReader reader = new BufferedReader(
                        new StringReader(priceListLines)
                )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productInfo = line.split("\\s*:\\s*");
                //noinspection unchecked
                priceTable.put((T1) productInfo[0],
                        (T2) productInfo[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public T2 getCostByName(T1 product) {
        return priceTable.get(product);
    }
}
