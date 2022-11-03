package editor;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Address;

public class AddressEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		Address address = (Address) getValue();
		return "[" + address.getCity() + "-" + address.getProvince() + "]";
	}

	@Override
	public void setAsText(String arg0) throws IllegalArgumentException {
		Pattern pattern = Pattern.compile("\\[(.*)-(.*)\\]");
		Matcher matcher = pattern.matcher(arg0);
		if (matcher.matches()) {
			String city = matcher.group(1);
			String province = matcher.group(2);
			
			Address address = new Address();
			address.setCity(city);
			address.setProvince(province);
			setValue(address);
		}
	}

}
