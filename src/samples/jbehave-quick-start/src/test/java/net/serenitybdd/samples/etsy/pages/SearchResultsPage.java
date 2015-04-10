package net.serenitybdd.samples.etsy.pages;

import com.google.common.base.Optional;
import net.serenitybdd.samples.etsy.features.model.ListingItem;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// tag::header[]
public class SearchResultsPage extends PageObject {
// end::header[]
// tag::searchByKeyword[]

    @FindBy(css=".listing-card")
    List<WebElement> listingCards;

    public List<String> getResultTitles() {
        return listingCards.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
// end::searchByKeyword[]
    public ListingItem selectItem(int itemNumber) {
        ListingItem selectedItem = convertToListingItem(listingCards.get(itemNumber - 1));
        listingCards.get(itemNumber - 1).findElement(By.tagName("a")).click();
        return selectedItem;
    }

    private ListingItem convertToListingItem(WebElement itemElement) {
        NumberFormat format = NumberFormat.getInstance();
        String price = itemElement.findElement(By.className("currency-value")).getText();

        try {
            return new ListingItem(itemElement.findElement(By.className("title")).getText(),
                                                           format.parse(price).doubleValue());
        } catch (ParseException e) {
            throw new AssertionError("Failed to parse item price: ",e);
        }
    }

    public void filterByType(String type) {
        confirmLocaleIfNecessary();
        withTimeoutOf(2, TimeUnit.SECONDS).find("#filter-marketplace").then(By.partialLinkText(type)).click();
    }

    private void confirmLocaleIfNecessary() {
        if (isElementVisible(By.id("locale-nag-confirm")) && isElementVisible(By.id("input[value='Okay']"))) {
            find(By.cssSelector("input[value='Okay']")).click();
            waitFor(ExpectedConditions.invisibilityOfElementLocated(By.id("locale-nag-confirm")));
        }
    }

    public int getItemCount() {
        String resultCount = $(".result-count").getText()
                .replace("We found ","")
                .replace(" item","")
                .replace("s","")
                .replace("!","")
                .replace(",","")
                ;
        return Integer.parseInt(resultCount);
    }

    public Optional<String> getSelectedType() {
        List<WebElementFacade> selectedTypes = findAll("#filter-marketplace a.selected");
        return (selectedTypes.isEmpty()) ? Optional.absent() : Optional.of(selectedTypes.get(0).getText());
    }
// tag::tail[]
}
// end:tail[]
