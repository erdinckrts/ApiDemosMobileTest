Feature: ApiDemos Uygulamasi Testleri
  Bir kullanici olarak
  Ozel Baslik aktivitesini dogrulamak istiyorum
  Boylesine metin kutulari ve navigasyon cubugu metinlerinin dogru oldugunu dogrulayabilirim

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
    Then asagidaki metinlerin guncellendigi kontrol edilir:

      | texBox_sag          | Right is always right changed  |
      | navigationBar_sol    | Right is always right changed   |
      | navigationBar_sag    | Left is best changed |

      | textBox_sol          |  Left is best  |
      | texBox_sag          | Right is always right   |
      | navigationBar_sol    | Right is always right    |
      | navigationBar_sag    | Left is best |