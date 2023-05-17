package net.skhu;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.skhu.entity.Department;
import net.skhu.entity.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.StudentRepository;

@SpringBootApplication
public class Student9DbApplication implements CommandLineRunner {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Student9DbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Department 소프 = new Department(0, "소프트웨어공학전공");
        Department 컴공 = new Department(0, "컴퓨터공학전공");
        Department 정통 = new Department(0, "정보통신전공");
        departmentRepository.save(소프);
        departmentRepository.save(컴공);
        departmentRepository.save(정통);

        Student 홍길동 = new Student(0, "201014190", "홍길동", LocalDate.of(2000, 5, 5), 소프);
        Student 이몽룡 = new Student(0, "201014191", "이몽룡", LocalDate.of(2000, 6, 10), 컴공);
        Student 성춘향 = new Student(0, "201014192", "성춘향", LocalDate.of(2000, 7, 15), 정통);
        studentRepository.save(홍길동);
        studentRepository.save(이몽룡);
        studentRepository.save(성춘향);
    }
}
