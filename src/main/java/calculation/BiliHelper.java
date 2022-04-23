package calculation;

import data.bilirubin.BilirubinMap;
import data.patient.PatientDetails;
import data.risk.RiskInfo;
import data.risk.RiskZones;
import data.structs.RiskRange.Ranges;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;
import java.util.TreeMap;

public class BiliHelper {
    private static BiliHelper instance;
    private static TreeMap<Integer, RiskZones> bilirubinMap = BilirubinMap.getInstance().getBillirubinMap();
    private static double conversionConstant = 1710.395785; // this is molarity of bilirubin in micromols/g
    private static final RiskInfo riskInfo = RiskInfo.getInstance();

    public double getUmFromMG(double mgVal) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        double runningAnswer = mgVal * 10;
        runningAnswer = runningAnswer / 1000.0;
        runningAnswer = runningAnswer * conversionConstant;

        return (Double) (df.parse(df.format(runningAnswer)));
    }

    public double getMGFromUM(double umVal) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        double runningAnswer = umVal / 10;
        runningAnswer = runningAnswer / conversionConstant;
        runningAnswer = runningAnswer * 1000.0;

        return (Double) (df.parse(df.format(runningAnswer)));
    }


    public Ranges getRiskZone(PatientDetails pd) throws ParseException {
        double brLevel = pd.getTotalBillirubin();

        Integer key = pd.getAgeInHours();
        Map.Entry<Integer,RiskZones> low = bilirubinMap.floorEntry(key);
        Map.Entry<Integer,RiskZones> high = bilirubinMap.ceilingEntry(key);
        RiskZones currentRisk = null;
        if (low != null && high != null) {
            currentRisk = low.getValue();
        } else if (low != null || high != null) {
            currentRisk = low != null ? low.getValue() : high.getValue();
        }
        if(brLevel > currentRisk.getHigh()) {
            System.out.println(riskInfo.getHigh());
            return Ranges.HIGH;
        } else if (brLevel > currentRisk.getMed()) {
            System.out.println(riskInfo.getHighIntermediate());
            return Ranges.HIGHINTERMEDIATE;
        } else if (brLevel > currentRisk.getLow()) {
            System.out.println(riskInfo.getLowIntermediate());
            return Ranges.LOWINTERMEDIATE;
        } else {
            System.out.println(riskInfo.getLow());
            return Ranges.LOW;
        }

    }



    public static BiliHelper getInstance() {
        if(instance == null) {
            instance = new BiliHelper();
        }
        return instance;
    }
}
