package com.gettingstarted.lauresoft.reddittest.mapping;

import android.util.Log;

import com.gettingstarted.lauresoft.reddittest.models.Post;
import com.gettingstarted.lauresoft.reddittest.util.RemoteData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Laure on 18/01/2015.
 */
public class PostsHolder
{
    private final String URL_TEMPLATE = "http://www.reddit.com/r/SUBREDDIT_NAME/.json?after=AFTER";

    private String subreddit, url,after;

    public PostsHolder(String subred)
    {
        subreddit = subred;
        after= "";
        generateUrl();
    }

    private void generateUrl() {
        url = URL_TEMPLATE.replace("SUBREDDIT_NAME",subreddit);
        url = url.replace("AFTER",after);

    }

    public ArrayList<Post> getPosts()
    {
        String raw = RemoteData.readContents(url);
        Log.i("rawdata: ", raw);

        ArrayList<Post> posts = new ArrayList<>();
        try
        {
            JSONObject data = new JSONObject(raw).getJSONObject("data");
            JSONArray jsonArray = data.getJSONArray("children");

            after = data.getString("after");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject currentObject = jsonArray.getJSONObject(i).getJSONObject("data");
                Post post = new Post(currentObject.getString("title"),
                        currentObject.getString("url"),
                        //currentObject.getInt("num_comments"),
                        20,
                        //currentObject.getInt("score"),
                        50,
                        currentObject.getString("author"),
                        currentObject.getString("subreddit"),
                        currentObject.getString("permalink"),
                        currentObject.getString("domain"),
                        currentObject.getString("id"));
                if(post.getTitle()!=null)
                    posts.add(post);


            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public ArrayList<Post> getMorePosts()
    {
        generateUrl();
        return getPosts();
    }
}
