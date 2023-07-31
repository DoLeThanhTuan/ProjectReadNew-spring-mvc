package com.dolethanhtuan.util.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class messageUtil {
	public Map<String, String> getMessage(String report){
		Map<String, String> message = new HashMap<String, String>();
		String mess = "";
		if(report.equals("success"))
			mess = "Thành công";
		else if(report.equals("danger"))
			mess = "Lỗi";
		message.put(report, mess);
		return message;
	}
}
