Feature: ApiDemos Uygulamasi Testleri
  Bir kullanici olarak
  Ozel Baslik aktivitesini dogrulamak istiyorum
  Boylesine metin kutulari ve navigasyon cubugu metinlerinin dogru oldugunu dogrulayabilirim

  Scenario: SENARYO01 Custom Title Ekran Kontrolu
    And App > Activity > Custom Title menusune gidilir
    Then acilan aktivitede asagidaki metinlerin varsayilan degerleri kontrol edilir:
      | textBox_sol          |  Left is best  |
      | texBox_sag          | Right is always right   |
      | navigationBar_sol    | Right is always right    |
      | navigationBar_sag    | Left is best |
    And Sol textBox alanina "textBox_sol" yazilir
    And sag textBox alanina "texBox_sag" yazilir
    Then asagidaki metinlerin guncellendigi kontrol edilir:
      | textBox_sol          |  Left is best changed  |
      | texBox_sag          | Right is always right changed  |
      | navigationBar_sol    | Right is always right changed   |
      | navigationBar_sag    | Left is best changed |
