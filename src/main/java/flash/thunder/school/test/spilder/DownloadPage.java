package flash.thunder.school.test.spilder;

import flash.thunder.school.test.spilder.DAO.SchoolDAO;
import flash.thunder.school.test.spilder.Entity.School;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/22.
 */
@SuppressWarnings("deprecation")
@Component
public class DownloadPage {


    @Autowired
    private SchoolDAO schoolDAO;

    /**
     * 根据URL抓取网页内容
     *
     * @param url
     * @return
     */
    public String getContentFormUrl(String url)
    {
         /* 实例化一个HttpClient客户端 */
        @SuppressWarnings({"resource"})
//        HttpClient client = new DefaultHttpClient();
//        HttpGet getHttp = new HttpGet(url);
//
        String content = null;
//
//        HttpResponse response;
        try
        {
//             /*获得信息载体*/
//            response = client.execute(getHttp);
//            HttpEntity entity = response.getEntity();
//
//            VisitedUrlQueue.addElem(url);
//
//            if (entity != null)
//            {
                 /* 转化为文本信息 */
//                content = EntityUtils.toString(entity,"UTF-8");
                content = sendGet(url,null);
                 /* 判断是否符合下载网页源代码到本地的条件 */
                if (FunctionUtils.isCreateFile(url))
                //&& FunctionUtils.isHasGoalContent(content) != -1
                {
//                    FunctionUtils.createFile(FunctionUtils.getGoalContent(content), url);
                    int a=content.indexOf("{");
                    createExcel("C:\\Users\\Administrator\\Desktop\\first.xls",content.substring(a));
                }

//            }

        } finally
        {
//            client.getConnectionManager().shutdown();
        }

        return content;
    }

    /**
     * 模拟浏览器请求
     * @param url
     * @param param
     * @return
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Referer", "https://gkcx.eol.cn/soudaxue/queryschool.html?&page=3");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                System.out.println(s + "-->" + map.get(s));
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public JSONObject createExcel(String src, String json) {

        JSONObject result = new JSONObject(json); // 用来反馈函数调用结果

        try {
            // 新建文件  
            File file = new File(src);
            file.createNewFile();
            OutputStream os = new FileOutputStream(file);// 创建工作薄  

            HSSFWorkbook wb=new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("First sheet");
            HSSFRow row = sheet.createRow(0);

            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            //声明列对象
            JSONArray jsonArray = result.getJSONArray("school");// 得到school对应的JSONArray

            // 将第一行信息加到页中。如：姓名、年龄、性别  
            JSONObject first = jsonArray.getJSONObject(0);
            Iterator<String> iteFirst = first.keys(); // 得到第一项的key集合  
            int a=0;
            while (iteFirst.hasNext()) { // 遍历key集合  
                String key = iteFirst.next(); // 得到key  
                //将内容按顺序赋给对应的列对象
                row.createCell(a++).setCellValue(key);
            }


//            for (int i = 0; i < jsonArray.length(); i++) {
//                row = sheet.createRow(i + 1);
//                //将内容按顺序赋给对应的列对象
//                row.createCell(0).setCellValue(jsonArray.get(i).toString());
//            }

            List<School> schoolList=new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                row = sheet.createRow(i + 1);
                JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项  
                Iterator iterator = item.keys(); // 得到key集合  
                int column = 0;// 从第0列开始放  
                School schooltemp=new School();
                while (iterator.hasNext()) {
                    Object key = iterator.next(); // 得到key  

                    Object value = item.get(key.toString()); // 得到key对应的value  
                    dealData(schooltemp,key,value);

                    //将内容按顺序赋给对应的列对象
                    row.createCell(column++).setCellValue(value.toString());
//                    System.out.println("数据：++++++++++++++++++"+value);
                }
                schoolList.add(schooltemp);
            }

            schoolList.forEach(sch->{
                schoolDAO.insert(sch);
            });



            wb.write(os);
            os.flush();
            os.close();

        } catch (Exception e) {

            System.out.println("reason:"+ e.getMessage());

            result.put("result", "failed"); // 将调用该函数的结果返回  

            result.put("reason", e.getMessage()); // 将调用该函数失败的原因返回  

            return result;

        }

        result.put("result", "successed");

        return result;

    }

    private static void dealData(School school,Object key,Object value){
        if(key.equals("f211")){
            school.setFlag211(Integer.parseInt(value.toString()));
        }
        if(key.equals("guanwang")){
            school.setOfficialNetwork(value.toString());
        }
        if(key.equals("membership")){
            school.setMembership(value.toString());
        }
        if(key.equals("jianjie")){
            school.setBrief(value.toString());
        }
        if(key.equals("province")){
            school.setProvince(value.toString());
        }
        if(key.equals("shoufei")){
            school.setCharge(value.toString());
        }
        if(key.equals("ranking")){
            school.setRanking(Integer.parseInt(value.toString()));
        }
        if(key.equals("schoolnature")){
            school.setSchoolNature(value.toString());
        }
        if(key.equals("oldname")){
            school.setOldName(value.toString());
        }
        if(key.equals("level")){
            school.setLevel(value.toString());
        }
        if(key.equals("autonomyrs")){
            school.setAutonomyrs(Integer.parseInt(value.toString()));
        }
        if(key.equals("firstrate")){
            school.setFirsyrate(value.toString());
        }
        if(key.equals("schoolname")){
            school.setSchoolName(value.toString());
        }
        if(key.equals("schoolproperty")){
            school.setSchoolProperty(value.toString());
        }
        if(key.equals("schooltype")){
            school.setSchoolType(value.toString());
        }
        if(key.equals("f985")){
            school.setFlag985(Integer.parseInt(value.toString()));
        }
    }

}

