package data.bilirubin;

import data.risk.RiskZones;

import java.util.HashMap;
import java.util.TreeMap;

public class BilirubinMap {
    private static BilirubinMap instance;
    private TreeMap<Integer, RiskZones> map = new TreeMap();

    private BilirubinMap() {
        //mg/dl -> Risk zones H,M,L
        // > H High Risk Zone
        // > M High Intermediate Risk Zone
        // > L Low Intermediate Risk Zone
        // < L Low Risk Zone
        map.put(12, new RiskZones(7.0, 5.1, 4.0));
        map.put(14, new RiskZones(7.1, 5.2, 4.1));
        map.put(16, new RiskZones(7.3, 5.7, 4.5));
        map.put(18, new RiskZones(7.5, 5.8, 4.7));
        map.put(20, new RiskZones(7.7, 5.9, 4.8));
        map.put(22, new RiskZones(7.8, 6.0, 4.9));
        map.put(24, new RiskZones(7.9, 6.0, 5));
        map.put(26, new RiskZones(8.1, 6.4, 5.2));
        map.put(28, new RiskZones(8.9, 7.0, 5.8));
        map.put(30, new RiskZones(9.5, 7.7, 6.0));
        map.put(32, new RiskZones(10.0, 8.0, 6.2));
        map.put(34, new RiskZones(10.7, 8.65, 6.85));
        map.put(36, new RiskZones(11.0, 9.0, 7.0));
        map.put(38, new RiskZones(11.8, 9.5, 7.3));
        map.put(40, new RiskZones(12.1, 10.0, 7.9));
        map.put(42, new RiskZones(12.3, 10.1, 8.0));
        map.put(44, new RiskZones(12.6, 10.2, 8.1));
        map.put(46, new RiskZones(12.9, 10.5, 8.4 ));
        map.put(48, new RiskZones(13.1, 10.9, 8.7));
        map.put(50, new RiskZones(13.5, 11.1, 8.9));
        map.put(52, new RiskZones(13.95, 11.5, 9.0));
        map.put(54, new RiskZones(14.15, 11.9, 9.05));
        map.put(56, new RiskZones(14.5, 12.0, 9.2));
        map.put(58, new RiskZones(14.93, 12.3, 9.5));
        map.put(60, new RiskZones(15.1, 12.5, 9.7));
        map.put(62, new RiskZones(15.3, 12.8, 9.9));
        map.put(64, new RiskZones(15.4, 12.95, 10.1));
        map.put(66, new RiskZones(15.6, 13.0, 10.4));
        map.put(68, new RiskZones(15.75, 13.1, 10.8));
        map.put(70, new RiskZones(15.8, 13.2, 11.0));
        map.put(72, new RiskZones(15.9, 13.4, 11.1));
        map.put(74, new RiskZones(16.0, 13.6, 11.2));
        map.put(76, new RiskZones(16.2, 13.9, 11.25));
        map.put(78, new RiskZones(16.3, 14.0, 11.35));
        map.put(80, new RiskZones(16.4, 14.2, 11.4));
        map.put(82, new RiskZones(16.7, 14.5, 11.5));
        map.put(84, new RiskZones(16.8, 14.8, 11.7));
        map.put(86, new RiskZones(16.9, 14.9, 11.85));
        map.put(88, new RiskZones(17.0, 14.92, 11.9));
        map.put(90, new RiskZones(17.1, 14.95, 12.0));
        map.put(92, new RiskZones(17.2, 15.0, 12.1));
        map.put(94, new RiskZones(17.3, 15.1, 12.25));
        map.put(96, new RiskZones(17.5, 15.2, 12.4));
        map.put(98, new RiskZones(17.55, 15.25, 12.5));
        map.put(100, new RiskZones(17.6, 15.3, 12.6));
        map.put(102, new RiskZones(17.6, 15.35, 12.8));
        map.put(104, new RiskZones(17.65, 15.4, 12.85));
        map.put(106, new RiskZones(17.7, 15.5, 12.9));
        map.put(108, new RiskZones(17.7, 15.55, 12.95));
        map.put(110, new RiskZones(17.75, 15.6, 12.99));
        map.put(112, new RiskZones(17.75, 15.7, 13.0));
        map.put(114, new RiskZones(17.75, 15.8, 13.1));
        map.put(116, new RiskZones(17.8, 15.85, 13.2));
        map.put(118, new RiskZones(17.8, 15.9, 13.25));
        map.put(120, new RiskZones(17.8, 15.95, 13.3));
        map.put(122, new RiskZones(17.75, 15.9, 13.2));
        map.put(124, new RiskZones(17.7, 15.8, 13.2));
        map.put(126, new RiskZones(17.6, 15.7, 13.2));
        map.put(128, new RiskZones(17.55, 15.6, 13.2));
        map.put(130, new RiskZones(17.55, 15.55, 13.2));
        map.put(132, new RiskZones(17.5, 15.5, 13.15));
        map.put(134, new RiskZones(17.45, 15.45, 13.15));
        map.put(136, new RiskZones(17.4, 15.4, 13.15));
        map.put(138, new RiskZones(17.3, 15.3, 13.1));
        map.put(140, new RiskZones(17.25, 15.25, 13.1));
        map.put(142, new RiskZones(17.2, 15.2, 13.1));
        map.put(144, new RiskZones(17.2, 15.2, 13.1));
        map.put(146, new RiskZones(17.4, 15.2, 13.15));



    }

    public static BilirubinMap getInstance() {
        if(instance == null) {
            instance = new BilirubinMap();
        }
        return instance;
    }


    public TreeMap<Integer, RiskZones> getBillirubinMap() {
        return map;
    }
}
