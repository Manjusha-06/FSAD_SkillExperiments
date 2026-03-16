package com.example.demo.controller;

import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService service;

    // 2. Welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Library API!";
    }

    // 3. Return total books count
    @GetMapping("/count")
    public int getBookCount() {
        return service.getBookCount();
    }

    // 4. Return sample book price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 5. Return list of book titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> titles = new ArrayList<>();

        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }

    // 6. Get book details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 7. Search using request param
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 8. Author name
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 9. Add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Library book) {
        service.addBook(book);
        return "Book added successfully";
    }

    // 10. View all books
    @GetMapping("/viewbooks")
    public List<Library> viewBooks() {
        return service.getAllBooks();
    }

}