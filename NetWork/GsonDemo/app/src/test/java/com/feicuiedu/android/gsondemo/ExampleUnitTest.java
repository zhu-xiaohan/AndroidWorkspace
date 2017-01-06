package com.feicuiedu.android.gsondemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect()  {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test1() {
        String str = "{\"data\":{\"player\":[{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0}],\"promote_goods\":[{\"id\":\"77\",\"name\":\"\\u9759\\u66fc\\u513f\\u65b0\\u6b3e\\u8fde\\u8863\\u88d9\\u9488\\u7ec7\\u886b\\u4e24\\u4ef6\\u5957\\u957f\\u8896\\u5957\\u5934\\u534a\\u9ad8\\u9886\\u6bdb\\u8863+\\u767e\\u8936\",\"market_price\":\"\\uffe5175\\u5143\",\"shop_price\":\"\\uffe5146\\u5143\",\"promote_price\":\"\\uffe5100\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/77_thumb_G_1480507560317.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/77_G_1480507560205.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/77_G_1479972580628.jpg\"}},{\"id\":\"76\",\"name\":\"cachecache \\u97e9\\u7248\\u65f6\\u5c1aV\\u9886\\u767e\\u8936\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5247\\u5143\",\"shop_price\":\"\\uffe5206\\u5143\",\"promote_price\":\"\\uffe5158\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/76_thumb_G_1480507560730.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/76_G_1480507560603.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/76_G_1479971999537.jpg\"}},{\"id\":\"74\",\"name\":\"betu\\u767e\\u56fe\\u4fee\\u8eab\\u663e\\u7626\\u767e\\u8936\\u88d9 \\u80cc\\u5fc3\\u88d9 \\u5706\\u9886\\u65e0\\u8896\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5190\\u5143\",\"shop_price\":\"\\uffe5158\\u5143\",\"promote_price\":\"\\uffe5120\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/74_thumb_G_1480507560932.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/74_G_1480507560471.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/74_G_1479971689464.jpg\"}},{\"id\":\"75\",\"name\":\"betu\\u767e\\u56fe\\u767e\\u8936\\u683c\\u5b50\\u77ed\\u88d9 \\u4e03\\u5206\\u8896\\u8377\\u53f6\\u9886\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5202\\u5143\",\"shop_price\":\"\\uffe5168\\u5143\",\"promote_price\":\"\\uffe5148\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/75_thumb_G_1480507560948.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/75_G_1480507560921.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/75_G_1479971816944.jpg\"}}]},\"status\":{\"succeed\":1}}";


        Map<String,Map<String,Object>> map = new Gson().fromJson(str,
                new TypeToken<Map<String,Map<String,Object>>>() {
        }.getType());

        System.out.println((map.get("data")).get("player").toString());

    }

    @Test
    public void test2() {

        String str = "{\"data\":{\"player\":[{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201pyadkl.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ansxot.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201ecmcps.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201seisfo.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0},{\"photo\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/data\\/afficheimg\\/20161201qifytg.jpg\"},\"url\":\"http:\\/\\/\",\"description\":\"\",\"action\":\"\",\"action_id\":0}],\"promote_goods\":[{\"id\":\"77\",\"name\":\"\\u9759\\u66fc\\u513f\\u65b0\\u6b3e\\u8fde\\u8863\\u88d9\\u9488\\u7ec7\\u886b\\u4e24\\u4ef6\\u5957\\u957f\\u8896\\u5957\\u5934\\u534a\\u9ad8\\u9886\\u6bdb\\u8863+\\u767e\\u8936\",\"market_price\":\"\\uffe5175\\u5143\",\"shop_price\":\"\\uffe5146\\u5143\",\"promote_price\":\"\\uffe5100\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/77_thumb_G_1480507560317.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/77_G_1480507560205.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/77_G_1479972580628.jpg\"}},{\"id\":\"76\",\"name\":\"cachecache \\u97e9\\u7248\\u65f6\\u5c1aV\\u9886\\u767e\\u8936\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5247\\u5143\",\"shop_price\":\"\\uffe5206\\u5143\",\"promote_price\":\"\\uffe5158\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/76_thumb_G_1480507560730.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/76_G_1480507560603.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/76_G_1479971999537.jpg\"}},{\"id\":\"74\",\"name\":\"betu\\u767e\\u56fe\\u4fee\\u8eab\\u663e\\u7626\\u767e\\u8936\\u88d9 \\u80cc\\u5fc3\\u88d9 \\u5706\\u9886\\u65e0\\u8896\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5190\\u5143\",\"shop_price\":\"\\uffe5158\\u5143\",\"promote_price\":\"\\uffe5120\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/74_thumb_G_1480507560932.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/74_G_1480507560471.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/74_G_1479971689464.jpg\"}},{\"id\":\"75\",\"name\":\"betu\\u767e\\u56fe\\u767e\\u8936\\u683c\\u5b50\\u77ed\\u88d9 \\u4e03\\u5206\\u8896\\u8377\\u53f6\\u9886\\u8fde\\u8863\\u88d9\",\"market_price\":\"\\uffe5202\\u5143\",\"shop_price\":\"\\uffe5168\\u5143\",\"promote_price\":\"\\uffe5148\\u5143\",\"brief\":\"\",\"img\":{\"small\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/thumb_img\\/75_thumb_G_1480507560948.jpg\",\"thumb\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/goods_img\\/75_G_1480507560921.jpg\",\"url\":\"http:\\/\\/106.14.32.204\\/eshop\\/images\\/201611\\/source_img\\/75_G_1479971816944.jpg\"}}]},\"status\":{\"succeed\":1}}";

        TestObj t = new Gson().fromJson(str,TestObj.class);
        System.out.println(t.getStatus().getSucceed());
    }


    @Test
    public void test3() {
        String str = "[1,2,3]";

        List<String> list = new Gson().fromJson(str,
                new TypeToken<List<String>>() {
                }.getType());

        System.out.println(list);
    }

    @Test
    public void test4() {
        String str = "[1,2,3]";

        try {
            JSONArray jsonArray = new JSONArray(str);

            for (int i = 0; i < jsonArray.length(); i++) {
                String s = (String) jsonArray.get(i);
                System.out.println(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}