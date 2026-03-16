package com.example.demo.service;

import com.example.demo.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    List<Library> bookList = new ArrayList<>();

    public void addBook(Library book) {
        bookList.add(book);
    }

    public List<Library> getAllBooks() {
        return bookList;
    }

    public int getBookCount() {
        return bookList.size();
    }
}