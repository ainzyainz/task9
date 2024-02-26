package dao;

import Util.ReflectionUtils;
import dao.funcInterface.MyInterfaceToDAO;
import dao.funcInterface.UtilsInterface;

import javax.persistence.EntityManager;


public abstract class DAOImpl<T> implements DAO<T> {

    private final EntityManager entityManager;

    protected DAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<T> getEntityClass();

    public void create(T object) {
        if (null!=object) {
            MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
                entityManager.persist(object);
                return object;
            };
            UtilsInterface<T> utilsInterface = new UtilsInterface<>();
            utilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
        } else {
            System.out.println("not found");
        }
    }

    public T read(int id) {
        T object = startMethod(id);
        if (null!=object) {
            MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> object;
            UtilsInterface<T> utilsInterface = new UtilsInterface<>();
            utilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
            return object;
        } else {
            System.out.println("not found");
            return null;
        }
    }

    public T update(int id, T object) {
        T result = startMethod(id);
        if (null != result) {
            MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
                ReflectionUtils<T> reflectionUtils = new ReflectionUtils();
                reflectionUtils.updateReflectionUtil(object,result,entityManager);
                return result;
            };
            UtilsInterface<T> utilsInterface = new UtilsInterface<>();
            utilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);
        } else {
            System.out.println("not found");
        }
        return result;
    }

    public void delete(int id) {
        T object = startMethod(id);
        if (object != null) {
            MyInterfaceToDAO<T> betweenBeginAndCommitted = () -> {
                entityManager.remove(object);
                return object;
            };
            UtilsInterface<T> utilsInterface = new UtilsInterface<>();
            utilsInterface.superMethodInterface(betweenBeginAndCommitted, entityManager);

        } else {
            System.out.println("not found");
        }
    }

    private T startMethod(int id) {
        return entityManager.find(getEntityClass(), id);
    }
}
