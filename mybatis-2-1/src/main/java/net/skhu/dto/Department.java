package net.skhu.dto;

import java.io.Serializable;

import lombok.Data;

@Data
//@Data 어노테이션은 lombok 기능을 사용하기 위한 어노테이션이다.
//@Data 어노테이션을 클래스 앞에 붙이면,
//lombok에 의해서 setter, setter, equals, hashCode, toString 메소드가 자동 구현된다.

public class Department  implements Serializable {
    private static final long serialVersionUID = 1L;

//    DepartmentMapper에 캐시 기능을 활성화 하려면,
//    Department DTO 클래스가 Serializable 인터페이스를 implements 해야 한다.
//
//    캐시에 저장된 데이터를 리턴할 때, 저장된 원본 객체를 리턴하는 것이 아니고,
//    저장된 객체를 복제해서, 복제된 새 객체를 리턴해야 한다.
//    이 복제는 deep copy 이어야 한다.

    int id;
    String name;
    String shortName;
    String phone;
}



