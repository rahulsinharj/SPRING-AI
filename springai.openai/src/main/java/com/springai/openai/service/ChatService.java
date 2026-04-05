package com.springai.openai.service;

import com.springai.openai.entity.Tut;

import java.util.List;

public interface ChatService {

    String chat(String query);

    Tut chat2(String query);

    List<Tut> chat3(String query);
}
