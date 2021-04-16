package by.it.kaminskii.new_project_jd_02;/* created by Kaminskii Ivan
 */

import by.it.kaminskii.jd02_02.Helper;

import java.util.LinkedList;
import java.util.List;

public class TestBasket {
    List<String> basket(){
        for (String s : TestPrice.priseList().keySet()) {
            basket().add(s);
        }
        return basket();
    }
}
