/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PictureUploadController
 * Author:   zhoulei
 * Date:     2018/5/16 下午4:48
 * Description: 用于上传的Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.controller;

import masterspringmvc.config.PicturesUploadProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用于上传的Controller〉
 *
 * @author zhoulei
 * @create 2018/5/16
 * @since 1.0.0
 */

@Controller
@SessionAttributes("picturePath")
public class PictureUploadController {

    private final Resource picturesDir;
    private final Resource anonymousPicture;

    @Autowired
    public PictureUploadController(PicturesUploadProperties uploadProperties) {
        picturesDir = uploadProperties.getUploadPath();
        anonymousPicture = uploadProperties.getAnonymousPicture();
    }


    //创建图片存放文件夹
    //public static final Resource PICTURES_DIR = new FileSystemResource("./pictures");



    /**
     * 在controller内处理ioexception异常
     * @param exception
     * @return
     */
    @ExceptionHandler(IOException.class)
    public ModelAndView handleIoException(IOException exception){
        ModelAndView modelAndView = new ModelAndView("uploadPage");
        modelAndView.addObject("error",exception.getMessage());

        return modelAndView;
    }

    /**
     * 跳转到上传图片页面
     * @return
     */
    @RequestMapping("/uploadPage")
    public String toUploadPage(){
        return "uploadPage";
    }

    /**
     * 图片上传
     * @param file
     * @param redirectAttributes
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String onUpload(MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws IOException {
        //格式校验
        if (file.isEmpty() || !isImage(file)){
            redirectAttributes.addFlashAttribute("error","不正确的格式，请上传一张图片");
            return "redirect:/uploadPage";
        }

        Resource pictures = copyFileToPictures(file);
        model.addAttribute("picturePath",pictures);

        //throw new IOException("测试io异常");
        return "uploadPage";
    }

    /**
     * 获取上传的图片
     * @param response
     * @param picturePath
     * @throws IOException
     */
    @RequestMapping("/uploadedPicture")
    public void getUploadPicture(HttpServletResponse response, @ModelAttribute("picturePath") Resource picturePath) throws IOException {
        //这是前一版本，通过从application中读取匿名头像文件，并发送到响应对象中
        //response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(anonymousPicture.getFilename()));
        //IOUtils.copy(anonymousPicture.getInputStream(), response.getOutputStream());

        //现在要改成上传完图片后显示,
        response.setHeader("Content-Type",URLConnection.guessContentTypeFromName(picturePath.toString()));
        IOUtils.copy(picturePath.getInputStream(),response.getOutputStream());

    }

    @ModelAttribute("picturePath")
    public Resource picturePath(){
        return anonymousPicture;
    }
    private boolean isImage(MultipartFile file) {
        return file.getContentType().startsWith("image");
    }

    /**
     * 截取图片扩展名（后缀）
     * @param filename
     * @return
     */
    private String getFileExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }


    /**
     * 复制文件到文件，其中上传路径可写死也可以写活
     *
     * @param file
     * @return
     * @throws IOException
     */
    private Resource copyFileToPictures(MultipartFile file) throws IOException {
        String extensionName = getFileExtension(file.getOriginalFilename());
        File tempFile = File.createTempFile("pic", extensionName, picturesDir.getFile());
        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return new FileSystemResource(tempFile);
    }
    // The rest of the code remains the same
}

