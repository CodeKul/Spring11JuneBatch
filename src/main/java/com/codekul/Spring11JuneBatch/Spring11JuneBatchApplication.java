package com.codekul.Spring11JuneBatch;

import com.codekul.Spring11JuneBatch.di.School;
import com.codekul.Spring11JuneBatch.ioc.BubbleSort;
import com.codekul.Spring11JuneBatch.ioc.InsertionSort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring11JuneBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring11JuneBatchApplication.class, args);
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Spring11JuneBatchApplication.class, args);
//		BubbleSort bubbleSort = applicationContext.getBean(BubbleSort.class);
//		bubbleSort.sort();
//		bubbleSort.display();
//		InsertionSort insertionSort = applicationContext.getBean(InsertionSort.class);
//		insertionSort.display();
//		insertionSort.sort();
//
//		School school = applicationContext.getBean(School.class);
//		school.show();

	}

}
