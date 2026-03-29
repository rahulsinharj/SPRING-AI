package com.springai.ollama.service;

import com.springai.ollama.entity.Tut;

import java.util.List;

public interface ChatService {

    String chat(String query);

    Tut chat2(String query);

    List<Tut> chat3(String query);
}
