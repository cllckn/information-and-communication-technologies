package cc.ku.ict.module4.exercises.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Address address=new Address("street1","Petropavl");

        List<Image> images=new ArrayList<>();

        images.add(new Image(1,"www.xy.com","title1",200));
        images.add(new Image(2,"www.xyz.com","title2",500));


        ExtendedUser extendedUser=new ExtendedUser(5,"jane","j@a.com","jane","1234","admin",images,address);

        System.out.println(extendedUser.toString());
    }

}
