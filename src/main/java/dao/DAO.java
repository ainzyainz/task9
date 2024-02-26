package dao;

public interface DAO<T> {
    void create(T obj);
    T read(int id);
    T update(int id, T obj);
    void delete(int id);
}
