package dao;

import entity.Address;

public interface DAOAddress extends DAO<Address> {
    void removeHouses();
}
