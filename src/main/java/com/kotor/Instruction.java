package com.kotor;

import com.kotor.sort.SortService;
import com.kotor.util.FileUtil;

import java.util.List;

public class Instruction {
    private SortService sortService = new SortService();
    private FileUtil fileUtil = new FileUtil();

    public void execute() {
        List<List<String>> records = fileUtil.readContentOfFile("in.txt");

        sortService.printContent(records);

        List<List<String>> toBeSorted = sortService.revertContent(records);

        sortService.sort(toBeSorted);

        List<List<String>> result = sortService.revertContent(toBeSorted);

        sortService.printContent(result);

        fileUtil.writeContentToFile("out.txt", result);
    }
}
