package com.konteh.hackathon.repository;

import com.konteh.hackathon.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface DeskRepository extends JpaRepository<Desk, Integer> {

    @Query("select d from Desk d where d.isActive = true")
    List<Desk> findAllActive();

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select d from Desk d where d.id = :id and d.isActive = true")
    Optional<Desk> findForUpdate(String id);

    @Query("select d from Desk d where d.readingRoom.id = :roomId and d.isActive = true ")
    List<Desk> findAllForRoom(String roomId);

    @Query("select max(d.order) from Desk d where d.readingRoom.id = :roomId and d.isActive = true ")
    Integer findMaxOrderForRoom(String roomId);
}
