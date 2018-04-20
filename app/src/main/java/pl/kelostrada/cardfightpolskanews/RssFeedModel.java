package pl.kelostrada.cardfightpolskanews;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class RssFeedModel {
    public String title;
    public String link;
    public String description;
    public Uri pictureUri;

    public RssFeedModel(String title, String link, String description, String pictureUrl) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pictureUri = Uri.parse(pictureUrl);
    }
}
