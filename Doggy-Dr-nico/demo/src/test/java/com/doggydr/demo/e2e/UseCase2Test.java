package com.doggydr.demo.e2e;

import java.time.Duration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UseCase2Test {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String BASE_URL = "http://localhost:4200";

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications", "--disable-extensions");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testAddNewTreatmentAndVerify() {
        // Inicio de sesión del veterinario
        driver.get(BASE_URL + "/loginVet");
        driver.findElement(By.id("user")).sendKeys("valeG");
        driver.findElement(By.id("password")).sendKeys("passValentina");
        driver.findElement(By.id("loginBtn")).click();

        // Esperar y navegar a la opción de Administrar Mascotas
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));

WebElement adminMascotasButton = driver.findElement(By.xpath("//h3[text()='Administrar Mascotas']"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adminMascotasButton);

wait.until(ExpectedConditions.visibilityOf(adminMascotasButton));

((JavascriptExecutor) driver).executeScript("arguments[0].click();", adminMascotasButton);

wait.until(ExpectedConditions.urlContains("/pet/all"));


        // Buscar la mascota "Perry"
        driver.findElement(By.className("search-input")).sendKeys("Perry");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("liPetName")));
        WebElement petRow = driver.findElement(By.xpath("//tr[contains(., 'Perry')]"));

        // Ir a Editar la mascota "Perry"
        petRow.findElement(By.xpath(".//a[text()='Editar']")).click();
        wait.until(ExpectedConditions.urlContains("/pet/update"));

        // Seleccionar tratamiento en el formulario de actualización
        WebElement treatmentDropdown = driver.findElement(By.id("treatment"));
        treatmentDropdown.click();
        WebElement newTreatmentOption = driver
                .findElement(By.xpath("//option[contains(text(), 'Tratamiento de inflamación')]"));
        newTreatmentOption.click();

        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-primary"));
        saveBtn.click();

        // Verificar que el tratamiento esté asignado
        driver.findElement(By.xpath("//a[text()='Ver']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pet-info")));
        WebElement treatmentsList = driver.findElement(By.xpath("//ul"));
        Assertions.assertThat(treatmentsList.getText()).contains("Nuevo Tratamiento para Perry");

        // Iniciar sesión como administrador
        driver.get(BASE_URL + "/loginAdmin");
        driver.findElement(By.id("user")).sendKeys("juanSe");
        driver.findElement(By.id("password")).sendKeys("angarita");
        driver.findElement(By.cssSelector(".button")).click();
        wait.until(ExpectedConditions.urlContains("/admin"));

        // Ir al Dashboard
        driver.findElement(By.xpath("//h3[text()='Consultar Estadísticas']")).click();
        wait.until(ExpectedConditions.urlContains("/admin/dashboard"));

        // Verificar los valores de estadísticas iniciales
        WebElement initialTreatments = driver.findElement(By.id("totalTreatments"));
        WebElement initialEarnings = driver.findElement(By.id("totalEarnings"));
        int initialTreatmentCount = Integer.parseInt(initialTreatments.getText());
        double initialEarningsValue = Double.parseDouble(initialEarnings.getText());

        // Recargar y verificar el incremento en tratamientos y ganancias
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalTreatments")));

        int updatedTreatmentCount = Integer.parseInt(driver.findElement(By.id("totalTreatments")).getText());
        double updatedEarningsValue = Double.parseDouble(driver.findElement(By.id("totalEarnings")).getText());

        Assertions.assertThat(updatedTreatmentCount).isGreaterThan(initialTreatmentCount);
        Assertions.assertThat(updatedEarningsValue).isGreaterThan(initialEarningsValue);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
