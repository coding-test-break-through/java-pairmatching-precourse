package pairmatching;

import java.util.Arrays;
import java.util.List;

public class Validator {
    List<String> validMenuOptions = Arrays.asList("1", "2", "3", "Q");
    List<String> validRematchingOptions = Arrays.asList("네", "아니오");

    void checkSelectedOption(String inputSelectedOption) {
        if(!validMenuOptions.contains(inputSelectedOption)){
            throw new IllegalArgumentException("[ERROR] " + validMenuOptions + " 중의 하나를 입력해주세요.");
        }
    }

    void checkCourseLevelMission(String inputCourse) {
        String[] parsedCourse = inputCourse.split(", ");
        checkLength(parsedCourse);
        Course course = checkCourse(parsedCourse[0]);
        Level level = checkLevel(parsedCourse[1]);
        String mission = parsedCourse[2];
        checkMission(course, level, mission);
    }

    void checkLength(String[] parsedCourse) {
        if(parsedCourse.length != 3) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }
    }

    Course checkCourse(String courseName) {
        Course course = Course.getCourseByName(courseName);
        if(course == null) {
            throw new IllegalArgumentException("[ERROR] 잘못된 과정입니다.");
        }
        return course;
    }

    Level checkLevel(String levelName) {
        Level level = Level.getLevelByName(levelName);
        if(level == null) {
            throw new IllegalArgumentException("[ERROR] 잘못된 레벨입니다.");
        }
        return level;
    }

    void checkMission(Course course, Level level, String mission) {
        if(!CourseLevelMission.isValidInput(course, level, mission)){
            throw new IllegalArgumentException("[ERROR] 잘못된 미션입니다.");
        }
    }

    void checkRematching(String inputRematching){
        if(!validRematchingOptions.contains(inputRematching)){
            throw new IllegalArgumentException("[ERROR] " + validRematchingOptions + " 중의 하나를 입력해주세요.");
        }
    }
}
