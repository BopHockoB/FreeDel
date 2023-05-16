package ua.nure.freedel.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T, ID> {
        public void show() throws SQLException;
        public void insert(T adr) throws SQLException;
        public T getById(ID id) throws SQLException;
        public void update(T adr) throws SQLException;
        public void delete(T adr) throws SQLException;
        public List<T> getAll() throws SQLException;
        public Integer getNewId() throws SQLException;
    }
