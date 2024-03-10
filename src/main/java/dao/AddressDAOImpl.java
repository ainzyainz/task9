package dao;

import util.HibernateUtils;
import entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AddressDAOImpl extends DAOImpl<Address> implements DAOAddress {
    public static final String SELECT_QUERY = "select *\n" +
            "from address\n" +
            "order by id desc\n" +
            "limit 2";

    public AddressDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public void create(Address obj) {
        super.create(obj);
    }

    @Override
    public Address read(int id) {
        return super.read(id);
    }

    @Override
    public Address update(int id, Address obj) {
        return super.update(id, obj);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void removeHouses() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(SELECT_QUERY, Address.class);
        List<Address> list = query.getResultList();

        if (list.size() >= 2) {
            for (Address address : list) {
                address.setHouse(address.getHouse() + 1);
                entityManager.merge(address);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            System.out.println("Incorrect list size");
        }
    }
}
