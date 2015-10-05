/**
 Copyright 2015 Raghav Vamaraju

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.vamaraju.vamaraju_reflex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by RV on 10/2/2015.
 */
public class StatsHelper {

    public StatsHelper() {

    }

    public static Double min(List<Long> list) {
        if (list.size() == 0) {return null;}

        Long min = list.get(0);
        for (int i=1; i<list.size(); i++) {
            Long current = list.get(i);
            if (current < min) {min = current;}
        }
        return min.doubleValue();
    }

    public static Double max(List<Long> list) {
        if (list.size() == 0) {return null;}

        Long max = list.get(0);
        for (int i=1; i<list.size(); i++) {
            Long current = list.get(i);
            if (current > max) {max = current;}
        }
        return max.doubleValue();
    }

    public static Double mean(List<Long> list) {
        if (list.size() == 0) {return null;}

        Long sum = 0L;
        for (Long l : list) {
            sum += l;
        }
        Double mean = sum.doubleValue()/list.size();
        return mean;
    }

    public static Double median(List<Long> list) {
        if (list.size() == 0) {return null;}

        // Create a copy of the List as an ArrayList to avoid modifying it. Sort the copy.
        List<Long> sortedList = new ArrayList<Long>(list);
        Collections.sort(sortedList);

        int numItems = sortedList.size();
        int middleIndex = numItems / 2;
        Double med = null;

        // If the number of items in the list is odd, then the median is the middle item.
        // Otherwise, the median is the average of the two middle items.
        if (numItems % 2 == 1) {
            med = sortedList.get(middleIndex).doubleValue();
        }
        else if (numItems % 2 == 0) {
            Double num1 = sortedList.get(middleIndex-1).doubleValue();
            Double num2 = sortedList.get(middleIndex).doubleValue();
            med = (num1+num2)/2;
        }

        return med;
    }

    public static ArrayList<Long> slice(List<Long> list, int start, int end) {
        int size = end - start;
        ArrayList<Long> slice = new ArrayList<Long>(size);

        for (int i=start; i<end; i++) {
            slice.add(list.get(i));
        }

        return slice;
    }



}
