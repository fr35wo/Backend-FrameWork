package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Department;
import net.skhu.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@GetMapping("departments")
	public List<Department> departments() {
		return departmentRepository.findAll();
	}

	@GetMapping("department/{id}")
	public Department department(@PathVariable("id") int id) {
		return departmentRepository.findById(id).get();
	}

	@PostMapping("department")
	public boolean insert(@RequestBody Department department) {
		departmentRepository.save(department);
		return true;
	}

	@PutMapping("department")
	public boolean update(@RequestBody Department department) {
		departmentRepository.save(department);
		return true;
	}

	@DeleteMapping("department/{id}")
	public boolean delete(@PathVariable("id") int id) {
		departmentRepository.deleteById(id);
		return true;
	}

}
