    package test;
    import org.easetech.easytest.annotation.DataLoader;
    import org.easetech.easytest.annotation.Param;
    import org.easetech.easytest.runner.DataDrivenTestRunner;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Rule;
    import org.junit.Test;
    import org.junit.rules.TestName;
    import org.junit.runner.RunWith;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.Select;
    import suport.Web;
    import suport.Generator;
    import suport.Screenshot;

    import java.util.concurrent.TimeUnit;

    import static org.junit.Assert.assertEquals;

    //TDD= teste dirigido a dados ( preparar massa de dados para ser executado no teste )

    @RunWith(DataDrivenTestRunner.class)
    @DataLoader(filePaths = "InformacoesUsuarioTestScreenData.csv")
    public class InformacoesUsuarioTestScreen {
    private WebDriver navegador;

    @Rule
    public TestName test= new TestName();
    //instancia test criada para posteriormente utilizar getmethod name e pegar o nome da classe sem precisar referenciala

    @Before
    public void setUp(){
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Jean\\drivers\\chromedriver_win32 (2)\\chromedriver.exe");
        navegador= new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //navegador.manage().window().maximize();

        //Navegando para a pagina do julio
        navegador.get("http://www.juliodelima.com.br/taskit");
    }



    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagem")String mensagemEsperada) {
    //param=parametros para linkar aos dados no arquivo csv

        navegador= Web.createChrome();


        //Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sign in")).click();


        //Identificando o formulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name login que esta dentro do formulari ode id signinbox o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");


        //Digitar no campo com name passowrd que esta dentro do form de id chamado signinbox o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a classe me
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui texto more data about you
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //..inicio?

        //clicar no botao atraves do seu xpath //button[@data-target="addmoredate"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //identificar popup onde está o form id addmoredata
        WebElement popupAddMoreData= navegador.findElement(By.id("addmoredata"));

        //Na combo de opçao type escolher opc phone
        WebElement campoType=popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);
        //tipo= recebe o tipo especificado no arquivo csv campo tipo que é phone


        //no campo de nome contact digitar "+5555"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
        //contato= recebe o contato especificado no arquivo csv campo contato que é +5522..


        //Clicar no link de text SAVE que está no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //na mensagem de id toast container, validar que a mensagem do texto é "Your contact has been added"
        WebElement mensagemPop=navegador.findElement(By.id("toast-container"));
        String mensagem=mensagemPop.getText();
        assertEquals(mensagemEsperada,mensagem);




        /*
        //Validar que dentro do elemento com class "me" está o texto "Hi,Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
        */


    }

    //remover um usuario e tirar screenshot da tela mostrando a mensagem quando um user é deletado
    @Test
    public void removerUmContatoDeUmUsuario(){

        //Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name login que esta dentro do formulari ode id signinbox o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");


        //Digitar no campo com name passowrd que esta dentro do form de id chamado signinbox o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a classe me
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui texto more data about you
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //procurar o dado desejado que será removido
        //Clicar no elemento pelo xpath
        navegador.findElement(By.xpath("//span[text()=\"+551133334444\"]/following-sibling::a")).click();

        //Confirmar janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensagem foi rest in peace, dear phone
        WebElement mensagemPop=navegador.findElement(By.id("toast-container"));
        String mensagem=mensagemPop.getText();
        assertEquals("Rest in peace, dear phone!",mensagem);

        //instancia test @rule criada no inicio do script  utilizar getmethodname e pegar o nome do method sem precisar referenciar
        String screenshotArquivo="C:\\Users\\Jean\\drivers\\taskit" + Generator.dataHoraParaArquivo()+ test.getMethodName()+".png";
        Screenshot.tirar(navegador,screenshotArquivo);

        //Aguardar dez segundos para a janela desaparecer
    }


        //validacao
        //assertEquals(1,1);

        @After
        public void tearDown(){
            //fechar o navegador
            //navegador.close();
        }









}
