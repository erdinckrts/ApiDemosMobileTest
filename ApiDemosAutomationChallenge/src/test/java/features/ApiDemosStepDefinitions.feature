Feature: ApiDemos Uygulamasi Testleri
  Bir kullanici olarak
  Ozel Baslik aktivitesini dogrulamak istiyorum
  Boylesine metin kutulari ve navigasyon cubugu metinlerinin dogru oldugunu dogrulayabilirim

  Scenario: SENARYO0001 List Dialog Ekran Kontrolu
    Given App > Alert Dialogs > List Dialog menüsüne gidilir
    When List dialog'dan rastgele bir öğe seçilir
    Then Seçilen öğenin sırası ve adı alert mesajında kontrol edilir


  Scenario: SENARYO01 Custom Title Ekran Kontrolu
    And App > Activity > Custom Title menusune gidilir
    Then left_textBox metni ile left_navigationBar için "Left is best" değeri geldiği görülür:
    Then right_textBox metni ile right_navigationBar için "Right is always right" değeri geldiği görülür:
    And Sol textBox alanina "Left is best changed" yazilir
    And Change Left butonuna tıklanır
    Then left_textBox metni ile left_navigationBar için "Left is best changed" değeri geldiği görülür:
    And sag textBox alanina "Right is always right changed" yazilir
    And Change Right butonuna tıklanır
    Then right_textBox metni ile right_navigationBar için "Right is always right changed" değeri geldiği görülür:


