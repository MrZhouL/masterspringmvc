/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: USLocalDateFormatter
 * Author:   zhoulei
 * Date:     2018/5/14 下午12:44
 * Description: 将时间类型格式化为MM/dd/yy类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package masterspringmvc.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 〈一句话功能简述〉<br> 
 * 〈将时间类型格式化为MM/dd/yyyy类型〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */

public class USLocalDateFormatter implements Formatter<LocalDate> {
    private static final String US_PAEERN = "MM/dd/yyyy";
    private static final String NORMAL_PATTERN = "dd/MM/yyyy";



    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? US_PAEERN : NORMAL_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale) {
        System.out.println(Locale.US.getCountry());
        System.out.println(locale.getCountry());
        System.out.println(Locale.SIMPLIFIED_CHINESE.getCountry().equals(locale.getCountry()));
        return Locale.US.getCountry().equals(locale.getCountry());
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        System.out.println("us print 方法");
        System.out.println(DateTimeFormatter.ofPattern(getPattern(locale)).format(object));
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        System.out.println("us parse 方法");
        System.out.println(text);
        return LocalDate.parse(text,DateTimeFormatter.ofPattern(getPattern(locale)));
    }
}
