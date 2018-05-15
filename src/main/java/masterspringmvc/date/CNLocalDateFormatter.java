/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CNLocalDateFormatter
 * Author:   zhoulei
 * Date:     2018/5/14 下午4:06
 * Description: 中国时间格式化yyyy-MM-dd类型
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
 * 〈中国时间格式化yyyy-MM-dd类型〉
 *  默认为dd/MM/yy
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
public class CNLocalDateFormatter implements Formatter<LocalDate> {
    private static final String NORMAL_PATTERN = "dd/MM/yyyy";
    private static final String CN_PAEERN = "yyyy-MM-dd";

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text,DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? CN_PAEERN : NORMAL_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale) {
        System.out.println(Locale.SIMPLIFIED_CHINESE.getCountry().equals(locale.getCountry()));
        return Locale.US.getCountry().equals(locale.getCountry());
    }

}
