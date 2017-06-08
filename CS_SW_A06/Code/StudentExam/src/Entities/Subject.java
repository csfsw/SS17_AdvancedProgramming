package Entities;

public class Subject {
    private int subjectId;
    private String title;

    public Subject(int subjectId, String title) {
        this.subjectId = subjectId;
        this.title = title;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
