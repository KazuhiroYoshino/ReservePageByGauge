import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class VerifyImplementation {
    private static Driver connector = new Driver();
    private static String mobileUrl;
    private static String mobileBrowserType;
    private int termValue;
    private int termValueWeekEnd;

    @Step("合計金額は<price>となり")
    public void testPrice(String price) throws InterruptedException, MalformedURLException {
        String selector = "price";
        boolean res;

        res = connector.testPrice(selector, Integer.valueOf(price));
        if (res == true) {
            assertTrue(res);
        } else {
            // connector.destroySelenium();
            Thread.sleep(2000);
            connector.rebootBrowser(mobileBrowserType, mobileUrl);
            connector.setWindowMax();
            Thread.sleep(1000);
            connector.linkClickAndWait("宿泊予約");
            assertTrue(res);
        }
        Thread.sleep(1000);
    }

    @Step("宿泊期間の表示が正しく")
    public void testReserveTerm() throws InterruptedException {
        String selector = "term";

        try {
            assertTrue(connector.testTerm(selector, termValue + termValueWeekEnd));
        } catch (Exception e) {
            System.out.println(connector.dateFrom);
            System.out.println(connector.dateTo);
            // connector.destroySelenium();
        }
    }

    @Step("宿泊人数の表示が<headcount>名様となり")
    public void testHeadCount(String headcount) throws InterruptedException {
    	String selector = "//*[@id=\"hc\"]";

//    	headcount = "ご人数:" + headcount + "名様";
    	assertTrue(connector.testTextX(selector, headcount));
    }

    @Step("追加プランが<plan1>または<plan2>または<plan3>で正しく")
    public void testOption1(String plan1, String plan2, String plan3) throws InterruptedException {
    	String planText;

    	String selector1 = "//*[@id=\"bf_order\"]";
    	String selector2 = "//*[@id=\"plan_a_order\"]";
    	String selector3 = "//*[@id=\"plan_b_order\"]";

    	if((plan1.equals("off"))&&(plan2.equals("off"))&&(plan3.equals("off"))) {
    		planText = "なし";
    		assertTrue(connector.testTextX(selector1, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("off"))&&(plan3.equals("off"))) {
    		planText = "あり";
    		assertTrue(connector.testTextX(selector1, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("on"))&&(plan3.equals("off"))) {
    		planText = "昼からチェックインプラン";
    		assertTrue(connector.testTextX(selector2, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("off"))&&(plan3.equals("on"))) {
    		planText = "お得な観光プラン";
    		assertTrue(connector.testTextX(selector3, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("on"))&&(plan3.equals("off"))) {
    		planText = "あり";
    		assertTrue(connector.testTextX(selector1, planText));
    		planText = "昼からチェックインプラン";
    		assertTrue(connector.testTextX(selector2, planText));
    	}
    	if((plan1.equals("on"))&&(plan2.equals("off"))&&(plan3.equals("on"))) {
    		planText = "あり";
    		assertTrue(connector.testTextX(selector1, planText));
    		planText = "お得な観光プラン";
    		assertTrue(connector.testTextX(selector3, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("on"))&&(plan3.equals("on"))) {
    		planText = "昼からチェックインプラン";
    		assertTrue(connector.testTextX(selector2, planText));
    		planText = "お得な観光プラン";
    		assertTrue(connector.testTextX(selector3, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("on"))&&(plan3.equals("on"))) {
    		planText = "あり";
    		assertTrue(connector.testTextX(selector1, planText));
    		planText = "昼からチェックインプラン";
    		assertTrue(connector.testTextX(selector2, planText));
    		planText = "お得な観光プラン";
    		assertTrue(connector.testTextX(selector3, planText));
    	}

    }

    @Step("氏名の表示が<username>様となり")
    public void testUsername(String username) throws InterruptedException {
    	String selector = "guestname";

    	username = "お名前: " + username + " 様";
    	assertTrue(connector.testText(selector, username));
    }

    @Step("ポップアップ表示に<message>が表示され")
    public void testPopUp(String message1) throws InterruptedException {
    	String selector1 = "slide1";

    	assertTrue(connector.isTextPresent(message1));
    }

}
