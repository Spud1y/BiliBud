package data.patient;

import java.util.Date;

public class PatientDetails {
    public PatientDetails(int age, double totalBillirubin) {
        setAgeInHours(age);
        setTotalBillirubin(totalBillirubin);
    }
    public boolean calculateTime;

    //Option where you can input birth/blood sample time
    public Date birthTime;
    public Date recentBloodSampleTime;


    //Put in the age of the child
    public int ageInHours;

    //Common varibales
    public double totalBillirubin;
    public boolean useMgUnits;


    public void setCalculateTime(boolean calculateTime) {
        this.calculateTime = calculateTime;
    }

    public boolean isCalculateTime() {
        return calculateTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setRecentBloodSampleTime(Date recentBloodSampleTime) {
        this.recentBloodSampleTime = recentBloodSampleTime;
    }

    public Date getRecentBloodSampleTime() {
        return recentBloodSampleTime;
    }

    public void setAgeInHours(int ageInHours) {
        this.ageInHours = ageInHours;
    }

    public int getAgeInHours() {
        return ageInHours;
    }

    public void setTotalBillirubin(double totalBillirubin) {
        this.totalBillirubin = totalBillirubin;
    }

    public double getTotalBillirubin() {
        return totalBillirubin;
    }

    public void setUseMgUnits(boolean useMgUnits) {
        this.useMgUnits = useMgUnits;
    }

    public boolean isUseMgUnits() {
        return useMgUnits;
    }
}
