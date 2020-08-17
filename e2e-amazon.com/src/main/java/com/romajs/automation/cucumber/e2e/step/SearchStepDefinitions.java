package com.romajs.automation.cucumber.e2e.step;

import com.romajs.automation.cucumber.e2e.page.HomePage;
import com.romajs.automation.cucumber.e2e.page.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {
    private final HomePage homePage = new HomePage();
    private Product product;

    @When("searches for {string}")
    public void andSearchesFor(final String value) {
        homePage.searchProduct(value);
    }

    @Then("verify that products result list is greater or equal than {int}")
    public void verifyProductsResultListIsGreaterOrEqualThan(final Integer greaterOrEqualThan) {
        assertThat(homePage.getProductsResultList().size(), greaterThanOrEqualTo(greaterOrEqualThan));
    }

    @When("looking for product with title containing {string}")
    public void lookingForProductWithTitleContaining(final String value) {
        this.product = null;
        for(final Product product: homePage.getProductsResultList()) {
            if(value.equals(product.getTitle())) {
                this.product = product;
            }
        }
        assertThat(this.product, is(notNullValue()));
    }

    @Then("verify that product price is {string}")
    public void verifyThatProductPrice(final String value) {
        final String productPrice = this.product.getPrice();
        assertThat(productPrice, containsString(value));
    }

}
