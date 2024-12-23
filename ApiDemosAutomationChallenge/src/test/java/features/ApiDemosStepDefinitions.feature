Feature: ApiDemos Uygulamasi Testleri

  @1
  Scenario: SENARYO001 Custom Title Ekran Kontrolu
    And App > Activity > Custom Title menusune gidilir
    Then left_textBox metni ile left_navigationBar için "Left is best" değeri geldiği görülür:
    Then right_textBox metni ile right_navigationBar için "Right is always right" değeri geldiği görülür:
    And Sol textBox alanina "Left is best changed" yazilir
    And Change Left butonuna tıklanır
    Then left_textBox metni ile left_navigationBar için "Left is best changed" değeri geldiği görülür:
    And sag textBox alanina "Right is always right changed" yazilir
    And Change Right butonuna tıklanır
    Then right_textBox metni ile right_navigationBar için "Right is always right changed" değeri geldiği görülür:
  @2
  Scenario: SENARYO002 List Dialog Ekran Kontrolu
    Given App > Alert Dialogs > List Dialog menüsüne gidilir
    When List dialog'dan rastgele bir öğe seçilir
    Then Seçilen öğenin sırası ve adı alert mesajında kontrol edilir
  @3
  Scenario: SENARYO003 Context Menu Ekran Kontrolu
    Given App > Fragment > Context Menu menusune gidilir
    When long press me butonuna uzun basılır
    Then Menü A ve Menü B öğesinin açıldığı kontrol edilir
  @4
  Scenario: SENARYO004 Hide and Show Ekran Kontrolu
    Given App > Fragment > Hide and Show ekranına gidilir
    Then Ekranda iki adet Hide düğmesi olduğu kontrol edilir
    Then Ekranda iki adet metin kutusu olduğunu kontrol edilir
    And  Birinci Hide butonuna tıklanır
    Then Birinci metin kutusunun gizlendiği görülür
    Then Birinci butonun "Show" olarak değiştiği görülür
    And  Birinci Show butonuna tıklanır
    Then Birinci metin kutusunun geri geldiğini görülür
    Then Birinci butonun "Hide" olarak değiştiği görülür
    And  İkinci Hide butonuna tıklanır
    Then İkinci butonun "Show" olarak değiştiği görülür
    And  İkinci Show butonuna tıklanır
    Then İkinci metin kutusunun geri geldiğini görülür
    Then İkinci butonun "Hide" olarak değiştiği görülür

    @5
  Scenario: SENARYO005 Gelen mesaj bildirimini kontrolu
    Given App > Notification > Incoming Message ekranına gidilir
    When Show Notification butonuna tıklanır
    And Bildirim Çubuğu açılır
    Then Bildirim geldiği görülür
    And Bildirime tıklanır
    Then Bildirim detayının açıldığı görülür
    And Bildirim çubuğundaki metin ile bildirim detayının tutarlı olduğu görülür

  @6
  Scenario: SENARYO006 Scrollable ekran Kontrolu
    Given Views > Tabs menu > Scrollable ekranına gidilir
    When Açılan ekranda son sıradaki Tab'a tıklanır
    Then Açılan sayfanın son sıradaki tab'a ait olduğu doğrulanır