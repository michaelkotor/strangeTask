package com.kotor;

import com.kotor.sort.SortService;
import com.kotor.util.FileUtil;

import java.util.List;

public class Instruction {
    private final SortService sortService = new SortService();

    public void execute() {
        List<List<String>> records = FileUtil.readContentOfFile("in.txt");

        sortService.printContent(records);

        List<List<String>> toBeSorted = sortService.revertContent(records);

        sortService.sort(toBeSorted);

        List<List<String>> result = sortService.revertContent(toBeSorted);

        sortService.printContent(result);

        FileUtil.writeContentToFile("out.txt", result);
    }
}
