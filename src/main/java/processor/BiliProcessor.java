package processor;

import calculation.BiliHelper;
import data.patient.PatientDetails;
import data.structs.BiliUnits;
import data.structs.RiskRange.Ranges;
import exceptions.InvalidTimeException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Main landing for when inputs come from user
 */
public class BiliProcessor {

    private static int age;
    private static double totalBil;
    private static final BiliHelper helper = new BiliHelper();

    /**
     * Calculates and returns the range that the patient is in (high, low, medium
     * @param ageHours - age at last data point taken by medical proffessional
     * @param tBil - total bilirubin concentration at given data  point
     * @param currentUnit - units the user input to represent bili concentration
     * @return
     * @throws ParseException
     * @throws InvalidTimeException
     */
    public static Ranges CalculateBili(Object ageHours, double tBil, BiliUnits.Units currentUnit) throws ParseException, InvalidTimeException {
        if(ageHours instanceof Integer) {
            age = (Integer) ageHours;
        } else if (ageHours instanceof Date){
            DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
            LocalDate localDate = LocalDate.now();
            System.out.println(dtf.format(localDate));

            age = 2; //do some calcs h ere to convert date
        } else {
            throw new InvalidTimeException("INVALID: Date format is of type " + ageHours.getClass().toString() +" only accepts int and Date");
        }

        totalBil = (currentUnit == BiliUnits.Units.MML) ? helper.getMGFromUM(tBil) : tBil;
        return generatePatientInfo();
    }

    /**
     * TODO add in the logic to take a Date object and calculate number of hours the patient is
     * instead of getting the hours
     * @return
     * @throws ParseException
     */
    /*public static Ranges CalculateBili(Date ageInDate, double tBil, BiliUnits.Units currentUnit) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate));

        int ageHours = 2; //do some calcs h ere to convert date
        age = ageHours;
        totalBil = (currentUnit == BiliUnits.Units.MML) ? helper.getMGFromUM(tBil) : tBil;
        return generatePatientInfo();
    }*/

    /**
     * Takes the input information and generates the patient info pojo
     * @return
     * @throws ParseException
     */
    private static Ranges generatePatientInfo() throws ParseException {
        PatientDetails pd = new PatientDetails(age, totalBil);
        return helper.getRiskZone(pd);
    }


}
