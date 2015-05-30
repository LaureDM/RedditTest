package com.gettingstarted.lauresoft.reddittest.models;

/**
 * Created by Laure on 18/01/2015.
 */
public class Post
{
    private String subreddit,title,author,permalink,url,domain,id;
    private int points,numComments;


    public Post(String t, String u, int nc, int p, String a, String sr, String perm, String d, String i) {
        setTitle(t);
        setUrl(u);
        setNumComments(nc);
        setPoints(p);
        setAuthor(a);
        setSubreddit(sr);
        setPermalink(perm);
        setDomain(d);
        setId(i);
    }
    public String getDetails()
    {
        return author+" posted this and got "+numComments+" comments.";
    }

    public String getTitle()
    {
        return title;
    }

    public String getScore()
    {
        return Integer.toString(points);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
