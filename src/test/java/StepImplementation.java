import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {
    private static Driver connector = new Driver();
    // private static String mobileBrowserType;
    private static String mobileUrl;

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

}
