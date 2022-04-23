package calculation;

import data.bilirubin.BilirubinMap;
import data.risk.RiskZones;

public class BiliCalculator {
    public void biliTest() {
        BilirubinMap br = BilirubinMap.getInstance();
        RiskZones rz = (RiskZones) br.getBillirubinMap().get(12);
        System.out.println("low value = " + rz.getLow());
    }
}
