package com.springai.openai.service;

import com.springai.openai.entity.Tut;

import java.util.List;

public interface ChatService {

    String chat1(String query);

    Tut chat2(String query);

    List<Tut> chat3(String query);

    String chat4(String query);
}
