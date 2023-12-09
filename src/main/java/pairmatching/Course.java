package pairmatching;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public static Course getCourseByName(String name) {
        for (Course course : Course.values()) {
            if (course.getName().equals(name)) {
                return course;
            }
        }
        return null;
    }
}
