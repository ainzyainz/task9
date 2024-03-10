package util;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionUtils<T> {
    public void updateReflectionUtil(T obj, T result, EntityManager entityManager){
        Field[] objFields = obj.getClass().getDeclaredFields();
        Arrays.stream(objFields)
                .peek(q -> q.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .forEach(field -> {
                    try {
                        field.set(result, field.get(obj));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        entityManager.merge(result);
        entityManager.flush();
    }
}
