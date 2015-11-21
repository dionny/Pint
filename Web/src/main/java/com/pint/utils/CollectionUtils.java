package com.pint.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dionny on 11/20/2015.
 */
public class CollectionUtils {
    public static <T> Collection<T> iterableToCollection(Iterable<T> iterable) {
        Collection<T> collection = new ArrayList<>();
        iterable.forEach(collection::add);
        return collection;
    }
}
