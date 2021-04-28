package suport;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {


        public static WebDriver createChrome(){

        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Jean\\drivers\\chromedriver_win32 (2)\\chromedriver 89\\chromedriver.exe");
            ChromeDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //navegador.manage().window().maximize();

        //Navegando para a pagina do julio
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
        }
}
