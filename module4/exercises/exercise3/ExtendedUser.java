package cc.ku.ict.module4.exercises.exercise3;

import cc.ku.ict.module4.exercises.exercise2.User;

import java.util.ArrayList;
import java.util.List;

public class ExtendedUser extends User {

    private Address address;
    private List<Image> images = new ArrayList<>();

    public ExtendedUser(int id, String name, String email, String username, String password, String role, List<Image> images, Address address) {
        super(id, name, email, username, password, role);

        this.images = images;
        this.address = address;

    }

    @Override
    public String toString() {
        return "ExtendedUser{" +
                super.toString() +
                "address=" + address +
                ", images=" + images +
                '}';
    }
}
