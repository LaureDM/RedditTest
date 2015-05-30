package com.gettingstarted.lauresoft.reddittest;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gettingstarted.lauresoft.reddittest.mapping.PostsHolder;
import com.gettingstarted.lauresoft.reddittest.models.Post;
import com.gettingstarted.lauresoft.reddittest.adapters.PostAdapter;

import java.util.ArrayList;


public class PostsFragment extends Fragment {


    private ListView listView;
    private PostAdapter adapter;
    private Handler handler;

    private String subreddit;
    private ArrayList<Post> posts;
    private PostsHolder postsHolder;

    public static PostsFragment newInstance(String subreddit)
    {
        PostsFragment fragment = new PostsFragment();

        fragment.subreddit = subreddit;
        fragment.postsHolder = new PostsHolder(fragment.subreddit);
        return fragment;
    }

    public PostsFragment() {
        // Required empty public constructor

        posts = new ArrayList<>();
        handler = new Handler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_posts , container, false);
        listView = (ListView)v.findViewById(R.id.posts_list);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initialize();
    }

    private void initialize() {
        if(posts.size()==0)
        {
            new DownloadTask().execute();
        }
    }

    private class DownloadTask extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog pdialog;
        @Override
        protected void onPreExecute()
        {
            pdialog = new ProgressDialog(getActivity());
            pdialog.setTitle("Download posts");
            pdialog.setMessage("downloading...");
            pdialog.setIndeterminate(false);
            pdialog.setCancelable(true);
            pdialog.show();
        }
        @Override
        protected Void doInBackground(Void... params)
        {
            pdialog.dismiss();
            posts.addAll(postsHolder.getPosts());
            handler.post(new Runnable() {
                public void run() {
                    updateListView();
                }
            });

            return null;
        }
    }

    private void updateListView() {

     adapter = new PostAdapter(getActivity(),R.layout.post_item,posts);
     listView.setAdapter(adapter);

    }
}
