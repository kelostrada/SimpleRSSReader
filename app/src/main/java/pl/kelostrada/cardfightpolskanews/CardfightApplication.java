package pl.kelostrada.cardfightpolskanews;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class CardfightApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
