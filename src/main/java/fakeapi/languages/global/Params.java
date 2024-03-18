package fakeapi.languages.global;

import java.util.Collections;
import java.util.List;

/**
 * @author Pancho1402
 */

public class Params {
    private Params(){}
    public static <T> List<T> getLimitList(Integer min, Integer max, List<T> list) {
        if(list.size() >= max && min <= max) {
            return list.subList(min-1, max);
        }
        return Collections.emptyList();
    }
}
