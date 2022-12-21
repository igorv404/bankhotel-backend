package io.igorv404.bankhotel.services;

import io.igorv404.bankhotel.models.Room;

public interface RoomService extends ServiceTemplate<Room, Integer> {
    Room getByUrl(String url);
}
