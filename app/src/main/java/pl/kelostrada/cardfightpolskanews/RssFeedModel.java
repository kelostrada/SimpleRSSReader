package pl.kelostrada.cardfightpolskanews;

import android.net.Uri;

public class RssFeedModel {
    public String title;
    public String link;
    public String description;
    public Uri pictureUri;

    public RssFeedModel(String title, String link, String description, Uri pictureUri) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pictureUri = pictureUri;
    }
}
