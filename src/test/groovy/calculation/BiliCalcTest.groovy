package calculation

import data.structs.RiskRange.Ranges
import exceptions.InvalidTimeException
import processor.BiliProcessor
import spock.lang.Specification
import data.structs.BiliUnits.Units

class BiliCalcTest extends Specification {
    def "test limits"() {
        expect:
        BiliProcessor.CalculateBili(age, bil, currentUnit) == result

        where:
        age | bil | currentUnit| result
        20  | 87.0| Units.MML  | Ranges.LOWINTERMEDIATE
        73  | 15.8| Units.MGDL | Ranges.HIGHINTERMEDIATE
        42  | 12.9| Units.MGDL | Ranges.HIGH
        108 | 10.0| Units.MGDL | Ranges.LOW
        53  | 14.0| Units.MGDL | Ranges.HIGH //This is a rounding test will round down on age if inbetween for safety
        62  | 6.8 | Units.MGDL | Ranges.LOW


    }

    def "test bad value"() {
        given:
            double age = 2.0
            double bil = 2.0
            Units currentUnit = Units.MGDL

        when:
            BiliProcessor.CalculateBili(age, bil, currentUnit)

        then:
            thrown InvalidTimeException

    }
}
