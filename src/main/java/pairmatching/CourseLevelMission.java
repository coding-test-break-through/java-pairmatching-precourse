package pairmatching;

import java.util.*;

public class CourseLevelMission {
    private static final Map<Level, Set<String>> commonMissions = new HashMap<>();

    static {
        // 공통 레벨 및 미션 설정
        commonMissions.put(Level.LEVEL1, new HashSet<>(Arrays.asList("자동차경주", "로또", "숫자야구게임")));
        commonMissions.put(Level.LEVEL2, new HashSet<>(Arrays.asList("장바구니", "결제", "지하철노선도")));
        commonMissions.put(Level.LEVEL4, new HashSet<>(Arrays.asList("성능개선", "배포")));
    }

    public static boolean isValidInput(Course course, Level level, String mission) {
        if (course == Course.BACKEND || course == Course.FRONTEND) {
            if (commonMissions.containsKey(level)) {
                Set<String> availableMissions = commonMissions.get(level);
                return availableMissions.contains(mission);
            }
        }
        return false;
    }


}