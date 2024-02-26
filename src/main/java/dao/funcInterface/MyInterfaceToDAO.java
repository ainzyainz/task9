package dao.funcInterface;

@FunctionalInterface
public interface MyInterfaceToDAO<T> {
    T betweenBeginAndCommitted();
}
