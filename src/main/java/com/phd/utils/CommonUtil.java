package com.phd.utils;

import com.phd.entity.AdminInfo;
import com.phd.entity.ExcelData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.security.auth.login.LoginException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pahaied
 * @date 2019/12/31 15:42
 */
public class CommonUtil {

    public static String getUUID() {
        //最大支持1-9个集群机器部署
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if(hashCodeV < 0) {
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    public static List<List<Object>> getFileList(InputStream inputStream, String originalFilename) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = getWorkbook(inputStream, originalFilename);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }
    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream inStr, String fileName){
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        try {
            if (".xls".equals(fileType)) {
                workbook = new XSSFWorkbook(inStr);
            } else if (".xlsx".equals(fileType)) {
                workbook = new XSSFWorkbook(inStr);
            } else {
                throw new Exception("请上传excel文件！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }


      public static Integer getKey(HashMap<Integer,String> map, String value) {
        Integer key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for (Integer getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
          return key;
        //这个key肯定是最后一个满足该条件的key.
    }

    public static Boolean isTelNumber(String telNum) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (telNum.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(telNum);
            boolean isMatch = m.matches();
            if (isMatch) {
                return true;
            }else {
                return false;
            }
        }
    }


    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    }
