package com.simpledev.saladereuniao.controller.api;

import com.simpledev.saladereuniao.domain.model.Room;
import com.simpledev.saladereuniao.domain.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoomById(@PathVariable Long roomId){
        return roomService.getRoomId(roomId);
    }

    @PostMapping("/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public Room createdRoom(@Valid @RequestBody Room room){
        return roomService.createRom(room);
    }

    @PutMapping("/rooms/{roomId}")
    public Room updateRoom(@Valid @RequestBody Room room,
                               @PathVariable Long roomId){
        room.setId(roomId);
        room = roomService.updateRoom(room);
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId){
        roomService.deleteRoom(roomId);
        return ResponseEntity.noContent().build();
    }

}
