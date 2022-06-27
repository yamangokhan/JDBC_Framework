Feature: US_1001 kullanıcı dogru bilgilerle database baglanabilmeli

  @gokhan
  Scenario: TC01 Kullanıcı database'deki bilgileri okur
    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    # select Price from tHOTELROOM
    And kullanici "Price" sutunundaki verileri okur