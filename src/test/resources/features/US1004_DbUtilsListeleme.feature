Feature: US1004 kullanici istenen tablodaki istenen field'i listeleyebilir

  Scenario: TC04 Kullanici field lsitesi yazdırabilmeli

    Given kullanici DBUtils ie HMC veri tabanina baglanir
    And kullanici DBUtils ie  "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanici DBUtils ie "Email" sutunundaki verileri okur
    And DBUtils ile tum "Email" degerlerini sira numarasi ile yazdirir
