package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer>{

	List<Engineer> findByRoleId(Integer roleId);
	List<Engineer> findByNameStartingWithOrderByNameAsc(String name);

}
