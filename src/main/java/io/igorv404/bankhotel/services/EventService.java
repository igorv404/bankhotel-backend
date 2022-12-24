package io.igorv404.bankhotel.services;

import io.igorv404.bankhotel.models.Event;

public interface EventService extends ServiceTemplate<Event, Integer> {
    Event getByUrl(String url);
}
