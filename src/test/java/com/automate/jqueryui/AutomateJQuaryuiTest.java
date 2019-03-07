package com.automate.jqueryui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class AutomateJQuaryuiTest {

	public WebDriver driver;

	public void automateJquryuiWebsite() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/");

		String getTitle = driver.getTitle();
		System.out.println("Title: " + getTitle);

		/** Interactions **/

		// Dragg_able

		WebElement clickDraggableBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(1) > ul > li:nth-child(1)"));
		clickDraggableBtn.click();

		driver.switchTo().frame(0);
		WebElement draggableElem = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		action.clickAndHold(draggableElem).moveByOffset(150, 150).build().perform();

		// Dropp_able

		driver.switchTo().defaultContent();
		WebElement clickDroppableBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(1) > ul > li:nth-child(2)"));
		clickDroppableBtn.click();

		driver.switchTo().frame(0);
		WebElement drappableElem = driver.findElement(By.id("draggable"));
		action.clickAndHold(drappableElem).moveByOffset(160, 30).build().perform();

		// Resiz_able

		driver.switchTo().defaultContent();
		WebElement clickResizableBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(1) > ul > li:nth-child(3)"));
		clickResizableBtn.click();

		driver.switchTo().frame(0);
		WebElement resizableElem = driver.findElement(By.cssSelector(
				"#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
		action.clickAndHold(resizableElem).moveByOffset(120, 120).build().perform();

		// Select_able
		
		driver.switchTo().defaultContent();
		WebElement selectableBtn = driver.findElement(By.xpath("//a[contains(text(),'Selectable')]"));
		selectableBtn.click();
		
		driver.switchTo().frame(0);
		WebElement selectableLink = driver.findElement(By.id("selectable"));
		List<WebElement> tagnameLi = selectableLink.findElements(By.tagName("li"));
		WebElement item3 = tagnameLi.get(2);
		WebElement item7 = tagnameLi.get(6);
		action.click(item3).sendKeys(Keys.CONTROL).build().perform();
		action.click(item7).sendKeys(Keys.CONTROL).build().perform();
		
		// Sort_able

		driver.switchTo().defaultContent();
		WebElement clickSortableBtn = driver
				.findElement(By.xpath("//a[contains(text(),'Sortable')]"));
		clickSortableBtn.click();

		driver.switchTo().frame(0);
		WebElement sortable_1_Elem = driver.findElement(By.cssSelector("#sortable > li:nth-child(1)"));
		WebElement sortable_7_Elem = driver.findElement(By.cssSelector("#sortable > li:nth-child(7)"));
		action.clickAndHold(sortable_7_Elem).moveToElement(sortable_1_Elem).build().perform();

		/** Widgets **/

		// Accordion

		driver.switchTo().defaultContent();
		WebElement clickAccordionBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(1)"));
		clickAccordionBtn.click();

		driver.switchTo().frame(0);
		WebElement clickSelect3Btn = driver.findElement(By.id("ui-id-5"));
		clickSelect3Btn.click();

		// Auto_complete

		driver.switchTo().defaultContent();
		WebElement clickAutocompleteBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(2)"));
		clickAutocompleteBtn.click();

		driver.switchTo().frame(0);
		WebElement selectFromTagboxElem = driver.findElement(By.id("tags"));
		selectFromTagboxElem.click();
		selectFromTagboxElem.sendKeys("Ja");
		driver.findElement(By.id("ui-id-2")).click();

		Thread.sleep(2000);

		// Button

		driver.switchTo().defaultContent();
		WebElement clickButtonElem = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(3)"));
		clickButtonElem.click();

		driver.switchTo().frame(0);
		WebElement clickAnanchorBtn = driver.findElement(By.cssSelector("body > div > a"));
		clickAnanchorBtn.click();

		// Check_box_radio

		driver.switchTo().defaultContent();
		WebElement clickCheckboxRadioBtn = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(4)"));
		clickCheckboxRadioBtn.click();

		driver.switchTo().frame(0);
		WebElement clickParisRadioBtn = driver
				.findElement(By.cssSelector("body > div > fieldset:nth-child(3) > label:nth-child(4)"));
		clickParisRadioBtn.click();
		WebElement check3StarBox = driver
				.findElement(By.cssSelector("body > div > fieldset:nth-child(5) > label:nth-child(4)"));
		check3StarBox.click();
		WebElement check5StarBox = driver
				.findElement(By.cssSelector("body > div > fieldset:nth-child(5) > label:nth-child(8)"));
		check5StarBox.click();
		WebElement check2QueenBox = driver
				.findElement(By.cssSelector("body > div > fieldset:nth-child(7) > label:nth-child(3)"));
		check2QueenBox.click();
		WebElement check1KingBox = driver
				.findElement(By.cssSelector("body > div > fieldset:nth-child(7) > label:nth-child(5)"));
		check1KingBox.click();

		// Control_group

		driver.switchTo().defaultContent();
		WebElement clickControlgroupElem = driver
				.findElement(By.cssSelector("#sidebar > aside:nth-child(2) > ul > li:nth-child(5)"));
		clickControlgroupElem.click();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='ui-selectmenu-text']")).click();
		driver.findElement(By.id("ui-id-4")).click();
		driver.findElement(By.xpath("//label[@for='transmission-automatic']")).click();
		driver.findElement(By.xpath("//label[@for='insurance']")).click();
		WebElement carAmount = driver.findElement(By.cssSelector(
				"div.widget:nth-child(1) fieldset:nth-child(2) div.controlgroup.ui-controlgroup.ui-controlgroup-horizontal.ui-helper-clearfix:nth-child(2) span.ui-widget.ui-widget-content.ui-spinner.ui-controlgroup-item:nth-child(10) > a.ui-button.ui-widget.ui-spinner-button.ui-button-icon-only.ui-spinner-up:nth-child(2)"));
		for (int i = 0; i < 5; i++)
			carAmount.click();
		driver.findElement(By.cssSelector("body > div.widget > fieldset:nth-child(2) > div > button")).click();
		driver.findElement(By.id("ui-id-8-button")).click();
		driver.findElement(By.id("ui-id-13")).click();
		driver.findElement(By.xpath("//label[@for='transmission-standard-v']")).click();
		driver.findElement(By.xpath("//label[@for='insurance-v']")).click();
		WebElement carAmount2 = driver.findElement(By.cssSelector(
				"div.widget:nth-child(1) fieldset:nth-child(4) div.controlgroup-vertical.ui-controlgroup.ui-controlgroup-vertical:nth-child(2) span.ui-widget.ui-widget-content.ui-spinner.ui-controlgroup-item:nth-child(10) > a.ui-button.ui-widget.ui-spinner-button.ui-button-icon-only.ui-spinner-down:nth-child(3)"));
		for (int i = 0; i < 7; i++)
			carAmount2.click();
		driver.findElement(By.xpath("//button[@id='book']")).click();

		// Date_picker

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Datepicker')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#datepicker")).click();
		driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(3) > td:nth-child(6) > a"))
				.click();

		// Dialog

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Dialog')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-closethick']")).click();

		// Menu

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Menu')]")).click();

		driver.switchTo().frame(0);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-9")));
		driver.findElement(By.cssSelector("#ui-id-9")).click();

		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-13")));
		driver.findElement(By.cssSelector("#ui-id-13")).click();

		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-16")));
		driver.findElement(By.cssSelector("#ui-id-16")).click();

		// Progress_bar

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Progressbar')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Custom Label')]")).click();

		driver.switchTo().frame(0);
		WebDriverWait waitForCompleteBtn = new WebDriverWait(driver, 60);
		waitForCompleteBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[2]")));

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Indeterminate Value')]")).click();

		driver.switchTo().frame(0);
		Thread.sleep(1000);
		WebElement colorBtn = driver.findElement(By.id("colorButton"));
		for (int i = 0; i < 4; i++)
			colorBtn.click();

		Thread.sleep(2000);

		WebElement numButton = driver.findElement(By.id("numButton"));
		for (int i = 0; i < 2; i++)
			numButton.click();

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Download Dialog')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.id("downloadButton")).click();
		/*
		 * WebDriverWait waitForCancelBtn = new WebDriverWait(driver, 60);
		 * waitForCancelBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		 * ("/html[1]/body[1]/div[1]/div[3]/div[1]")));
		 */
		Thread.sleep(9000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]")).click();

		// Select menu

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Selectmenu')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/fieldset[1]/span[1]/span[1]")).click();
		driver.findElement(By.id("ui-id-5")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/fieldset[1]/span[2]/span[1]")).click();
		driver.findElement(By.id("ui-id-9")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/fieldset[1]/span[3]/span[1]")).click();
		driver.findElement(By.id("ui-id-19")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/fieldset[1]/span[4]/span[1]")).click();
		driver.findElement(By.id("ui-id-33")).click();

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Product Selection')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.id("radius-button")).click();
		driver.findElement(By.id("ui-id-5")).click();
		driver.findElement(By.id("color-button")).click();
		driver.findElement(By.id("ui-id-7")).click();

		// Slider

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/slider/']")).click();

		driver.switchTo().frame(0);
		WebElement sliderBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/span[1]"));
		action.clickAndHold(sliderBtn).moveByOffset(250, 0).build().perform();

		// Spinner

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Spinner')]")).click();

		driver.switchTo().frame(0);
		WebElement spinnerBtn = driver.findElement(By.xpath("/html[1]/body[1]/p[1]/span[1]/a[1]"));
		for (int i = 0; i < 10; i++)
			spinnerBtn.click();
		driver.findElement(By.id("disable")).click();

		// Tabs

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='http://jqueryui.com/tabs/']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Simple manipulation')]")).click();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/ul[1]/li[1]/span[1]")).click();
		driver.findElement(By.id("add_tab")).click();
		WebElement tabTitle = driver.findElement(By.id("tab_title"));
		tabTitle.click();
		tabTitle.clear();
		tabTitle.sendKeys("MAHAMMAD");
		WebElement tabContent = driver.findElement(By.id("tab_content"));
		tabContent.click();
		tabContent.clear();
		tabContent.sendKeys("I'm professional QA");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/button[1]")).click();

		// Tool_tip

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Tooltip')]")).click();

		driver.switchTo().frame(0);
		WebElement ageField = driver.findElement(By.id("age"));
		action.moveToElement(ageField);
		Thread.sleep(1000);
		ageField.sendKeys("35");

		// Test ended

		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
