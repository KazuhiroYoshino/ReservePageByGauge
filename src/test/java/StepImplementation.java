import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class StepImplementation {
    private static Driver connector = new Driver();
    // private static String mobileBrowserType;
    private static String mobileUrl;
    private int weekEnd;
    private int termValue;
    private int termValueWeekEnd;
    private String contactType;
    private static String mobileBrowserType;

    @Step("ページ<url>を表示する")
    public void display_url(String url) throws InterruptedException {
        mobileUrl = url;
        connector.openAndWait(url);
    }

    @Step("Windowを最大化する")
    public void window_maximized() throws InterruptedException {
        connector.setWindowMax();
    }

    @Step("ブラウザを英語モードにする")
    public void englishMode() {
        // DriverFactory.setLangEnglish();
    }

    @Step("ブラウザを日本語モードにする")
    public void japaneseMode() {
        // connector.setlangJapanese();
    }

    @Step("画面更新")
    public void refresh() throws InterruptedException {
        connector.refresh();
    }

    @Step("シナリオを終了してブラウザを閉じる")
    public void close() {
        // connector.destroySelenium();
    }

    @Step("<sec>秒待つ")
    public void wait(int sec) {
        connector.sleep(sec);
    }

    @Step("親子タブを取得する")
    public void parentAndChild() {
        connector.setWindow();
    }

    @Step("親タブに切り替える")
    public void parent() {
        connector.setParent();
    }

    @Step("子タブに切り替える")
    public void child() {
        connector.setChild();
    }

    @Step("宿泊初日の曜日を<startDay>として")
    public void fromDay(String startDay) throws InterruptedException {
        String selector = "datePick";

        switch (startDay) {
            case ("Sunday"):
                connector.sunday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Monday"):
                connector.monday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Tuesday"):
                connector.tuesday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Wednesday"):
                connector.wednesday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Thursday"):
                connector.thursday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Friday"):
                connector.friday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            case ("Saturday"):
                connector.saturday(selector);
                weekEnd = 0;
                connector.dateFromSet();
                break;
            default:
        }

        // String commandLocater2 = "//div[@id='ui-datepicker-div']/div[2]/button";
        // connector.btnClickAndWait_X(commandLocater2);
    }

    @Step("連泊数選択をクリックして")
    public void termClick() throws InterruptedException {
        String selector = "reserve_term";
        connector.btnClickAndWait_ID(selector);
    }

    @Step("連泊数を<termText>にして")
    public void termSetting(String termText) throws InterruptedException {
        String selector = "reserve_term";

        termValue = Integer.valueOf(termText) - weekEnd;
        termValueWeekEnd = weekEnd;
        int term = termValue + termValueWeekEnd;
        connector.dropDownSelect(selector, termText);
        connector.termSet(term);
    }

    @Step("宿泊人数を<headText>にして")
    public void headSetting(String headText) throws InterruptedException {
        String selector = "headcount";

        connector.headCountValue = Integer.valueOf(headText);
        connector.dropDownSelect(selector, headText);
    }

    @Step("朝食バイキング有無を<breakfast>にして")
    public void breakFastSetting(String breakfast) throws InterruptedException {
        String selector = null;

        switch (breakfast) {
            case ("on"):
                selector = "breakfast_on";
                break;
            case ("off"):
                selector = "breakfast_off";
                break;
            default:
        }

        connector.btnClickAndWait_ID(selector);
    }

    @Step("昼からチェックインプランを<earlyset>にして")
    public void earlySetting(String earlyset) throws InterruptedException {
        String selector = "plan_a";

        connector.checkBoxClick(selector, earlyset);
    }

    @Step("お得な観光プランを<seeing>にして")
    public void sightSeeingSetting(String seeing) throws InterruptedException {
        String selector = "plan_b";

        connector.checkBoxClick(selector, seeing);
    }

    @Step("氏名を<name>として")
    public void nameSetting(String name) throws InterruptedException {
        String selector = "guestname";

        if (name.length() != 0) {
            connector.inputAndWait(selector, name);
        }
    }

    @Step("予約内容を記録して")
    public void reserveRec() throws InterruptedException {
        String selector1 = "guestname";

        contactType = connector.getReserveUser(selector1);

    }

    @Step("利用規約に同意して次へボタンをクリックする")
    public void confirmReserveButton() throws InterruptedException {
        String selector = "agree_and_goto_next";

        connector.btnClickAndWait_ID(selector);
    }

    @Step("確定ボタンをクリックする")
    public void clickReserveButton() throws InterruptedException {
        String selector = "commit";

        connector.btnClickAndWait_ID(selector);
    }

    @Step("HOMEボタンをクリックする")
    public void toHome() throws InterruptedException {
        String linkText = "Home";

        connector.linkClickAndWait(linkText);
        ;
    }

}
