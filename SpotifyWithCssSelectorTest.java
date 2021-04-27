package TerceraClase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class SpotifyWithCssSelectorTest {
    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        String urlSite = "https://www.spotify.com/uy/signup/";
        String day = "13";
        String year = "1990";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(urlSite);

        //Completo el campo Email:
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        //Confirmo el mail:
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        //Completo el campo Password:
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("qatest123");
        //Completo el campo ¿Cómo quieres que te llamemos?:
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("pruebasQA");
        //Completo el campo Dia:
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys(day);
        //Completo el campo Mes:
        WebElement mes = driver.findElement(By.cssSelector("[name='month'] option[value='02']"));
        Thread.sleep(2000);
        mes.click();
        //Completo el campo Año:
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys(year);
        //Clickeo el genero:
        List<WebElement> listGenero = driver.findElements(By.cssSelector("span.Indicator-sc-16vj7o8-0.iBjMfh"));
        for(int i = 0; i < listGenero.size();i++){
            listGenero.get(0).click();
        }
        // Clickeo los check de Prefiero no recibir publicidad de Spotify y
        // Compartir mis datos de registro con los proveedores de contenido de Spotify para fines de marketing:

        List<WebElement> listMarketing = driver.findElements(By.cssSelector("span.Indicator-sc-11vkltc-0.ioJObh"));
        for(int i = 0; i < listMarketing.size();i++){
            listMarketing.get(i).click();
        }
    }
}
