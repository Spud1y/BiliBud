package conversion

import calculation.BiliHelper
import spock.lang.Specification

class ConverstionTest extends Specification {
    BiliHelper bp = BiliHelper.getInstance()

    def "validate MGDL to UMMOLL"() {
        expect:
        bp.getMGFromUM(umoll) == result

        where:
        umoll | result
        257.0 | 15.03
        150.86| 8.82
        79.0  | 4.62
    }

    def "validate UMMOLL to MGDL"() {
          expect:
        bp.getUmFromMG(mgdl) == result

        where:
        mgdl | result
        15.03 | 257.07
        8.82  | 150.86
        4.62  | 79.02

    }

}
