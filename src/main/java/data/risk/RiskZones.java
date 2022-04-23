package data.risk;

/**
 * POJO contianing the risk zones object used in the risk map
 */
public class RiskZones {
    public double high;
    public double med;
    public double low;

    public RiskZones(double h, double m, double l){
        setHigh(h);
        setMed(m);
        setLow(l);
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getHigh() {
        return high;
    }

    public void setMed(double med) {
        this.med = med;
    }

    public double getMed() {
        return med;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getLow() {
        return low;
    }
}
