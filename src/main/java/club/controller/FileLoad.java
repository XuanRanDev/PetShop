package club.controller;

import club.config.FileConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.UUID;

@Controller
public class FileLoad {


    public static String uploadAdminPic(MultipartFile file) {
        String picName = UUID.randomUUID().toString().substring(1,8);

        //获取上传文件得元素得名称
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        //上传文件
        try {
            file.transferTo(new File(FileConfig.PROJECT_PATH + "/src/main/webapp/static/images/admin/" + picName + substring));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = picName + substring;

        return name;
    }

    public static String uploadUserPic(MultipartFile file) {
        String picName = UUID.randomUUID().toString().substring(1,8);
        //获取上传文件得元素得名称
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));

        //上传文件
        try {
            file.transferTo(new File(FileConfig.PROJECT_PATH + "/src/main/webapp/static/images/user/" + picName + substring));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return picName + substring;
    }

    public static String uploadPetPic(MultipartFile file) {
        String picName = UUID.randomUUID().toString().substring(1,8);
        //获取上传文件得元素得名称
        String fileName = file.getOriginalFilename();
        String substring = fileName.substring(fileName.lastIndexOf("."));

        CommonsMultipartFile file1 = new CommonsMultipartFile(null);
        BeanUtils.copyProperties(file, file1);
        //上传文件
        try {
            file.transferTo(new File(FileConfig.PROJECT_PATH + "/src/main/webapp/static/images/animal/" + picName + substring));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = picName + substring;

        return name;
    }

    public static void copyFile(File source,File d) {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
            byte[] bytes = inputStream.readAllBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(d));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            inputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
