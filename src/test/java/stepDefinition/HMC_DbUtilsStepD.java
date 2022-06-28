package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DbUtilsStepD {
    @Given("kullanici DBUtils ie HMC veri tabanina baglanir")
    public void kullaniciDBUtilsIeHMCVeriTabaninaBaglanir() {
        DBUtils.getConnection();
    }

    @And("kullanici DBUtils ie  {string} tablosundaki {string} verilerini alir")
    public void kullaniciDBUtilsIeTablosundakiVerileriniAlir(String table, String field) {
        String query = "SELECT " + field + " FROM " + table;
        DBUtils.executeQuery(query);
    }

    @And("kullanici DBUtils ie {string} sutunundaki verileri okur")
    public void kullaniciDBUtilsIeSutunundakiVerileriOkur(String field) throws SQLException {
        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field));

    }

    @And("DBUtils ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilsIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {

 //  1. derste while loop ile next methodunu kullanarak liste yazdırmıstık
        // simdi de for loop ile liste yazdıralım
        DBUtils.getResultset().last();//imlec en sona gider
        int sonSatirNo = DBUtils.getResultset().getRow();
        DBUtils.getResultset().first(); //imlec tekrar basa gelir
        for (int i = 1; i < sonSatirNo ; i++) {
            System.out.println( i+". kayıt: " + DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }
    }

    @Then("DBUtills ile {int}. {string} in {int} oldugunu test eder")
    public void dbutillsIleInOldugunuTestEder(int istnenenSiraNO, String field, int ExpectedDeger) throws SQLException {
        DBUtils.getResultset().absolute(istnenenSiraNO);
        double actualDeger = DBUtils.getResultset().getDouble(field);
        System.out.println("expected deger : " + ExpectedDeger);
        System.out.println("actual deger : " + actualDeger);

        Assert.assertTrue(actualDeger==ExpectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String newEmail) {

        String updateQuery="UPDATE tHOTEL SET Email = '"+newEmail+"' WHERE IDHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);

    }
}
