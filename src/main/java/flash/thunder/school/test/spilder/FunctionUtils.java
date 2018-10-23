package flash.thunder.school.test.spilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/10/22.
 */
public class FunctionUtils
{

    /**
     * 匹配超链接的正则表达式
     */
    private static String pat = "[\\w\\W]*";
    private static Pattern pattern = Pattern.compile(pat);

    private static BufferedWriter writer = null;

    /**
     * 爬虫搜索深度
     */
    public static int depth = 0;

    /**
     * 以"/"来分割URL,获得超链接的元素
     *
     * @param url
     * @return
     */
    public static String[] divUrl(String url)
    {
        return url.split("/");
    }

    /**
     * 判断是否创建文件
     *
     * @param url
     * @return
     */
    public static boolean isCreateFile(String url)
    {
        Matcher matcher = pattern.matcher(url);
        System.out.println("是否符合下载："+matcher.matches());
        return matcher.matches();
    }

    /**
     * 创建对应文件
     *
     * @param content
     * @param urlPath
     */
    public static void createFile(String content, String urlPath)
    {
        /* 分割url */
        String[] elems = divUrl(urlPath);
        StringBuffer path = new StringBuffer();

        File file = null;
        for (int i = 1; i < elems.length; i++)
        {
            if (i != elems.length - 1)
            {

                path.append(elems[i]);
                path.append(File.separator);
                file = new File("D:" + File.separator + path.toString());

            }

            if (i == elems.length - 1)
            {
                Pattern pattern = Pattern.compile("[\\w\\W]*");
                Matcher matcher = pattern.matcher(elems[i]);
                if ((matcher.matches()))
                {
                    if (!file.exists())
                    {
                        file.mkdirs();
                    }
                    String fileName = elems[i];
                    file = new File("C:\\Users\\Administrator\\Desktop\\" + fileName.substring(0,4) + "_2018.html");
                    System.out.println("文件存储路径为："+"C:\\Users\\Administrator\\Desktop\\"
                            + fileName.substring(0,4) + "_2018.html");
                    try
                    {
                        file.createNewFile();
                        writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(file),"utf-8"));
                        writer.write(content);
                        writer.flush();
                        writer.close();
                        System.out.println("创建文件成功");
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }


                    //处理文件内容
                    System.out.println("文件处理开始---------------");
                    File input = new File("C:\\Users\\Administrator\\Desktop\\" + fileName.substring(0,4) + "_2018.html");
                    Document doc = null;
                    try {
                        doc = Jsoup.parse(input,"UTF-8","http://www.oschina.net/"); //这里后面加了网址是为了解决后面绝对路径和相对路径的问题
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Elements table = doc.select(".lin-seachtable");
                    Element childrens = table.get(0);
                    for (int j = 0; j<childrens.childNodes().size(); j++){
                        if (childrens.childNodes().get(j).attributes().hasKey("comment")){
                            String s=childrens.childNodes().get(j).attributes().get("comment");

                            Matcher m=Pattern.compile("<td>[\\S\\s]*</td>").matcher(s);
                            while (m.find()) {
                                System.out.println("数据："+m.group());
                            }
                        }
                    }
                    System.out.println("文件处理结束---------------");
                }
            }

        }
    }

    /**
     * 获取页面的超链接并将其转换为正式的A标签
     *
     * @param href
     * @return
     */
    public static String getHrefOfInOut(String href)
    {
        /* 内外部链接最终转化为完整的链接格式 */
        String resultHref = null;

        /* 判断是否为外部链接 */
        if (href.startsWith("http://"))
        {
            resultHref = href;
        } else
        {
            /* 如果是内部链接,则补充完整的链接地址,其他的格式忽略不处理,如：a href="#" */
            if (href.startsWith("/"))
            {
                resultHref = "http://www.oschina.net" + href;
            }
        }

        return resultHref;
    }

    /**
     * 截取网页网页源文件的目标内容
     *
     * @param content
     * @return
     */
    public static String getGoalContent(String content)
    {
        int sign = content.indexOf("<html");
        String signContent = content.substring(sign);

        int start = signContent.indexOf("<html");
        int end = signContent.indexOf("</html>");

        return signContent.substring(start , end+7);
    }

    /**
     * 检查网页源文件中是否有目标文件
     *
     * @param content
     * @return
     */
    public static int isHasGoalContent(String content)
    {
        return content.indexOf("<");
    }

}
