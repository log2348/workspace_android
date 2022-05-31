package com.example.myretrofit3;

// this (키워드에 대한 충분한 이해)
public class Student {

    private String name;
    private int grade;

    // 1. 기본 생성자를 private으로 정의한다.
    private Student() {}

    // 2. 내부 클래스를 생성 (static, (public, default, private) -> 내부 정적 클래스)
    public static class MyBuilder {
        // 2.1 outer class 멤버 변수를 한 번 더 정의한다. (단, private 지정해야함)
        private String name;
        private int grade;

        // 2.2 setter 메서드를 만들어 준다. (하지만 리턴 타입은 자기 자신이다. --> this)
        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        // 3. 핵심 !!
        // 리턴 타입을 outer class로 반환하는 메서드를 만들어준다.
        public Student build() {
            Student student = new Student();
            student.name = name; // outer class의 멤버 = inner class의 멤버
            student.grade = grade;
            return student;
        }
    }

    public static void main(String[] args) {
        // 빌더 패턴 사용하기
        Student student1 = new MyBuilder().setName("아이언맨").build();
        Student student2 = new MyBuilder().setGrade(1).build();
        Student student3 = new MyBuilder().setName("토르").setGrade(3).build();
    }

}
