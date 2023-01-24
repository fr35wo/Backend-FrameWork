package net.skhu.dto;

import lombok.Data;

@Data
//@Data 어노테이션은 lombok 기능을 사용하기 위한 어노테이션이다.
//@Data 어노테이션을 클래스 앞에 붙이면,
//lombok에 의해서 setter, setter, equals, hashCode, toString 메소드가 자동 구현된다.

public class Department {
    int id;
    String name;
    String shortName;
    String phone;
}