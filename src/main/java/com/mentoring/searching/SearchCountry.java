package com.mentoring.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchCountry {
    public static void main(String[] args) {
        List<IpCountry> ipCountries = new ArrayList<>();

        ipCountries.add(new IpCountry(0, 10, "VN"));
        ipCountries.add(new IpCountry(11, 20, "US"));
        ipCountries.add(new IpCountry(21, 30, "CN"));

        int ans = Collections.binarySearch(ipCountries, new IpCountry(12, 14, "??"), new Comparator<IpCountry>() {
            @Override
            public int compare(IpCountry o1, IpCountry o2) {
                return Integer.compare(o1.from, o2.from);
            }
        });

        System.out.println(ans);
    }
}
