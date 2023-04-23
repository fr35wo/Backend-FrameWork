package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
    int pg = 1;        // 현재 페이지 번호
    int sz = 15;       // 페이지 당 레코드 수
    int di = 0;        // departmentId
    int od = 0;        // 정렬 순서
    int recordCount;   // 전체 레코드 수

    public int getFirstRecordIndex() {
        return (pg - 1) * sz;
    }

    public String getQueryString() {
    	return String.format("pg=%d&sz=%d&di=%d&od=%d", pg, sz, di, od);
    }
}
