package com.xinktech.api.apiResource;

import com.xinktech.api.commom.ApiResult;
import com.xinktech.api.commom.ExcelUtil;
import com.xinktech.api.domain.XmlInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@RestController
@RequestMapping("/xinktech/api")
public class EmokitApiResource {

    @Value("${filePath}")
    String filePath;
    @Value("${xlsFileName}")
    String xlsFileName;
    @PostMapping("/emokitData")

    public ApiResult saveEmokitData(MultipartHttpServletRequest request, XmlInfo xmlInfo){
        if(!request.getFileNames().hasNext())
            return ApiResult.failed("上传文件为空");
        MultipartFile multipartFile=request.getFile(request.getFileNames().next());
        if(!ExcelUtil.fileExist(filePath+xlsFileName)){
            String[]list = {"filepath","xmin","xmax","ymin","ymax","calm","confused","sad","angry","happy","fear","disgust"};
            try {
                ExcelUtil.createExcel(filePath+xlsFileName,"emokitData",list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            String fileName =multipartFile.getOriginalFilename();
            String newFileName = fileName.substring(0,fileName.lastIndexOf("."))+"_"+System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
            File dic = new File(filePath+fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()));
            if(!dic.exists())dic.mkdir();
            String newFilePath = filePath+fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())+ File.separator+newFileName;
            List<Map> info= new LinkedList<>();
            Map map = xmlInfo.getXmlInfo();
            map.put("filepath",newFilePath);
            map.remove("filename");
            info.add(map);
            ExcelUtil.writeToExcel(filePath+xlsFileName,"emokitData",info);
            FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(newFilePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResult.success("上传成功");
    }
}