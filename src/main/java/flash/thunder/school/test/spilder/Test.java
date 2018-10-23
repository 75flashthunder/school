package flash.thunder.school.test.spilder;

import java.sql.SQLException;

/**
 * Created by Administrator on 2018/10/22.
 */
public class Test
{
    public static void main(String[] args) throws SQLException
    {
//        String url = "https://gkcx.eol.cn/soudaxue/queryschool.html?&page=3";
        String url = "https://data-gkcx.eol.cn/soudaxue/queryschool.html?messtype=jsonp&callback=jQuery18309879958805360824_1540193927058&province=&schooltype=&page=1&size=50&keyWord1=&schoolprop=&schoolflag=&schoolsort=&schoolid=&_=1540193927328";

        UrlQueue.addElem(url);

        UrlDataHanding[] url_Handings = new UrlDataHanding[10];

        for(int i = 0 ; i < 10 ; i++)
        {
            url_Handings[i] = new UrlDataHanding();
            new Thread(url_Handings[i]).start();
        }

    }
}
