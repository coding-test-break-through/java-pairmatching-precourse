package pairmatching.domain.crew;

import java.util.List;
import pairmatching.domain.course.Course;
import pairmatching.domain.textReader.TextReader;

public class Crews {

    private final List<String> crewNames;
    private final Course course;

    private Crews(List<String> crewNames, Course course) {
        this.crewNames = crewNames;
        this.course = course;
    }

    public static Crews from(Course course) {
        return new Crews(getCrewNames(course), course);
    }

    private static List<String> getCrewNames(Course course) {
        String resourcePath = "";
        if (course.equals(Course.BACKEND)) {
            resourcePath = "backend-crew.md";
        }
        if (course.equals(Course.FRONTEND)) {
            resourcePath = "frontend-crew.md";
        }

        return new TextReader().readText(resourcePath);
    }

    public List<String> getShuffleCrews() {
        return new RandomCrewShuffler().shuffleList(crewNames);
    }

}
