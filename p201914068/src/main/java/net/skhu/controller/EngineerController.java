package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Engineer;
import net.skhu.repository.EngineerRepository;
import net.skhu.repository.ProjectRepository;

@RestController
public class EngineerController {

    @Autowired EngineerRepository engineerRepository;
    @Autowired ProjectRepository projectRepository;

    @GetMapping("exam1")
    public List<Engineer> exam1() {
        return engineerRepository.findAll();
    }

    @GetMapping("exam2")
    public List<Engineer> exam2(@RequestParam("id") Integer roleId) {
        return engineerRepository.findByRoleId(roleId);
    }

    @GetMapping("exam3")
    public List<Engineer> exam3(@RequestParam("name") String name) {
        return engineerRepository.findByNameStartingWithOrderByNameAsc(name);
    }

//    @GetMapping("exam4")
//    public List<Engineer> exam4(@RequestParam("id") Integer projectId) {
//        return engineerRepository.findByProjectId(projectId);
//    }


}
