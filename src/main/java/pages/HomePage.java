package pages;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage() {
        page.navigate("https://www.myntra.com/");
    }

    public void navigateToMenTShirts() {
        page.navigate("https://www.myntra.com/men-tshirts");
    }
}
