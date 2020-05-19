package com.kotor.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<List<String>> readContentOfFile(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\t");
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < values.length; i++) {
                    if (!values[i].equals(" ")) {
                        tempList.add(values[i]);
                    }
                }
                records.add(tempList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void writeContentToFile(String fileName, List<List<String>> content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for(int i = 0 ; i < content.size(); i++) {
                for(int j = 0; j < content.get(0).size(); j++) {
                    bw.append(content.get(i).get(j));
                    bw.append('\t');
                }
                bw.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
