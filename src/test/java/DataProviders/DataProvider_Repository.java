package DataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProvider_Repository {

    @DataProvider(name = "BothData")
    public static Object[][] BothCaseData(Method mtd) {

        Object detail[][] = null;


        if (mtd.getName().equalsIgnoreCase("movieSearch")) {

            detail = new Object[2][2];
            detail[0][0] = "Fantasy Island";
            detail[0][1] = "Scenario 01/Movie Search_PositiveScenario";

            detail[1][0] = "12345678";
            detail[1][1] = "Scenario 02/Movie Search_NegativeScenario";

        }
        else if (mtd.getName().equalsIgnoreCase("castCrew")) {

            detail = new Object[2][4];
            detail[0][0] = "Tom Holland";
            detail[0][1] = "Mychael Danna";
            detail[0][2] = "Onward";
            detail[0][3] = "Scenario 03/CastCrew_PositiveScenario";

            detail[1][0] = "Tom Cruise";
            detail[1][1] = "Michael Jackson";
            detail[1][2] = "Onward";
            detail[1][3] = "Scenario 04/CastCrew_NegativeScenario";
        }
        else if (mtd.getName().equalsIgnoreCase("searchOffer")) {

            detail = new Object[2][2];
            detail[0][0] = "ICICI Bank Credit Card";
            detail[0][1] = "Scenario 09/Search Offers_PositiveScenario";

            detail[1][0] = "Kotak Mahindra Offer";
            detail[1][1] = "Scenario 10/Search Offers_NegativeScenario";
        }

        return detail;
    }
}

