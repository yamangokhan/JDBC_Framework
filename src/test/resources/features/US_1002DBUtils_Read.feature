Feature: US1002 kullanici DB Utils ile baglantısı yapabilir

  Scenario: TC02 Kullanici DB Utils ile database'deki bilgileri okur
    Given kullanici DBUtils ie HMC veri tabanina baglanir
    And kullanici DBUtils ie  "tHOTELROOM" tablosundaki "Price" verilerini alir
    # select Price from tHOTELROOM
    And kullanici DBUtils ie "Price" sutunundaki verileri okur