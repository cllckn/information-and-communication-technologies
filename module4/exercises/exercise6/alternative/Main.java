package cc.ku.ict.module4.exercises.exercise6.alternative;



import cc.ku.ict.module4.exercises.exercise6.Address;
import cc.ku.ict.module4.exercises.exercise6.IAddress;
import cc.ku.ict.module4.exercises.exercise6.IImage;
import cc.ku.ict.module4.exercises.exercise6.Image;
import cc.ku.ict.module4.exercises.exercise6.ExtendedUser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        IAddress address=new Address("street1","Petropavl");

        List<IImage> images=new ArrayList<>();

        images.add(new Image(1,"www.xy.com","title1",200));
        images.add(new Image(2,"www.xyz.com","title2",500));
        images.add(new EncryptedImage(3,"www.kl.com","title3",500, "RSA","123456"));


        ExtendedUser extendedUser=new ExtendedUser(5,"jane","j@a.com","jane","1234","admin",images,address);

        System.out.println(extendedUser);
    }

}
