package flash.thunder.school.test.echarts;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Administrator on 2018/10/18.
 */
@Controller
public class ExcelOutput {


    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/exceloutput")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        String[][] values={{"你好"},{"我好"},{"你好"},{"你好"}};

        //excel标题
        String[] title = {"名称", "性别", "年龄", "学校", "班级"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";


        //创建HSSFWorkbook
        HSSFWorkbook wb = this.getHSSFWorkbook(sheetName, title, values, null,request);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
                System.out.println("文件名字："+fileName);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb,HttpServletRequest request) throws IOException {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }


                                /*生成图表*/
        String imgUrl = request.getParameter("base64Info");
        if(!StringUtils.isEmpty(imgUrl)) {
            String[] imgUrlArr = imgUrl.split("base64,");//拆分base64编码后部分

            byte[] buffer = new BASE64Decoder().decodeBuffer(imgUrlArr[1]);
            String picPath = "C:\\Users\\Administrator\\Desktop\\pic" + ".png";
            File file = new File(picPath);//图片文件

            try {
                //生成图片
                OutputStream out = new FileOutputStream(file);//图片输出流
                out.write(buffer);
                out.flush();//清空流
                out.close();//关闭流
                ByteArrayOutputStream outStream = new ByteArrayOutputStream(); // 将图片写入流中
                BufferedImage bufferImg = ImageIO.read(new File(picPath));
                ImageIO.write(bufferImg, "PNG", outStream);
                // 利用HSSFPatriarch将图片写入EXCEL
                HSSFPatriarch patri = sheet.createDrawingPatriarch();
                HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 0, 15, (short) 6, 35);
                patri.createPicture(anchor, wb.addPicture(outStream.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (file.exists()) {
                file.delete();//删除图片
            }
        }

        return wb;
    }

}
