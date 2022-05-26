package com.example.mylistview;

import java.util.ArrayList;

public class Post {

    String imageUrl;
    String title;
    String content;

    public Post(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public static ArrayList<Post> getMyPosts() {
        ArrayList<Post> postList = new ArrayList<>();
        postList.add(new Post("https://cdn.pixabay.com/photo/2018/02/11/23/38/cup-3147107__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2015/08/29/16/48/glow-913190__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2016/03/04/19/36/beach-1236581_960_720.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2014/11/16/15/15/field-533541__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2020/05/31/03/18/coffee-5241047__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2014/01/17/19/01/tree-247122__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2019/09/07/06/10/camera-4458023__340.jpg", "Title", "content..."));
        postList.add(new Post("https://cdn.pixabay.com/photo/2017/08/20/05/50/summer-vacation-2660674__340.jpg", "Title", "content..."));

        return postList;
    }
}
