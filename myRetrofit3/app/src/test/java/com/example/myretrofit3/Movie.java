package com.example.myretrofit3;

public class Movie {

    private String title;
    private int releaseYear;

    private Movie() {} // 기본 생성자 private으로 세팅

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public static class MyMovieBuilder {

        private String title;
        private int releaseYear;

        public MyMovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MyMovieBuilder setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.title = title;
            movie.releaseYear = releaseYear;
            return movie;
        }
    }
}
