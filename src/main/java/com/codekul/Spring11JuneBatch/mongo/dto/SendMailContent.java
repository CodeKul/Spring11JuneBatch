package com.codekul.Spring11JuneBatch.mongo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailContent {
   private String to;
   private String subject;
   private String content;
}
