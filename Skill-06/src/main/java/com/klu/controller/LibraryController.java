package com.klu.controller;

import com.klu.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 1️⃣ /welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    // 2️⃣ /count
    @GetMapping("/count")
    public int getBookCount() {
        return 150;
    }

    // 3️⃣ /price
    @GetMapping("/price")
    public double getSamplePrice() {
        return 499.99;
    }

    // 4️⃣ /books
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        titles.add("Spring Boot Guide");
        titles.add("Java Programming");
        titles.add("Microservices Architecture");
        return titles;
    }

    // 5️⃣ /books/{id}
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of book with ID: " + id;
    }

    // 6️⃣ /search?title=
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 7️⃣ /author/{name}
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 8️⃣ /addbook
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 9️⃣ /viewbooks
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}