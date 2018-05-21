/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PicturesUploadProperties
 * Author:   zhoulei
 * Date:     2018/5/16 下午5:47
 * Description: 配置文件上传目录及图片路径
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈通过application文件来配置文件上传目录及图片路径〉
 *
 * @author zhoulei
 * @create 2018/5/16
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "upload.pictures")
public class PicturesUploadProperties {

    private Resource uploadPath;//上传上传路径
    private Resource anonymousPicture;//匿名用户图片头像

    public Resource getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = new DefaultResourceLoader().getResource(uploadPath);
    }

    public Resource getAnonymousPicture() {
        return anonymousPicture;
    }

    public void setAnonymousPicture(String anonymousPicture) {
        this.anonymousPicture = new DefaultResourceLoader().getResource(anonymousPicture);
    }
}
