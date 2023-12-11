import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage extends BasePage{

    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*='/build-your-own-computer']")
    private WebElement firstItemLink;

    @FindBy(css = "div[data-productid=\"1\"] .add-info .prices span[class = 'price actual-price'")
    private WebElement priceOfFirstItem;

    @FindBy(css = "#product_attribute_1")
    private WebElement processorDropdown;

    @FindBy(css = "#product_attribute_2")
    private WebElement ramDropdown;

    @FindBy(css = "li[data-attr-value = '7'] #product_attribute_3_7")
    private WebElement hddRadioButton;

    @FindBy(css = "li[data-attr-value = '7'] label[for='product_attribute_3_7']")
    private WebElement hddRadioButtonLabel;

    @FindBy(css = "li[data-attr-value = '9'] #product_attribute_4_9")
    private WebElement osRadioButton;

    @FindBy(css = "li[data-attr-value = '9'] label[for='product_attribute_4_9']")
    private WebElement osRadioButtonLabel;

    @FindBy(css = "ul[data-attr='5'].option-list")
    private WebElement checkBoxesList;

    @FindBy(css = "li[data-attr-value='10'] #product_attribute_5_10")
    private WebElement firstSoftwareCheckBox;

    @FindBy(css = "li[data-attr-value='11'] #product_attribute_5_11")
    private WebElement secondSoftwareCheckBox;

    @FindBy(css = "li[data-attr-value='11'] label[for='product_attribute_5_11']")
    private WebElement secondSoftwareCheckBoxLabel;

    @FindBy(css = "#price-value-1")
    private WebElement totalAmountValue;

    @FindBy(css = "#product_enteredQuantity_1")
    private WebElement totalCartNumber;

    public void clickFirstItemLink(){
        firstItemLink.click();
    }
    public boolean firstItemLinkIsDisplayed(){
        return firstItemLink.isDisplayed();
    }
    public boolean firstItemLinkIsEnabled(){
        return firstItemLink.isEnabled();
    }

    public void selectValueOfProcessor(int index) {
        Select select = new Select(processorDropdown);
        select.selectByIndex(index);
    }

    public void selectValueOfRam(int index) {
        Select select = new Select(ramDropdown);
        select.selectByIndex(index);
    }

    public void clickSecondHddRadioButton(){
        hddRadioButton.click();
    }

    public void clickSecondOsRadioButton(){
        osRadioButton.click();
    }

    public void selectFirstCheckBox(){
        firstSoftwareCheckBox.click();
    }

    public void selectSecondCheckBox(){
        secondSoftwareCheckBox.click();
    }

    public String getPriceOfFirstProduct(){
        text1 = priceOfFirstItem.getText();
        return text1;
    }

    public String getProcessorText(){
        text2 = processorDropdown.getText();
        return text2;
    }
    public String getHddLabel(){
        text3 = hddRadioButtonLabel.getText();
        return text3;
    }

    public String getOsLabel(){
        text4 = osRadioButtonLabel.getText();
        return text4;
    }

    public String getSecondCheckBoxLabel(){
        text5 = secondSoftwareCheckBoxLabel.getText();
        return text5;
    }

    public double getTotalAmountOfCart(){
        text1 = text1.replace("$", "").replace(",", "");
        String text = text1 + text3 + text4 + text5;

        Pattern pattern = Pattern.compile("\\[\\+\\$(\\d{1,3}(?:,\\d{3})*(?:\\.\\d{2})?)\\]");
        Matcher matcher = pattern.matcher(text);

        double sum = 0.0;

        while (matcher.find()) {
            String dollarAmountStr = matcher.group(1).replaceAll(",", "");
            double dollarAmount = Double.parseDouble(dollarAmountStr);
            sum += dollarAmount;
        }
        return sum + Double.parseDouble(text1);
    }

    public String getTotalAmountOfCartText(){
        return totalAmountValue.getText();
    }

    public String getTotalCartNumber(){
        return totalCartNumber.getText();
    }

}
