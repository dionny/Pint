package com.pint.BusinessLogic.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Dionny on 11/20/2015.
 */
public class Utils {
    public static <T> Collection<T> iterableToCollection(Iterable<T> iterable) {
        Collection<T> collection = new ArrayList<>();
        iterable.forEach(collection::add);
        return collection;
    }

    public static List<Long> toLongs(List<Integer> ints) {
        int nInts = ints.size();
        List<Long> longs = new ArrayList<Long>(nInts);
        for (int i=0;i<nInts;++i) {
            longs.add(ints.get(i).longValue());
        }
        return longs;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
