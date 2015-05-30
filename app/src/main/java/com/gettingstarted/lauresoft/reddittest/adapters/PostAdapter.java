package com.gettingstarted.lauresoft.reddittest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gettingstarted.lauresoft.reddittest.R;
import com.gettingstarted.lauresoft.reddittest.models.Post;

import java.util.ArrayList;

/**
 * Created by Laure on 18/01/2015.
 */
public class PostAdapter extends ArrayAdapter<Post>
{
    private ArrayList<Post> posts;
    public PostAdapter(Context context, int resource, ArrayList<Post> posts) {
        super(context, resource);
        this.posts = posts;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
        View v = convertView;

        if(v==null)
        {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.post_item,null);
        }

        Post post = posts.get(position);
        if(post!=null)
        {
            TextView title = (TextView)v.findViewById(R.id.post_title);
            TextView details = (TextView)v.findViewById(R.id.post_details);
            TextView score = (TextView)v.findViewById(R.id.post_score);

            title.setText(post.getTitle());
            details.setText(post.getDetails());
            score.setText(post.getScore());

        }

        return v;

    }
}
