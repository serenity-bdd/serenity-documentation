package net.serenity_bdd.samples.etsy.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/shopping_cart/adding_items_to_the_shopping_cart.feature")
public class AddingItemsToTheShoppingCart {}
