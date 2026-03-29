package com.springai.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SingleAiLLMController {

    private final ChatClient chatClient;

//    public ChatController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
//        this.chatClient = chatClient;
//    }

    public SingleAiLLMController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


//    @GetMapping("/chatsingle")
    public ResponseEntity<String> chat(@RequestParam(value = "q") String query) {

        String chatResponse = this.chatClient.prompt(query).call().content();
        return ResponseEntity.ok(chatResponse);

    }
}
