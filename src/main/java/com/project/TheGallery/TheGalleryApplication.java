package com.project.TheGallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan
public class TheGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheGalleryApplication.class, args);
	}

}
