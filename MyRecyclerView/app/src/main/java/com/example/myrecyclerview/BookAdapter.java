package com.example.myrecyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyBookViewHolder> {

    ArrayList<Book> bookList;
    Context context;

    public BookAdapter(ArrayList<Book> list, Context context) {
        this.bookList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_book, parent, false);

        return new MyBookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBookViewHolder holder, int position) {
        Book book = bookList.get(position);
        Glide.with(context)
                .load(book.getBookThumbnail())
                .centerCrop()
                .into(holder.bookThumnail);
        holder.bookTitle.setText(book.getBookTitle());
        holder.bookAuthor.setText(book.getBookAuthor());
        holder.bookDetail.setText(book.getDetail());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    public class MyBookViewHolder extends RecyclerView.ViewHolder {

        ImageView bookThumnail;
        TextView bookTitle;
        TextView bookAuthor;
        TextView bookDetail;


        public MyBookViewHolder(@NonNull View itemView) {
            super(itemView);

            bookThumnail = itemView.findViewById(R.id.bookThumbnmail);
            bookTitle =  itemView.findViewById(R.id.title);
            bookAuthor = itemView.findViewById(R.id.author);
            bookDetail = itemView.findViewById(R.id.detailText);

            itemView.setOnClickListener(view -> {

            });
        }
    }
}
