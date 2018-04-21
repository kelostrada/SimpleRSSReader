package pl.kelostrada.cardfightpolskanews;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RssFeedListAdapter
        extends RecyclerView.Adapter<RssFeedListAdapter.FeedModelViewHolder> {

    private List<RssFeedModel> mRssFeedModels;

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView picture;
        public TextView name;
        public TextView description;
        public Button link;

        public boolean isFavourite = false;

        public FeedModelViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = itemView.findViewById(R.id.card_image);
            name = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_text);
            link = itemView.findViewById(R.id.action_button);

            link.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse((String)link.getTag()));

                v.getContext().startActivity(browserIntent);
                }
            });

            final ImageButton favoriteImageButton = itemView.findViewById(R.id.favorite_button);

            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    isFavourite = !isFavourite;

                    if (isFavourite) {
                        int color = ContextCompat.getColor(v.getContext(), R.color.button_red);
                        favoriteImageButton.setColorFilter(color);

                        Snackbar.make(v, "Dodane do ulubionych",
                                Snackbar.LENGTH_LONG).show();
                    } else {
                        int color = ContextCompat.getColor(v.getContext(), R.color.button_grey);
                        favoriteImageButton.setColorFilter(color);

                        Snackbar.make(v, "Usunięte z ulubionych",
                                Snackbar.LENGTH_LONG).show();
                    }



                }
            });

        }
    }

    public RssFeedListAdapter(List<RssFeedModel> rssFeedModels) { mRssFeedModels = rssFeedModels; }

    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        return new FeedModelViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(FeedModelViewHolder holder, int position) {
        final RssFeedModel rssFeedModel = mRssFeedModels.get(position);

        holder.picture.setImageURI(rssFeedModel.pictureUri);
        holder.name.setText(rssFeedModel.title);
        holder.description.setText(rssFeedModel.description);
        holder.link.setTag(rssFeedModel.link);
    }

    @Override
    public int getItemCount() {
        return mRssFeedModels.size();
    }
}

