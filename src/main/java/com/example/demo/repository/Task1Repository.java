package com.example.demo.repository;

import com.example.demo.model.Task1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface Task1Repository extends JpaRepository<Task1, Long> {
//    @Modifying
//    @Query("UPDATE task1 t SET t.done = TRUE WERE t.id = :id")
//    public void MakeAsDone(@Param("id") Long id);

//    @Modifying
//    @Query("UPDATE task1 t SET t.done = FALSE WERE t.id = :id")
//    public void MakeAsFalse(@Param("id") Long id);
}
