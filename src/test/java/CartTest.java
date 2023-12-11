import org.testng.annotations.Test;

public class CartTest extends TestBase{

    @Test
    public void firstTest(){

        CartPage cartPage = new CartPage(driver);
        softAssert.assertTrue(cartPage.firstItemLinkIsDisplayed());
        softAssert.assertTrue(cartPage.firstItemLinkIsEnabled());

        cartPage.getPriceOfFirstProduct();
        cartPage.clickFirstItemLink();
        cartPage.selectValueOfProcessor(1);
        cartPage.getProcessorText();
        cartPage.selectValueOfRam(1);
        cartPage.clickSecondHddRadioButton();

        cartPage.getHddLabel();
        cartPage.clickSecondOsRadioButton();
        cartPage.getOsLabel();
        cartPage.selectFirstCheckBox();
        cartPage.selectSecondCheckBox();
        cartPage.getSecondCheckBoxLabel();
        softAssert.assertEquals(cartPage.getTotalAmountOfCart() + "0", cartPage.getTotalAmountOfCartText().replace("$", "").replace(",", ""));
        softAssert.assertEquals(cartPage.getTotalCartNumber(), "1");
        softAssert.assertAll();

    }
}
