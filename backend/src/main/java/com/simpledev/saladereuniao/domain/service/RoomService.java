package com.simpledev.saladereuniao.domain.service;

import com.simpledev.saladereuniao.domain.exception.ResourceNotFoundException;
import com.simpledev.saladereuniao.domain.model.Room;
import com.simpledev.saladereuniao.domain.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private RoomRepository roomRepository;

    public Room getRoomId(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found: "+ roomId));
    }

    @Transactional
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @Transactional
    public Room createRom(Room room){
        return roomRepository.save(room);
    }

    @Transactional
    public Room updateRoom(Room room){
        Room newRoom = getRoomId(room.getId());
        updateNewRoom(newRoom, room);
        return roomRepository.save(room);
    }

    @Transactional
    public void deleteRoom(Long roomId){
        getRoomId(roomId);
        try {
            roomRepository.deleteById(roomId);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Room Not Found!");
        }
    }

    private void updateNewRoom(Room newRoom, Room room){
        newRoom.setName(room.getName());
        newRoom.setDate(room.getDate());
        newRoom.setStartHour(room.getStartHour());
        newRoom.setEndHour(room.getEndHour());
    }

}
