package converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

import entity.Address;
/**
 * 定义转换器
 * @author 30038737
 *
 */
public class StringAddressConverter implements Converter<String, Address>{

	@Override
	public Address convert(String source) {
		Pattern pattern = Pattern.compile("\\[(.*)-(.*)\\]");
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			String city = matcher.group(1);
			String province = matcher.group(2);
			
			Address address = new Address();
			address.setCity(city);
			address.setProvince(province);
			return address;
		} else {
			
		}
		return null;
	}
}
