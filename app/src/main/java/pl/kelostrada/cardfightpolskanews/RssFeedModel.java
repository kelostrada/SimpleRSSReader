package pl.kelostrada.cardfightpolskanews;

import android.graphics.drawable.Drawable;

public class RssFeedModel {
    public String title;
    public String link;
    public String description;
    public Drawable picture;

    public RssFeedModel(String title, String link, String description, Drawable picture) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.picture = picture;
    }
}
