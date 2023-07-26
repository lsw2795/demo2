package com.ez.example.book.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BookVO {
	private int no;
	private String title;
	private String publisher;
	private int price;
	private Timestamp joindate;

}
