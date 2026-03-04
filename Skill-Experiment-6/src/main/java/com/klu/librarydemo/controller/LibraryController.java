package com.klu.librarydemo.controller;

import com.klu.librarydemo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    List<Book> books = new ArrayList<>();

    // 1. Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System";
    }

    // 2. Total Books Count
    @GetMapping("/count")
    public int count() {
        return 50;
    }

    // 3. Sample Price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. List of Book Titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> bookTitles = new ArrayList<>();

        bookTitles.add("Java Programming");
        bookTitles.add("Spring Boot Guide");
        bookTitles.add("Data Structures");
        bookTitles.add("Algorithms");

        return bookTitles;
    }

    // 5. Book Details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book ID: " + id;
    }

    // 6. Search Book using RequestParam
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    // 7. Author Name
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 8. Add Book using POST
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        books.add(book);

        return "Book added successfully";
    }

    // 9. View All Added Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return books;
    }
}