package data.risk;

/**
 * POJO containing the test that will be used in the UI for what the risk is for the patient
 */
public class RiskInfo {
    String Low;
    String LowIntermediate;
    String HighIntermediate;
    String High;
    private static RiskInfo instance;

    public RiskInfo(){
        setLow("Low Risk Zone");
        setHigh("High Risk Zone");
        setLowIntermediate("Low Intermediate Risk Zone");
        setHighIntermediate("High Intermediate Risk Zone");
    }

    public void setLow(String low) {
        Low = low;
    }

    public void setLowIntermediate(String lowIntermediate) {
        LowIntermediate = lowIntermediate;
    }

    public void setHighIntermediate(String highIntermediate) {
        HighIntermediate = highIntermediate;
    }

    public void setHigh(String high) {
        High = high;
    }

    public String getHigh() {
        return High;
    }

    public String getHighIntermediate() {
        return HighIntermediate;
    }

    public String getLowIntermediate() {
        return LowIntermediate;
    }

    public String getLow() {
        return Low;
    }

    public static RiskInfo getInstance() {
        if(instance == null) {
            instance = new RiskInfo();
        }
        return instance;
    }
}
