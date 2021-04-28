package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suport.Web;

public class InformacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador= Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
       String textoToast = new LoginPage(navegador)
                .clickSignIn().
                fazerLogin("julio0001","123456")
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
               .adicionarContato("Phone","+5511986582245")
               .capturarTextoToast();

       Assert.assertEquals("Your contact has been added!",textoToast);
    }

    @After
    public void tearDown(){

        //navegador.quit();
    }




}
