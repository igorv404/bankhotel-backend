package io.igorv404.bankhotel.services;

import java.util.List;

public interface ServiceTemplate<T, ID> {
    List<T> getAll();

    T getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    String delete(ID id);
}
