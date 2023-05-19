package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.skhu.entity.Sugang;

public interface SugangRepository extends JpaRepository<Sugang, Integer>  {

    List<Sugang> findByLectureIdOrderByGradeDesc(int lectureId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(" UPDATE Sugang g SET g.grade = :after "
         + " WHERE g.lecture.id = :lectureId AND g.grade = :before ")
    void udateGradeByLectureId(int lectureId, String before, String after);

}
