import entity.Address;
import entity.People;

public class MockUtils {
    public static People getPerson() {
        return People
                .builder()
                .name("1")
                .surname("1")
                .age(1)
                .build();
    }

    public static People getPerson2() {
        return People
                .builder()
                .name("2")
                .surname("2")
                .age(2)
                .build();
    }

    public static Address getAddress() {
        return Address
                .builder()
                .street("2")
                .house(2)
                .build();
    }

    public static Address getAddress2() {
        return Address
                .builder()
                .street("2")
                .house(2)
                .build();
    }

}
