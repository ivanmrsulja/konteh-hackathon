package com.konteh.hackathon.repository;

import com.konteh.hackathon.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("select r from Room r join fetch r.faculty f where r.faculty.id = :facultyId and r.isActive = true")
    List<Room> findAllForFaculty(String facultyId);

    @Query("select r from Room r where r.isActive = true")
    List<Room> findAllActive();

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select r from Room r where r.id = :id and r.isActive = true")
    Optional<Room> findById(String id);
}
