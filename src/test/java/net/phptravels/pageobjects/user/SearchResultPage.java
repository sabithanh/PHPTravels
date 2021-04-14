package net.phptravels.pageobjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResultPage extends UserBasePage {

    public static final String CSS_TOTAL_NUM_LISTING = "div.content-wrapper p.text-muted.post-heading";

    @FindBy(css = ".sidebar-wrapper.filter-wrapper")
    WebElement divFilterBlock;

    @FindBy(css = CSS_TOTAL_NUM_LISTING)
    WebElement txtTotalNumListing;

    @FindBy(css = "#filterResultCallapseOnMobile div.rating-icons div.custom-radio")
    WebElement starGradeList;

    @FindBy(css = "#filterResultCallapseOnMobile div.custom-checkbox")
    List<WebElement> hotelPropertyList;

    @FindBy(css = ".content-wrapper div.product-long-item-wrapper .product-long-item")
    List<WebElement> hotelList;

    @FindBy(css = "button#searchform")
    WebElement btnSearch;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getDivFilterBlock() {
        return divFilterBlock;
    }

    public void selectStarGrade(String starGrade) {
        WebElement element = starGradeList.findElement(By.cssSelector(".custom-ratting > label[for='" + starGrade + "']"));
        element.click();
    }

    public void selectPropertyType(String propertyType) {
        for (WebElement it : hotelPropertyList) {
            WebElement label = it.findElement(By.tagName("label"));
            if (propertyType.equals(label.getAttribute("for"))) {
                label.click();
            }
        }
    }

    public WebElement selectCheapestHotel() {
        Map<Integer, WebElement> priceMap = new HashMap<>();
        for (WebElement it : hotelList) {
            WebElement priceElement = it.findElement(By.cssSelector(".price .text-secondary"));
            int price = Integer.parseInt(priceElement.getText().replaceAll("\\D+", ""));
            priceMap.put(price, it);
        }

        Object[] prices = priceMap.keySet().toArray();
        Arrays.sort(prices);
        return priceMap.get((Integer) prices[0]);
    }

    public WebElement getTxtTotalNumListing() {
        return txtTotalNumListing;
    }

    public List<WebElement> getHotelList() {
        return driver.findElements(By.cssSelector(".content-wrapper div.product-long-item-wrapper > div.product-long-item"));
    }

    public void clickSearchButton() {
        btnSearch.click();
    }
}
