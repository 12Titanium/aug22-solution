package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.TShirt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TShirtsPage {

    private Page page;
    private final Locator BRAND_FILTER_BUTTON;
    private final Locator BRAND_FILTER_INPUT;
    private final Locator BRAND_FILTER_LINK;
    private final Locator DISCOUNT_LINK;


    public TShirtsPage(Page page) {
        this.page = page;
        this.BRAND_FILTER_BUTTON = page.locator(".brand-container .filter-search-filterSearchBox");
        this.BRAND_FILTER_INPUT = page.locator("input[placeholder='Search for Brand']");
        this.BRAND_FILTER_LINK = page.locator(".brand-list li label");
        this.DISCOUNT_LINK = page.locator(".discount-list li label");
    }

    public void filterByBrand(String brand) {
        this.BRAND_FILTER_BUTTON.click();
        this.BRAND_FILTER_INPUT.fill(brand);
        this.page.press("input[placeholder='Search for Brand']", "Enter");
        this.BRAND_FILTER_LINK.first().click();
    }

    public void filterForDiscountedTShirts() {
        this.DISCOUNT_LINK.first().click();
    }

    /**
     * Change price in format 'Rs. 602' to 602
     *
     * @param text price scraped from the page
     * @return price number value
     */
    private int extractPriceNumberFromPriceText(String text) {
        String[] parts = text.split(" ");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    /**
     * Change discount in format '(41% OFF)' to 41
     *
     * @param text discount scraped from the page
     * @return discount number value
     */
    private int extractDiscountNumberFromDiscountText(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void extractTShirtDataAndPrintSortedByDiscount() {
        final List<TShirt> tShirts = new ArrayList<>();

        final List<ElementHandle> priceElements = this.page.querySelectorAll(".product-discountedPrice");
        final List<ElementHandle> linkElements = this.page.querySelectorAll(".product-base a");
        final List<ElementHandle> discountElements = this.page.querySelectorAll(".product-discountPercentage");

        for (int i = 0; i < priceElements.size(); i++) {
            String link = linkElements.get(i).getAttribute("href");
            int price = extractPriceNumberFromPriceText(priceElements.get(i).innerText());
            int discount = extractDiscountNumberFromDiscountText(discountElements.get(i).innerText());

            tShirts.add(new TShirt(link, discount, price));
        }

        Collections.sort(tShirts); // Sort the list
        Collections.reverse(tShirts); // Reverse the list to get descending order by discount
        tShirts.forEach(System.out::println);
    }
}
