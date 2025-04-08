package com.sercanozbek.services.impl;

import com.sercanozbek.dto.HomeDto;
import com.sercanozbek.dto.RoomDto;
import com.sercanozbek.entities.Home;
import com.sercanozbek.entities.Room;
import com.sercanozbek.repository.HomeRepository;
import com.sercanozbek.services.IHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements IHomeService {
    private final HomeRepository homeRepository;

    @Override
    public HomeDto findByHomeId(Long id) {
        HomeDto homeDto = new HomeDto();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();
        List<Room> dbRooms = optional.get().getRoom();
        BeanUtils.copyProperties(dbHome, homeDto);
        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                RoomDto roomDto = new RoomDto();
                BeanUtils.copyProperties(room, roomDto);
                homeDto.getRooms().add(roomDto);
            }
        }
        return homeDto;

    }
}
