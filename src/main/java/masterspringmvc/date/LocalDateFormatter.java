/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LocalDateFormatter
 * Author:   zhoulei
 * Date:     2018/5/14 下午5:04
 * Description: 格式化localDate对象类，使其能够和本国的使用格式相同，
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.date;

import masterspringmvc.gracedemo.exceptions.CheckException;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * 格式化localDate对象类，使其能够和本国的时间格式相同，
 * 现在只支持美国和中国两种类型。
 * 如果你不在上面两个国家，将使用默认格式：dd/MM/yyyy
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
public class LocalDateFormatter implements Formatter<LocalDate> {
    private static final String NORMAL_PATTERN = "dd/MM/yyyy";
    private static final String US_PATTERN = "MM/dd/yyyy";
    private static final String CN_PATTERN = "yyyy-MM-dd";


    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text,DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    public static String getPattern(Locale locale) {
        String localCountry = locale.getCountry();
        //System.out.println(locale.toString());
        //System.out.println(localCountry);
        //System.out.println(Locale.US.getCountry());
        //System.out.println(Locale.SIMPLIFIED_CHINESE.getCountry());
        if (Locale.US.getCountry().equals(localCountry)){
            return US_PATTERN;
        }else if(Locale.SIMPLIFIED_CHINESE.getCountry().equals(localCountry)){
            return CN_PATTERN;
        }else{
            return NORMAL_PATTERN;
        }
    }

}
