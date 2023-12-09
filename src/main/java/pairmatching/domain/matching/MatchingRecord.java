package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.matching.dto.MatchingCrews;
import pairmatching.domain.mission.Mission;

public class MatchingRecord {

    private final Level level;
    private final Mission mission;
    private final Course course;
    private List<MatchingCrews> crewMatchingResult;
    // List가 아닌 다른 방법 고려 필요 (crew 안겹쳐야 함)

    public MatchingRecord(Level level, Mission mission, Course course, List<String> crewShuffleResult) {
        this.level = level;
        this.mission = mission;
        this.course = course;
        this.crewMatchingResult = matchingCrews(crewShuffleResult);
    }

    private List<MatchingCrews> matchingCrews(List<String> crewShuffleResult) {
        crewMatchingResult = new ArrayList<>();
        for (int i = 0; i < crewShuffleResult.size(); i += 2) {
            int endIndex = Math.min(i + 2, crewShuffleResult.size());
            List<String> matchedCrews = new ArrayList<>(crewShuffleResult.subList(i, endIndex));

            if (endIndex - i == 1) {
                matchedCrews.add(crewShuffleResult.get(endIndex));
            }

            crewMatchingResult.add(new MatchingCrews(matchedCrews));
        }
        return crewMatchingResult;
    }

    public List<MatchingCrews> getCrewMatchingResult() {
        return Collections.unmodifiableList(crewMatchingResult);
    }

    public void setCrewMatchingResult(MatchingRecord matchingRecord) {
        crewMatchingResult = matchingRecord.getCrewMatchingResult();
    }

    public boolean isEqualsMatchingRecordWithAll(Level newLevel, Mission newMission, Course newCourse) {
        return level.equals(newLevel) && mission.equals(newMission) && course.equals(newCourse);
    }

    public boolean isEqualsMatchingRecordWithLevel(Level newLevel, Course newCourse) {
        return level.equals(newLevel) && course.equals(newCourse);
    }

    public boolean isExistInRecordsFromNewCrewMatching(MatchingRecord matchingRecord) {
        return matchingRecord.crewMatchingResult.stream()
                .anyMatch(matchingCrews -> isExistCrewMatching(matchingCrews.matchedCrews()));
    }

    private boolean isExistCrewMatching(List<String> matchedCrews) {
        return crewMatchingResult.stream()
                .anyMatch(crews -> crews.matchedCrews().containsAll(matchedCrews));
    }
}
