package com.example.app;

import android.app.Application;

import java.util.ArrayList;

public class ApplicatonClass extends Application {

    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();

        cars.add(new Car("image3","Polo","James","094443334444"));
        cars.add(new Car("image2","E200","Kevin","4098008935094"));
        cars.add(new Car("image1","Deod","James","232342323423"));
        cars.add(new Car("image1","Kom","James","5464564564"));
        cars.add(new Car("image3","Polo","James","3636546564"));
        cars.add(new Car("image2","Ted","James","363645656"));
        cars.add(new Car("image1","Polo","James","225352252525"));
        cars.add(new Car("image3","Polo","James","25252534567546"));
    }
}
