package com.phd.controller;

import com.phd.constant.ExcelConstant;
import com.phd.entity.AdminInfo;
import com.phd.entity.College;
import com.phd.entity.ExcelData;
import com.phd.service.ICommomService;
import com.phd.service.IImportService;
import com.phd.service.ISystemSetupService;
import com.phd.utils.CommonUtil;
import com.phd.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * @author pahaied
 * @date 2019/12/30 9:42
 */
@Controller
public class ImportController {

    @Autowired
    private IImportService importServiceImpl;
    @Autowired
    private ICommomService commomServiceImpl;


    /**
     * 管理员管理页面 上传文件新增管理员信息
     * @param request request
     * @return 返回map 成功或失败数据
     * @throws Exception 错误
     */
    @RequestMapping("/addadmin")
    @ResponseBody
    public Map<String,Object> uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("file");
        //生成流水号
        String recordId = CommonUtil.getUUID();
        if (file != null && file.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("allerro","0");
            map.put("code","0");
            return map;
        }

        InputStream inputStream = file != null ? file.getInputStream() : null;
        Map<String,Object> param = importServiceImpl.getAdminListByExcel(inputStream, file.getOriginalFilename(),recordId);
        if (inputStream != null) {
            inputStream.close();
        }

        param.put("code","0");
        param.put("data","");
        param.put("msg","");
        return param;

    }

    /**
     * 学生信息管理页面-批量新增学生信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/addStudent")
    @ResponseBody()
    public Map<String,Object> addStudent(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        //生成流水号
        String recordId = CommonUtil.getUUID();
        if (file != null && file.isEmpty()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("allerro","0");
            map.put("code","0");
            return map;
        }
        InputStream inputStream = file != null ? file.getInputStream() : null;
        Map<String,Object> param = importServiceImpl.getStudentListByExcel(inputStream, file.getOriginalFilename(),recordId);
        if (inputStream != null) {
            inputStream.close();
        }

        param.put("code","0");
        param.put("data","");
        param.put("msg","");
        return param;
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

    @RequestMapping("/geterror")
    public void test2(HttpServletResponse response,String recordid){
        recordid = recordid == null ? "0000000000000000" : recordid;
//        ExcelData data = getExcelData();
        ExcelData data = importServiceImpl.getExcelData(recordid);
        try{
            ExcelUtils.exportExcel(response,"错误【ERROR】",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
