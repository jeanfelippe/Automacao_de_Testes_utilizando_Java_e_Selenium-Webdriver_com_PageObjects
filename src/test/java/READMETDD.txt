



{
Generator= gera horario em que foto foi tirada
ScreenShot= tira screenshot, e salva como tipo File(arquivo)
InformacoesUsuarioTestScreen= classe
}


{
 metodo removerUmContatoDeUmUsuario= remover determinado fone de contato e tirar foto
 @Rule
 public TestName test= new TestName(); // instancia gerada para utilizar dentro do method e pegar nome
 do method
}

{
Arquivo TDD(teste dirigido a dados=DataDrivenTest)
class InformacoesUsuarioTestScreen method testAdicionarUmaInformacaoAdicionalDoUsuario
Arquivo CSV dentro do diretorio resources dentro de test(projeto de cima) para armazenar a massa de dados ao qual será inserida na execução dos testes
funções utilizadas :
@RunWith(DataDrivenTestRunner)
@DataLoader(filePaths = "InformacoesUsuarioTestScreenData.csv")

Insira o seguinte trecho nas dependencias do arquivo pom
---------------------------------------------------------------------
<dependency>
            <groupId>org.easetech</groupId>
            <artifactId>easytest-core</artifactId>
            <version>1.4.0</version>
        </dependency>
---------------------------------------------------------------------

}

