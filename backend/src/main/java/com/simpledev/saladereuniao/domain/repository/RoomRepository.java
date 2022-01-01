package com.simpledev.saladereuniao.domain.repository;

import com.simpledev.saladereuniao.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
