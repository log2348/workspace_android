package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Post> sampleData = Post.getMyPosts();
        LinearLayout container = findViewById(R.id.blogContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        sampleData.forEach(post -> {
            View itemView = inflater.inflate(R.layout.item_blog, container, false);

            ImageView postImage = itemView.findViewById(R.id.postImage);
            TextView postTitle = itemView.findViewById(R.id.postTitle);
            TextView postContent = itemView.findViewById(R.id.postContent);

            postTitle.setText(post.title);
            postContent.setText(post.content);

            // 이미지 불러오기
            Glide.with(this)
                    .load(post.imageUrl)
                    .centerCrop()
                    .into(postImage);

            container.addView(itemView);

        });

    }
}