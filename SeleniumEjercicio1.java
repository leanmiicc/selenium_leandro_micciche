import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumEjercicio1 {

    @Test
    public void validarSitioNetflix() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Ingreso al sitio:
        String urlSite = "https://www.netflix.com/ar/";
        driver.get(urlSite);

        //Creo una lista de H1 para mostrarlos;
        List<WebElement> headers1 = driver.findElements(By.tagName("h1"));
        System.out.println("***********  Elementos H1  ***********");
        for(WebElement h1 : headers1){
            System.out.println("Elemento H1: " + h1.getText());
        }
        System.out.println("***************************************");

        //Creo una lista de H2 para mostrarlos;
        List<WebElement> headers2 = driver.findElements(By.tagName("h2"));
        System.out.println("\n***********  Elementos H2  ***********");
        for(WebElement h2 : headers2){
            System.out.println("Elemento H2: " + h2.getText());
        }
        System.out.println("***************************************");

        //Refresco la pagina
        driver.navigate().refresh();

        //Creo una lista de botones para mostar el texto de cada uno:
        List<WebElement> btn = driver.findElements(By.tagName("button"));
        System.out.println("\n********  Texto de Botones  *********");
        for(WebElement btnText : btn){
            System.out.println("Texto Buton: " + btnText.getText());
        }
        System.out.println("***************************************");

        //Creo una lista de divs para mostrar la cantidad de la pagina:
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        System.out.println("\n********  Cantidad de Divs  *********");
        System.out.println("La cantidad de divs en el sitio es: " + divs.size());
        System.out.println("***************************************");

        //Obtengo y muestro el titulo de la pagina:
        System.out.println("\n********  Titulo del Sitio  *********");
        System.out.println("El titulo del sitio es: " + driver.getTitle());
        System.out.println("***************************************");

        //Creo una lista de links para mostrar la cantidad:
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("\n*******  Elementos tipo link  ********");
        System.out.println("La cantidad de elementos del tipo link del sitio es: " + links.size());
        System.out.println("***************************************");

    }
}
