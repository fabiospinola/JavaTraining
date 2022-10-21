package org.scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    public static <WebElements> void main(String[] args) throws FileNotFoundException {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/fabio.spinola/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            WebDriver driver = new ChromeDriver(options);

            Actions action = new Actions(driver);

            String searchTerm = "jacuzzi";
            String URL = "https://pt.aliexpress.com/af/" + searchTerm + ".html?SearchText=" + searchTerm;
            driver.get(URL);

            /*WebElement acceptCookies = driver.findElement(By.cssSelector(".btn-accept"));
            action.moveToElement(acceptCookies);
            action.click();
            action.perform();

            WebElement forceMatrixView = driver.findElement(By.cssSelector(".svg-icon.m"));
            action.moveToElement(forceMatrixView);
            action.click();
            action.perform();*/

            driver.manage().window().maximize();

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");
            jse.executeScript("scrollBy(0,500)");

            int numOfItems = 9;
            WebElement pageContent = driver.findElement(By.cssSelector(".JIIxO"));
            List<WebElement> itemTitle = pageContent.findElements(By.cssSelector("._1tu1Z.Vgu6S"));
            List<WebElement> itemPrice = pageContent.findElements(By.cssSelector(".mGXnE._37W_B"));
            List<WebElement> itemImgURL = pageContent.findElements(By.cssSelector("._1RtJV"));
            List<WebElement> itemURL = pageContent.findElements(By.cssSelector("._3t7zg._2f4Ho"));
            List<WebElement> itemAd = pageContent.findElements(By.cssSelector("._3A0hz.gYJvK"));


            ArrayList<String> Titles = new ArrayList<String>();
            ArrayList<String> Prices = new ArrayList<String>();
            ArrayList<String> Images = new ArrayList<String>();
            ArrayList<String> Urls = new ArrayList<String>();
            ArrayList<String> Sponsored = new ArrayList<String>();

            for (int i = 0; i <= numOfItems; i++) {

                Item product = new Item();

                product.setTitle(itemTitle.get(i).getText());
                String productTitle = product.getTitle();
                Titles.add("\"" + productTitle + "\"");
                System.out.println(productTitle);

                product.setPrice(itemPrice.get(i).getText());
                String productPrice = product.getPrice();
                Prices.add(productPrice);
                System.out.println(productPrice);

                product.setImageUrl(itemImgURL.get(i).getAttribute("src"));
                String productImg = product.getImageUrl();
                Images.add(productImg);
                System.out.println(productImg);

                product.setItemUrl(itemURL.get(i).getAttribute("href"));
                String productUrl = product.getItemUrl();
                Urls.add(productUrl);
                System.out.println(productUrl);

                product.setSponsored(itemAd.get(i).getText().isEmpty() ? "Not Sponsored" : "Sponsored");
                String productAd = product.getSponsored();
                Sponsored.add(productAd);
                System.out.println(productAd);

            }


            ArrayList<String> Descriptions = new ArrayList<String>();
            for (int i = 0; i <= numOfItems; i++) {
                driver.navigate().to(Urls.get(i));
                jse.executeScript("scrollBy(0,500)");
                jse.executeScript("scrollBy(0,500)");
                Thread.sleep(2000);
                Descriptions.add(driver.findElement(By.cssSelector(".product-overview")).getText().isEmpty() ? "Description not available" : "\"" + driver.findElement(By.cssSelector(".product-overview")).getText() + "\"");
            }
            driver.close();
            driver.quit();
            PrintWriter dataFile = new PrintWriter("data.csv");
            dataFile.write("Id\tTitle\tItem URL\tPrice\tImage URL\tSponsored\tDescription\n");
            for (int i = 0; i <= numOfItems; i++) {
                dataFile.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\n", (i + 1), Titles.get(i), Urls.get(i), Prices.get(i), Images.get(i), Sponsored.get(i), Descriptions.get(i));
            }
            dataFile.close();

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}

