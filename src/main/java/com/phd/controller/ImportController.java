package com.phd.controller;

import com.phd.constant.ExcelConstant;
import com.phd.entity.AdminInfo;
import com.phd.entity.ExcelData;
import com.phd.service.ICommomService;
import com.phd.service.IImportService;
import com.phd.service.ISystemSetupService;
import com.phd.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pahaied
 * @date 2019/12/30 9:42
 */
@Controller
public class ImportController {

    @Autowired
    private IImportService importServiceImpl;


    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,String> uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("file");
        HashMap<String, String> map = new HashMap<>();
        if (file.isEmpty()) {
            map.put("msg","失败");
        }
        map.put("msg","成功");
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importServiceImpl.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();

        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            //TODO 随意发挥
            System.out.println(lo);

        }
        map.put("code","0");
        map.put("data","");
        return map;

    }


//    @RequestMapping("/test")
//    public  RetResult<Integer> test(){
//        int rowIndex = 0;
//        List<UserInfo> list = userInfoService.selectAlla(0, 0);
//        ExcelData data = new ExcelData();
//        data.setName("hello");
//        List<String> titles = new ArrayList();
//        titles.add("ID");
//        titles.add("userName");
//        titles.add("password");
//        data.setTitles(titles);
//
//        List<List<Object>> rows = new ArrayList();
//        for(int i = 0, length = list.size();i<length;i++){
//            UserInfo userInfo = list.get(i);
//            List<Object> row = new ArrayList();
//            row.add(userInfo.getId());
//            row.add(userInfo.getUserName());
//            row.add(userInfo.getPassword());
//            rows.add(row);
//        }
//        data.setRows(rows);
//        try{
//            rowIndex = ExcelUtils.generateExcel(data, ExcelConstant.FILE_PATH + ExcelConstant.FILE_NAME);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return RetResponse.makeOKRsp(Integer.valueOf(rowIndex));
//    }

    @RequestMapping("/test2")
    public void test2(HttpServletResponse response){
//        ExcelData data = getExcelData();
        ExcelData data = importServiceImpl.getExcelData();
        try{
            ExcelUtils.exportExcel(response,"aaaaaaa",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
