package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatching {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Map<CourseLevelMissionInput, List<List<String>>> operationResults = new HashMap<>();

    void play() {
        String selectedOption;
        do {
            selectedOption = inputView.readSelectedOption();
            doOption(selectedOption);
        } while (!selectedOption.equals("Q"));
    }

    void doOption(String selectedOption) {
        if (selectedOption.equals("1")) {
            outputView.showList();
            doMatching();
            return;
        }
        if (selectedOption.equals("2")) {
            outputView.showList();
            seeMatching();
            return;
        }
        if (selectedOption.equals("3")) {
            initializeMatching();
            return;
        }
    }

    void doMatching() {
        while (true) {
            CourseLevelMissionInput input = inputView.readCourseLevelMission();
            List<List<String>> results = operationResults.getOrDefault(input, new ArrayList<>());
            if (results.isEmpty()) {
                operationResults.put(input, performOperation(input));
                outputView.showMatching(operationResults.get(input));
                break;
            }
            String inputRematching = inputView.readRematching();
            if (inputRematching.equals("네")) {
                operationResults.put(input, performOperation(input));
                outputView.showMatching(operationResults.get(input));
                break;
            }
        }
    }

    void seeMatching() {
        CourseLevelMissionInput input = inputView.readCourseLevelMission();
        List<List<String>> result = operationResults.getOrDefault(input, new ArrayList<>());
        if (result.isEmpty()) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            return;
        }
        outputView.showMatching(result);
    }

    void initializeMatching() {
        operationResults = new HashMap<>();
    }

    List<List<String>> performOperation(CourseLevelMissionInput input) {
        if(input.getCourse().equals("백엔드")){
            return performOperationBackend();
        }
        return performOperationFrontend();
    }

    List<List<String>> performOperationBackend() {
        List<String> input = readFile("src/main/resources/backend-crew.md");
        List<List<String>> grouped = new ArrayList<>();
        List<String> currentGroup = new ArrayList<>();
        int i;
        for (i = 0; i < input.size() - 2; i++) {
            currentGroup.add(input.get(i));
            if (currentGroup.size() == 2) {
                grouped.add(currentGroup);
                currentGroup = new ArrayList<>();
            }
        }
        currentGroup.add(input.get(i));
        i++;
        currentGroup.add(input.get(i));
        grouped.add(currentGroup);
        return grouped;
    }

    List<List<String>> performOperationFrontend() {
        List<String> input = readFile("src/main/resources/frontend-crew.md");
        List<List<String>> grouped = new ArrayList<>();
        List<String> currentGroup = new ArrayList<>();
        int i;
        for (i = 0; i < input.size() - 2; i++) {
            currentGroup.add(input.get(i));
            if (currentGroup.size() == 2) {
                grouped.add(currentGroup);
                currentGroup = new ArrayList<>();
            }
        }
        currentGroup.add(input.get(i));
        i++;
        currentGroup.add(input.get(i));
        grouped.add(currentGroup);
        return grouped;
    }

    List<String> readFile(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String> input = new ArrayList<>();
        String str;
        while (true) {
            try {
                if ((str = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            input.add(str);
        }
        return Randoms.shuffle(input);
    }
}
