package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;
import net.skhu.mapper.SugangMapper;

@Service
public class StudentService {

    @Autowired StudentMapper studentMapper;
    @Autowired SugangMapper sugangMapper;

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Transactional
    public void deleteById(int id) {
        sugangMapper.deleteByStudentId(id);
        studentMapper.deleteById(id);
    }

}

