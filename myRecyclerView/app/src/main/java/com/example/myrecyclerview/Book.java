package com.example.myrecyclerview;

import java.util.ArrayList;

public class Book {

    private String bookThumbnail;
    private String bookTitle;
    private String bookAuthor;

    public Book(String bookThumbnail, String bookTitle, String bookAuthor) {
        this.bookThumbnail = bookThumbnail;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getBookThumbnail() {
        return bookThumbnail;
    }

    public void setBookThumbnail(String bookThumbnail) {
        this.bookThumbnail = bookThumbnail;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public static ArrayList<Book> getSampleBookData() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/189/260/18926010.jpg?udate=20220311", "불편한 편의점", "김호연"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/224/524/22452419.jpg?udate=20220525", "나로서 충분히 괜찮은 사람", "김재식"));
        books.add(new Book("https://search.pstatic.net/common?type=a&size=100&quality=90&direct=true&src=https%3A%2F%2Fbookthumb-phinf.pstatic.net%2Fcover%2F223%2F538%2F22353804.jpg%3Ftype%3Dm140%26udate%3D20220521", "작별인사", "김영하"));
        books.add(new Book("https://search.pstatic.net/common?type=a&size=100&quality=90&direct=true&src=https%3A%2F%2Fbookthumb-phinf.pstatic.net%2Fcover%2F224%2F598%2F22459808.jpg%3Ftype%3Dm140%26udate%3D20220524", "이웃집 백만장자", "토머스 J.스탠리"));
        books.add(new Book("https://search.pstatic.net/common?type=a&size=100&quality=90&direct=true&src=https%3A%2F%2Fbookthumb-phinf.pstatic.net%2Fcover%2F223%2F178%2F22317823.jpg%3Ftype%3Dm140%26udate%3D20220427", "기분을 관리하면 인생이 관리된다", "김다슬"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/143/848/14384887.jpg?type=m1&udate=20220526", "오은영의 화해", "오은영"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/223/010/22301048.jpg?type=m1&udate=20220526", "고민의 답", "글배우"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/223/036/22303690.jpg?type=m1&udate=20220526", "심리학이 불안에 답하다", "황양밍, 장린린"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/224/527/22452731.jpg?type=m1&udate=20220526", "더 찬스 The Chance", "김영익"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/214/880/21488038.jpg?type=m1&udate=20220526", "마음의 법칙", "로버트 기요사키"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/133/473/13347349.jpg?type=m1&udate=20220526", "부자아빠 가난한 아빠", "폴커 키츠"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/224/792/22479255.jpg?type=m1&udate=20220527", "밤의 끝을 알리는", "오건영"));
        books.add(new Book("https://bookthumb-phinf.pstatic.net/cover/212/625/21262555.jpg?type=m1&udate=20220526", "웰씽킹", "켈리 최"));
        return books;
    }
}
