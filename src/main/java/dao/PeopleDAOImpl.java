package dao;


import util.HibernateUtils;
import entity.People;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PeopleDAOImpl extends DAOImpl<People> implements DAOPeople {

    public static final String SELECT_QUERY = "select *from people\n" +
            "order by  id desc\n" +
            "limit 2";

    public PeopleDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<People> getEntityClass() {
        return People.class;
    }

    @Override
    public void create(People obj) {
        super.create(obj);
    }

    @Override
    public People read(int id) {
        return super.read(id);
    }

    @Override
    public People update(int id, People obj) {
        return super.update(id, obj);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void toAge() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(SELECT_QUERY, People.class);
        List<People> list = query.getResultList();
        if (list.size()>=2){
            for (People people1 : list) {
                people1.setAge(people1.getAge() + 2);
                entityManager.merge(people1);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
        }else{
            System.out.println("Incorrect size of the list");
        }
    }
}
