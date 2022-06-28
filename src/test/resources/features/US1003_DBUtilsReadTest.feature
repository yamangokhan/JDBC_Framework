Feature: US1003 kullanici DBUtil ile istenen degeri test eder

  Scenario:TC03 Kullanici istenen degeri test edebilmeli

    Given kullanici DBUtils ie HMC veri tabanina baglanir
    And kullanici DBUtils ie  "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtils ie "Price" sutunundaki verileri okur
    Then DBUtills ile 2. "Price" in 4000 oldugunu test eder