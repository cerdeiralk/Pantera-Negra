package compraAzul;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.lang.model.element.Element;
import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Compra { 
	 public WebDriver navegador;
	    @Before
	    public void setUp(){
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sempre IT\\eclipse-workspace\\Driver\\chromedriver.exe");
	        navegador = new ChromeDriver();
	        navegador.manage().window().maximize();
	        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
	
	@Dado("que estou no site www.voeazul.com.br")
	public void que_estou_no_site_www_voeazul_com_br() {
	   navegador.get("https://www.voeazul.com.br");
	   
	}

	@Quando("preencho as informacoes da viagem")
	public void preencho_as_informacoes_da_viagem() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(navegador, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("TCSS__tabbox-shopping")));
		navegador.findElement(By.xpath("//*[@value='OneWay']")).click();
		navegador.findElement(By.xpath("//input[@id='field-5-origin1']")).sendKeys("GRU");
		navegador.findElement(By.xpath("//input[@id='field-5-origin1']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//input[@id='field-6-destination1']")).sendKeys("SDU");
		navegador.findElement(By.xpath("//input[@id='field-6-destination1']")).sendKeys(Keys.ENTER);
		Random aleatorio = new Random();
		int dia = aleatorio.nextInt(150);
		LocalDate dataDePartida = LocalDate.now().plusDays(dia);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		navegador.findElement(By.xpath("//input[@id='field-7-departure1']")).sendKeys((dataDePartida.format(formato)).toString());
		Thread.sleep(2000);
		navegador.findElement(By.id("searchTicketsButton")).click();

	}

	@Quando("seleciono o voo")
	public void seleciono_o_voo() throws InterruptedException {
		Thread.sleep(6000);
		navegador.findElement(By.xpath("(//*[@id='AvailabilityInputAvailabilityView_LinkButtonSubmit'])[1]")).click();

	}

	@Quando("preencho os dados do passageiro")
	public void preencho_os_dados_do_passageiro() throws InterruptedException {
		navegador.findElement(By.xpath("//input[@id='PassengerControlPassengerView_TextBoxFirstName_0']")).sendKeys("Jailtom");
		navegador.findElement(By.xpath("//input[@id='PassengerControlPassengerView_TextBoxLastName_0']")).sendKeys("De Caxias");
		navegador.findElement(By.xpath("//*[@id='countryDiv']/div/button")).click();
		Thread.sleep(4000);
		navegador.findElement(By.xpath("//*[@id='countryDiv']/div/div/ul/li[2]/a")).click();
		navegador.findElement(By.xpath("//*[@id='informationGenderDiv_0']/div/button")).click();
		navegador.findElement(By.xpath("//*[@id='informationGenderDiv_0']/div/div/ul/li[3]/a/span[1]")).click();
		navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_TextBoxBirthDate_0']")).sendKeys("26/10/1985");
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_TextBoxEmail_0']")).sendKeys("jail@test.com");
		navegador.findElement(By.xpath("//*[@id='PassengerControlPassengerView_LinkButtonSubmit']")).click();
	}

	@Quando("escolho o assento")
	public void escolho_o_assento() throws InterruptedException {
		Random aleatorio = new Random();
		int poltrona = aleatorio.nextInt(45);
		navegador.findElement(By.xpath("(//a[contains(@class,'seat -available') and @unit_value_pax_0='R$ 0,00'])[" + poltrona + "]")).click();
		Thread.sleep(9000);
		navegador.findElement(By.xpath("//*[@id='btnProsseguir']")).click();

	}

	@Quando("clico em prossserguir na tela de bagagem")
	public void clico_em_prossserguir_na_tela_de_bagagem() throws InterruptedException {
		Thread.sleep(2000);
		navegador.findElement(By.xpath("//button[@id='btnContinue']")).click();
	}

	@Quando("preencho dados de contato")
	public void preencho_dados_de_contato() {
		navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxPostalCode']")).sendKeys("06286290");
		navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxAddressNumber']")).sendKeys("29");
		navegador.findElement(By.xpath("//input[@id='PaymentInputControlCheckoutView_ContactInputControlCheckoutView_TextBoxOtherPhone']")).sendKeys("21992378760");

	}

	@Quando("marco a checkbox dizendo que li e concordo com as regras")
	public void marco_a_checkbox_dizendo_que_li_e_concordo_com_as_regras() {
		navegador.findElement(By.xpath("//label[@for='PaymentInputControlCheckoutView_CheckboxTerms']")).click();
		((RemoteWebDriver) navegador).executeScript("scrollBy(0,950)", "");
		
	}
	
	
	@Entao("valida que o botao confirmar reserva esta habilitado")
	public void valida_que_o_botao_confirmar_reserva_esta_habilitado() {
	navegador.findElement(By.xpath("//button[@class='btn btn-action btn-next']"));
		
	System.out.println("Botao habilitado com sucesso!!");
	
		 
	}
}
	    
	