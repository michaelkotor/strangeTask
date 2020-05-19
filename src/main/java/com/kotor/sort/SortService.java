package com.kotor.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortService {
    public List<List<String>> revertContent(List<List<String>> toPosses) {
        List<List<String>> toBeSorted = new ArrayList<>();

        for(int i = 0; i < toPosses.get(0).size(); i++) {
            List<String> temp = new ArrayList<>();

            for (int j = 0; j < toPosses.size(); j++) {
                temp.add(toPosses.get(j).get(i));
            }

            toBeSorted.add(temp);
        }
        return toBeSorted;
    }

    public void printContent(List<List<String>> toPrint) {
        for(int i = 0; i < toPrint.size(); i++) {
            for (int j = 0; j < toPrint.get(i).size(); j++) {
                System.out.print(toPrint.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    public void sort(List<List<String>> toSort) {
        for(int i = 0; i < toSort.size(); i++) {
            Collections.sort(toSort.get(i));
        }
    }
}
