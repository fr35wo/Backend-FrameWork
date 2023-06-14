package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지
    int sz = 15;       // 페이지 당 레코드 수
   String dn = "";		//categoryTitle
    int recordCount;   // 전체 레코드 수

    public String getQueryString() {
    	String edn = ""; //String encodeing
    	try {
    		edn = URLEncoder.encode(dn, "UTF-8");
    	} catch (UnsupportedEncodingException e) {
    		e.printStackTrace();
    	}
    	return String.format("pg=%d&sz=%d&dn=%s", pg, sz, edn);
    }

}

