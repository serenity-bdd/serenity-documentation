package net.serenity_bdd.samples.etsy.pages;

import net.serenity_bdd.samples.etsy.features.model.ListingItem;
import net.serenity_bdd.samples.etsy.features.model.OrderCostSummary;
import net.thucydides.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by john on 12/11/14.
 */
public class CartPage extends PageObject {

    public List<OrderCostSummary> getOrderCostSummaries() {
        return findAll(".order-wrapper")
                .stream()
                .map(CartPage::convertToOrderCostSummary)
                .collect(Collectors.toList());
    }

    public Optional<OrderCostSummary> getOrderCostSummaryFor(ListingItem selectedItem) {
        return getOrderCostSummaries()
                .stream()
                .filter(item -> item.getName().equals(selectedItem.getName()))
                .findFirst();
    }

    public static OrderCostSummary convertToOrderCostSummary(WebElementFacade summaryElement) {
        String name = summaryElement.find(net.serenitybdd.core.annotations.findby.By.tagName("h3")).getText();

        NumberFormat format = NumberFormat.getInstance();

        String itemTotalPrice = summaryElement.findBy(".item-total .currency-value").getText();
        String shippingPrice = summaryElement.findBy(".shipping .currency-value").getText();
        String grandTotalPrice = summaryElement.findBy(".grand-total .currency-value").getText();

        double itemTotal = 0;
        double shipping = 0;
        double grandTotal = 0;
        try {
            itemTotal = format.parse(itemTotalPrice).doubleValue();
            shipping = format.parse(shippingPrice).doubleValue();
            grandTotal = format.parse(grandTotalPrice).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new OrderCostSummary(name, itemTotal, shipping, grandTotal);
    }

}
