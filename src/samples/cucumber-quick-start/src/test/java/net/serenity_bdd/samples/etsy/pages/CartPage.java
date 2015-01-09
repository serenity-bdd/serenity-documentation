package net.serenity_bdd.samples.etsy.pages;

import net.serenity_bdd.samples.etsy.features.model.ListingItem;
import net.serenity_bdd.samples.etsy.features.model.OrderCostSummary;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by john on 12/11/14.
 */
public class CartPage extends PageObject {

    private static ListingItem costSummaryToListingItem(OrderCostSummary orderCostSummary) {
        return new ListingItem(orderCostSummary.getName(), orderCostSummary.getItemTotal());
    }

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
        String name = summaryElement.find(By.tagName("h3")).getText();
        double itemTotal = Double.parseDouble(summaryElement.findBy(".item-total .currency-value").getText());
        double shipping = Double.parseDouble(summaryElement.findBy(".shipping .currency-value").getText());
        double grandTotal = Double.parseDouble(summaryElement.findBy(".grand-total .currency-value").getText());
        return new OrderCostSummary(name, itemTotal, shipping, grandTotal);
    }
}
