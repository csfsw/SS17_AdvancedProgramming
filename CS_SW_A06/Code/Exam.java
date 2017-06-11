package Entities;

import java.util.Date;

public class Exam {
    private Date start;
    private Date end;
    private Date subjectDate;
    private byte examType;
    
    Exam(Date start,Date end,Date subjectDate, byte examType){
        this.end=end;
        this.examType=examType;
        this.start=start;
        this.subjectDate=subjectDate;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getSubjectDate() {
        return subjectDate;
    }

    public void setSubjectDate(Date subjectDate) {
        this.subjectDate = subjectDate;
    }

    public byte getExamType() {
        return examType;
    }

    public void setExamType(byte examType) {
        this.examType = examType;
    }
    
}
