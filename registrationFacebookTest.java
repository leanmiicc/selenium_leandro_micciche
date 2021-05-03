package SegundaClase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class registrationFacebookTest {
    static String url = "https://www.facebook.com/";
    static String name = "John";
    static String lastName = "Smith";
    static String emailMobile = "5555555";
    static String password = "123456789";
    static String day = "26";
    static String month = "jun";
    static String year = "1980";
    static String[] sex = {"mujer", "hombre", "personalizado"};
    static WebDriver driver;


    @Test
    public void fullRegistrationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(5000);

        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(emailMobile);
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
        setBirthday(day,month,year);
        setGender(sex[1]);

        //Valido los campos:
        validateName(name);
        validateLastName(lastName);
        validateEmailMobile(emailMobile);
        validatePassword(password);
        validateDay(day);
        validateMonth(month);
        validateYear(year);
        validateRadioButtom();
    }

    private static void setBirthday (String parameterDay, String parameterMonth, String parameterYear){
        WebElement dayElement = driver.findElement(By.name("birthday_day"));
        WebElement monthElement = driver.findElement(By.name("birthday_month"));
        WebElement yearElement = driver.findElement(By.name("birthday_year"));

        //Creo el objeto select de cada unos de los elementos.
        Select daySelect = new Select(dayElement);
        Select monthSelect = new Select(monthElement);
        Select yearSelect = new Select(yearElement);

        daySelect.selectByValue(parameterDay);
        monthSelect.selectByVisibleText(parameterMonth);
        yearSelect.selectByValue(parameterYear);
    }

    private static void setGender (String genero){
        List<WebElement> radioButtonsSex = driver.findElements(By.name("sex"));
        Assert.assertEquals(radioButtonsSex.size(),3);
        int gender = 0;

        if(genero.contentEquals("mujer")){
            gender = 0;
            WebElement clickButtonFamale = radioButtonsSex.get(gender);
            clickButtonFamale.click();
        } else if (genero.contentEquals("hombre")){
            gender = 1;
            WebElement clickButtonMale = radioButtonsSex.get(gender);
            clickButtonMale.click();
        } else if (genero.contentEquals("personalizado")){
            gender = 2;
            WebElement clickButtonPersonalized = radioButtonsSex.get(gender);
            clickButtonPersonalized.click();
            WebElement sexElement = driver.findElement(By.name("preferred_pronoun"));
            Select sexSelect = new Select(sexElement);
            sexSelect.selectByValue("6");
            driver.findElement(By.name("custom_gender")).sendKeys("Le");
        }

    }

    private static void validateName (String name){
        WebElement nombre = driver.findElement(By.name("firstname"));
        Assert.assertEquals(nombre.getAttribute("value").equals(name),true);
        System.out.println("Se completo correctamente el campo Nombre.");
    }

    private static void validateLastName (String lastName){
        WebElement apellido = driver.findElement(By.name("lastname"));
        Assert.assertEquals(apellido.getAttribute("value").equals(lastName),true);
        System.out.println("Se completo correctamente el campo Apellido.");
    }

    private static void validateEmailMobile (String emailMobile){
        WebElement emailMovil = driver.findElement(By.name("reg_email__"));
        Assert.assertEquals(emailMovil.getAttribute("value").equals(emailMobile),true);
        System.out.println("Se completo correctamente el campo Email o Movil.");
    }

    private static void validatePassword (String password){
        WebElement contraseña = driver.findElement(By.name("reg_passwd__"));
        Assert.assertEquals(contraseña.getAttribute("value").equals(password),true);
        System.out.println("Se completo correctamente el campo Password.");
    }

    private static void validateDay (String day){
        WebElement dayElement = driver.findElement(By.name("birthday_day"));
        Select dayOption = new Select(dayElement);
        String option = dayOption.getFirstSelectedOption().getText();
        Assert.assertEquals(day,option);
        System.out.println("Se completo correctamente el Menu Dia.");
    }

    private static void validateMonth (String month){
        WebElement monthElement = driver.findElement(By.name("birthday_month"));
        Select monthOption = new Select(monthElement);
        String option = monthOption.getFirstSelectedOption().getText();
        Assert.assertEquals(month,option);
        System.out.println("Se completo correctamente el Menu Mes.");
    }

    private static void validateYear (String year){
        WebElement yearElement = driver.findElement(By.name("birthday_year"));
        Select yearOption = new Select(yearElement);
        String option = yearOption.getFirstSelectedOption().getText();
        Assert.assertEquals(year,option);
        System.out.println("Se completo correctamente el Menu Año.");
    }
    private static void validateRadioButtom () {
        List<WebElement> sexRadioButton = driver.findElements(By.name("sex"));
        Assert.assertEquals(sexRadioButton.isEmpty(), false);
        System.out.println("Se completo correctamente la opcion del sexo.");
    }
}
