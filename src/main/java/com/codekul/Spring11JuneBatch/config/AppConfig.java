package com.codekul.Spring11JuneBatch.config;

import com.codekul.Spring11JuneBatch.di.School;
import com.codekul.Spring11JuneBatch.ioc.BubbleSort;
import com.codekul.Spring11JuneBatch.ioc.InsertionSort;
import com.codekul.Spring11JuneBatch.ioc.SortingTechniques;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SortingTechniques getBubbleSort(){
        return new BubbleSort();
    }

    @Bean
    public SortingTechniques getInsertionSort(){
        return new InsertionSort();
    }

}
