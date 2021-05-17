package a04CuartaClase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;

public class EjercicioGit {

    private static final String URL_LOGIN = "https://login.salesforce.com/?locale=eu";
    WebDriver driver;

    @Test (priority = 3)
    public void LoginFailureTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_LOGIN);

        //Valido que el logo se encuentre en el sitio.
        WebElement logo = driver.findElement(By.xpath("//img[@id='logo']"));
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Se visualiza el logo en la pagina de inicio");

        //Completo Username y Password:
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123466");

        //Hago Login
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        Thread.sleep(4000);

        //Imprimo en pantalla el mensaje de error:
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
        System.out.println("\nEl error de Inicio de Sesion por pantalla es: " + errorMessage.getText());
    }
}
