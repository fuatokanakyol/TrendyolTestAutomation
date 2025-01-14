# Trendyol Web Test Automation Project

Bu proje Selenium WebDriver, TestNG ve Cucumber kullanılarak oluşturulmuş bir web test otomasyon framework'üdür.

## Gereksinimler

* Java JDK 8 veya üzeri
* Maven 3.x
* Chrome Browser
* ChromeDriver

## Kurulum
1. Projeyi klonlayın:
```bash
    git clone <https://github.com/fuatokanakyol/TrendyolTestAutomation.git>

    cd TrendyolTestAutomation
```
2. Bağımlılıkları yükleyin:
mvn clean install

3. Testleri çalıştırma:
mvn clean test -Dtest=runner
mvn clean test -Dtest=runner -Dcucumber.filter.tags="@smoke"

4. Poje yapısı:
src
├── test
│   ├── java
│   │   ├── features          # Cucumber feature dosyaları
│   │   ├── pages            # Page Object Model sınıfları
│   │   ├── stepDefinitions  # Cucumber step tanımlamaları
│   │   └── utils           # Yardımcı sınıflar
│   └── resources
│       └── config.properties # Konfigürasyon dosyası


5. Raporlama:
Test raporları şu konumda oluşturulur: Reports.html

6. Tech Stack:
Selenium WebDriver
TestNG
Cucumber
Maven
Java

7. Not:

Testleri çalıştırmadan önce:
Chrome tarayıcının yüklü olduğundan emin olun
ChromeDriver'ın PATH'e eklendiğinden emin olun
Java ve Maven'ın doğru kurulu olduğundan emin olun