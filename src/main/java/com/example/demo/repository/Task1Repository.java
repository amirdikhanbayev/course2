package com.example.demo.repository;

import com.example.demo.model.Task1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface Task1Repository extends JpaRepository<Task1, Long> {
    List<Task1> findByStudentId(Long student_id);
    @Modifying
    @Query("UPDATE Task1 t SET t.done = TRUE WHERE t.id = :id")
    public void MakeAsDone(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Task1 t SET t.done = FALSE WHERE t.id = :id")
    public void MakeAsFalse(@Param("id") Long id);
}
