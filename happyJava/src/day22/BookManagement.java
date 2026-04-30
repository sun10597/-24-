package day22;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Book{
    private String title;
    private String author;
    private int year;
    private double price;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public Book(String title, String author, int year, double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | %d년 | %.0f원]", title, author, year, price);
    }

}
public class BookManagement {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("자바의 정석", "남궁성", 2016, 30000),
                new Book("모던 자바", "케빈", 2021, 35000),
                new Book("클린 코드", "로버트", 2013, 25000),
                new Book("이펙티브 자바", "조슈아", 2018, 28000),
                new Book("자바 병렬 프로그래밍", "브라이언", 2022, 32000)
        );
        System.out.println("2020년 이후 출판된 도서만 필터링");
        List<Book> filter1 = books.stream()
                .filter(b -> b.getYear() >= 2020)
                .collect(Collectors.toList());
        filter1.forEach(System.out::println);

        System.out.println();
        System.out.println("가격이 20000원 이상인 도서 찾기");
        List<Book> filter2 = books.stream()
                .filter(b -> b.getPrice() >= 20000)
                .collect(Collectors.toList()); // 리스트로 저장
        filter2.forEach(System.out::println);

        System.out.println();
        System.out.println("저자별로 도서를 그룹화");
        Map<String, List<Book>> byAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        byAuthor.forEach((author, bookList) -> System.out.println(author + bookList));

        System.out.println();
        System.out.println("평균 가격 계산");
        double avg = books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);

    }
}
