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

    /**
     * conversion
     * mg = milligrams
     * dl = deci liter
     * moles = molarity
     * L = liter
     *
     * so to get mg/dl from moles/L
     *
     * where ex: user passes in 15.03 mg/dl to get moles/L
     * 15.03 mg/dl * 10 = 150.3 mg/L //converts dl -> L
     * 150.3 mg/L /1000 = 0.1503 //converts milligrams -> grams
     * 0.1503 g/L * 1710.395785 um/g = 257.07// converts g/L -> um/L where 1710.395785 is molarity of bilirubin in um/g
     * = 257.07 um/L // Do the opposite for the function getMGfromUM
     */
    /**
     * converts the concentration from micro moles/L to mg/dl
     * @param mgVal patient current concentration
     * @return converted concentration
     * @throws ParseException
     */
    public double getUmFromMG(double mgVal) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        double runningAnswer = mgVal * 10;
        runningAnswer = runningAnswer / 1000.0;
        runningAnswer = runningAnswer * conversionConstant;

        return (Double) (df.parse(df.format(runningAnswer)));
    }

    /**
     * converts the concentration from micro to mg/dl moles/L
     * @param umVal patient current concentration
     * @return converted concentration
     * @throws ParseException
     */
    public double getMGFromUM(double umVal) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        double runningAnswer = umVal / 10;
        runningAnswer = runningAnswer / conversionConstant;
        runningAnswer = runningAnswer * 1000.0;

        return (Double) (df.parse(df.format(runningAnswer)));
    }


    /**
     * Returns the risk zone that the patient is in
     * @param pd - POJO containing patient details given by user
     * @return - The range that the patient is in
     * @throws ParseException
     */
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

    /**
     * Returns the instance of this class. This class is an instance so it doens't need to be recreated each time
     * @return
     */
    public static BiliHelper getInstance() {
        if(instance == null) {
            instance = new BiliHelper();
        }
        return instance;
    }
}
