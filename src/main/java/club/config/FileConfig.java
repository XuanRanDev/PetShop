package club.config;

import org.springframework.stereotype.Component;

/**
 * 这个类配置了项目的图片路径，请根据项目实际位置修改，否则上传图片会出现错误
 */
@Component
public class FileConfig {
    public static final String PROJECT_PATH = "E:\\IDEA_Project\\YYR\\PetShop";
}
