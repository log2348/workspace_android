package com.example.myretrofit3;

public class MainTest2 {

    public static void main(String[] args) {
        System.out.println("hello android ~");

        Movie movie1 = new Movie.MyMovieBuilder().setTitle("아이언맨").build();
        Movie movie2 = new Movie.MyMovieBuilder().setReleaseYear(1999).build();
        Movie movie3 = new Movie.MyMovieBuilder().setTitle("닥터 스트레인지").setReleaseYear(2022).build();

        System.out.println(movie2.toString());
    }
}
