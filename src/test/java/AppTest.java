import util.HibernateUtils;
import dao.AddressDAOImpl;
import dao.PeopleDAOImpl;
import entity.Address;
import entity.People;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class AppTest {

    private EntityManager entityManager = HibernateUtils.getEntityManager();

    private AddressDAOImpl addressDAO = new AddressDAOImpl(entityManager);

    private PeopleDAOImpl peopleDAO = new PeopleDAOImpl(entityManager);


    @Test
    public void createAddressTest(){
        Address testAddress = MockUtils.getAddress();

        long countBefore = getDataBaseCount(entityManager,testAddress);

        addressDAO.create(testAddress);

        long countAfter = getDataBaseCount(entityManager,testAddress);

        Assert.assertNotEquals(countBefore,countAfter);

    }

    @Test
    public void createPersonTest(){
        People testPerson = MockUtils.getPerson();

        long countBefore = getDataBaseCount(entityManager,testPerson);

        peopleDAO.create(testPerson);

        long countAfter = getDataBaseCount(entityManager,testPerson);

        Assert.assertNotEquals(countBefore,countAfter);

    }

    @Test
    public void deleteAddressTest(){
        Address testAddress = MockUtils.getAddress();

        addressDAO.create(testAddress);


        long countBefore = getDataBaseCount(entityManager,testAddress);

        addressDAO.delete(testAddress.getId());

        long countAfter = getDataBaseCount(entityManager,testAddress);

        Assert.assertNotEquals(countBefore,countAfter);

    }

    @Test
    public void deletePersonTest(){
        People testPerson = MockUtils.getPerson();

        peopleDAO.create(testPerson);

        long countBefore = getDataBaseCount(entityManager,testPerson);

        peopleDAO.delete(testPerson.getId());

        long countAfter = getDataBaseCount(entityManager,testPerson);

        Assert.assertNotEquals(countBefore,countAfter);

    }



    public static long getDataBaseCount(EntityManager entityManager, Object obj) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(obj.getClass())));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

}
