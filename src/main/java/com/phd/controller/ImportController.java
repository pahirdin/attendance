package com.phd.controller;

import com.phd.service.IImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
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
}
