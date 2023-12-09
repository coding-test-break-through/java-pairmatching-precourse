package pairmatching;

import java.util.Objects;

public class CourseLevelMissionInput {
    private final String course;
    private final String level;
    private final String mission;

    public CourseLevelMissionInput(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CourseLevelMissionInput that = (CourseLevelMissionInput) obj;
        return Objects.equals(course, that.course) &&
                Objects.equals(level, that.level) &&
                Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

}
