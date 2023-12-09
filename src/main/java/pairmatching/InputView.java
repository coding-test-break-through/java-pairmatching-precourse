package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SELECTED_OPTION =
            "기능을 선택하세요.\n" +
                    "1. 페어 매칭\n" +
                    "2. 페어 조회\n" +
                    "3. 페어 초기화\n" +
                    "Q. 종료";
    private static final String SELECTED_COURSE =
            "과정, 레벨, 미션을 선택하세요.\n" +
                    "ex) 백엔드, 레벨1, 자동차경주";
    private static final String REMATCHING =
            "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                    "네 | 아니오";

    Validator validator = new Validator();

    String readSelectedOption() {
        System.out.println(SELECTED_OPTION);
        while (true) {
            try {
                String inputOption = Console.readLine();
                validator.checkSelectedOption(inputOption);
                return inputOption;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    CourseLevelMissionInput readCourseLevelMission() {
        System.out.println(SELECTED_COURSE);
        while (true) {
            try {
                String inputCourseLevelMission = Console.readLine();
                validator.checkCourseLevelMission(inputCourseLevelMission);
                String[] parsedInput = inputCourseLevelMission.split(", ");
                return new CourseLevelMissionInput(parsedInput[0], parsedInput[1], parsedInput[2]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    String readRematching() {
        System.out.println(REMATCHING);
        while (true) {
            try {
                String inputRematching = Console.readLine();
                validator.checkRematching(inputRematching);
                return inputRematching;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}