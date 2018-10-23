package flash.thunder.school.test.service;

import flash.thunder.school.test.spilder.DownloadPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/23.
 */
@Service
public class TestService {

    @Autowired
    private DownloadPage downloadPage;

    public void spider(){
        for(int i=1;i<61;i++){
            String url = "https://data-gkcx.eol.cn/soudaxue/queryschool.html?messtype=jsonp&callback=jQuery18309879958805360824_1540193927058&province=&schooltype=&" +
                    "page="+i+"&size=50&keyWord1=&schoolprop=&schoolflag=&schoolsort=&schoolid=&_=1540193927328";
            downloadPage.getContentFormUrl(url);
        }


//        UrlQueue.addElem(url);
//
//        UrlDataHanding[] url_Handings = new UrlDataHanding[10];

//        for(int i = 0 ; i < 10 ; i++)
//        {
//            url_Handings[i] = new UrlDataHanding();
//            new Thread(url_Handings[i]).start();
//        }

    }
}
