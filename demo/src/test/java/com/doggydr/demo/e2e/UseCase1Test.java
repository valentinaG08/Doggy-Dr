package com.doggydr.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.BeforeParam;
import org.openqa.selenium.By;
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
public class UseCase1Test {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final String BASE_URL = "http://localhost:4200";

    @BeforeEach
    public void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void UseCase1Test_registerNewOwnerAndPet() {
        // Inicio de sesión del veterinario
        driver.get(BASE_URL + "/loginVet");
        WebElement inputUsername = driver.findElement(By.id("user"));
        WebElement inputPassword = driver.findElement(By.id("password"));

        // Intento fallido de inicio de sesión
        inputUsername.sendKeys("valeG");
        inputPassword.sendKeys("IncorrectPassValentina");
        WebElement loginBtn = driver.findElement(By.id("loginBtn"));
        loginBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginErrorMessage"))); //Verificar id
        Assertions.assertThat(driver.findElement(By.id("loginErrorMessage")).isDisplayed()).isTrue();

        // Segundo intento exitoso
        inputPassword.clear();
        inputPassword.sendKeys("passValentina");
        loginBtn.click();
        
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/owner/all"));

        //Agregar al cliente
        driver.get(BASE_URL + "/owner/all");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnAgregar = driver.findElement(By.id("btnAgregar"));
        btnAgregar.click();
        WebElement inputId = driver.findElement(By.id("id"));
        WebElement inputName = driver.findElement(By.id("name"));
        WebElement inputUser = driver.findElement(By.id("username"));
        WebElement inputDoc = driver.findElement(By.id("document"));
        WebElement inputPhone = driver.findElement(By.id("phone"));
        WebElement inputMail = driver.findElement(By.id("mail"));

        // Intento con error en el email
        inputId.sendKeys("1");
        inputName.sendKeys("Valentina");
        inputUser.sendKeys("valeG");
        inputDoc.sendKeys("1016593252");
        inputPhone.sendKeys("3112080808");
        inputMail.sendKeys("valentina@gmail"); //Error al verificar el punto

        //Calcular la cantidad de elementos de una lista inicial
        List<WebElement> listaInicial = driver.findElements(By.className("liOwnerName"));

        WebElement btnSubmit = driver.findElement(By.id("enviarClienteBtn"));
        btnSubmit.click();

        // Verificar que se muestre un mensaje de error de validación
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailError"))); //falta
        Assertions.assertThat(driver.findElement(By.id("emailError")).isDisplayed()).isTrue();

        // Corrección y nuevo intento
        inputMail.clear();
        inputMail.sendKeys("valentina@gmail.com");
        btnSubmit.click();
            
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/owner/all"));
        List<WebElement> list = driver.findElements(By.className("liOwnerName"));
        Assertions.assertThat(list.stream().anyMatch(e -> e.getText().contains("Valentina"))).isTrue();
        
        // Registro de la mascota
        driver.get(BASE_URL + "/pet/all");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregarMascota")));
        WebElement btnAgregarMascota = driver.findElement(By.id("btnAgregarMascota"));
        btnAgregarMascota.click();

        WebElement petNombre = driver.findElement(By.id("nombre"));
        WebElement petRaza = driver.findElement(By.id("raza"));
        WebElement petEdad = driver.findElement(By.id("edad"));
        WebElement petEnfermedad = driver.findElement(By.id("enfermedad"));
        WebElement petPeso = driver.findElement(By.id("peso"));
        WebElement petUrlImage = driver.findElement(By.id("urlImage"));
        WebElement petOwner = driver.findElement(By.id("owner"));
        
        petNombre.sendKeys("Leon");
        petRaza.sendKeys("Frenh Poodle");
        petEdad.sendKeys("9");
        petEnfermedad.sendKeys("Diabetes");
        petPeso.sendKeys("15");
        petUrlImage.sendKeys("https://th.bing.com/th/id/OIP.7CMFUVqVzJFsdD3rH7eVlgHaHa?w=197&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7");
        petOwner.sendKeys("Valentina");
        
        WebElement petSubmitBtn = driver.findElement(By.id("enviarMascotaBtn"));
        petSubmitBtn.click();
        
        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/pet/all"));
        List<WebElement> petList = driver.findElements(By.className("liPetName"));
        Assertions.assertThat(petList.stream().anyMatch(e -> e.getText().contains("Leon"))).isTrue();
        
        // Verificación del dueño
        driver.get(BASE_URL + "/login");
        WebElement clientDocInput = driver.findElement(By.id("document"));
        clientDocInput.sendKeys("12346789");
        WebElement clientLoginBtn = driver.findElement(By.id("clientLoginBtn"));
        clientLoginBtn.click();

        wait.until(ExpectedConditions.urlToBe(BASE_URL + "/owner/" + clientDocInput + "/pets"));
        List<WebElement> clientPets = driver.findElements(By.className("clientPetName"));
        Assertions.assertThat(clientPets.stream().anyMatch(e -> e.getText().contains("Leon"))).isTrue();
    }
    
        @AfterEach
        void tearDown(){
            //driver.quit();
        }
}
