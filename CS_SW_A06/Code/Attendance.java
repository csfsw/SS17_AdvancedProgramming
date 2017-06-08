package Entities;

public class Attendance {
    private int totalDays;
    private int present;
    
    Attendance(int totalDays,int present){
        this.present=present;
        this.totalDays=totalDays;
    }
    public void setTotalDays(int totalDays){
        this.totalDays=totalDays;
    }
    public void setPresent(int present){
        this.present=present;
    }
    public int getTotalDays(){
        return totalDays;
    }
    public int getPresent(){
        return present;
    }
    
}
