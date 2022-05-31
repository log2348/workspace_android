package com.example.myretrofit3.models.request;

/**
 *
 *     title: 'foo',
 *     body: 'bar',
 *     userId: 1
 *
 *   엑티비티(모바일) -> 객체를 생성해서 -> 서비스 로직 생성해서 매개변수에 전달하는 코드 사용
 *   객체 생성해서 보내야 한다. -> 생성자를 만들어줘야 한다
 */
public class ReqPostDto {
    public String title;
    public String body;
    public Integer userId;

    public ReqPostDto(String title, String body, Integer userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
