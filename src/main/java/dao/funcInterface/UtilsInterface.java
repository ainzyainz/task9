package dao.funcInterface;


import javax.persistence.EntityManager;

public class UtilsInterface <T> {

    public void superMethodInterface(MyInterfaceToDAO<T> method, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        method.betweenBeginAndCommitted();
        entityManager.getTransaction().commit();
    }
}
