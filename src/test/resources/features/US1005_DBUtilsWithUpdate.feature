Feature:US1005 kullanici database update yapar

  Scenario: TC05 Kullanici update yapabilmeli
    Given kullanici DBUtils ie HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1017 olan kaydin Email bilgisini "bosYapmaa@gmail.com" yapar
    #UPDATE from tHOTEL set Email = 'sizOldunuz@gmail.com' WHERE 'IDHotel=1016'