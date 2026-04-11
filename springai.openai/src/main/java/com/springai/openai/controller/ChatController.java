package com.springai.openai.controller;

import com.springai.openai.entity.Tut;
import com.springai.openai.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q") String query) {
        return ResponseEntity.ok(this.chatService.chat1(query));
    }

    @GetMapping("/chat2")
    public ResponseEntity<Tut> chat2(@RequestParam(value = "q") String query) {
        return ResponseEntity.ok(this.chatService.chat2(query));
    }

    @GetMapping("/chat3")
    public ResponseEntity<List<Tut>> chat3(@RequestParam(value = "q") String query) {
        return ResponseEntity.ok(this.chatService.chat3(query));
    }

//    @GetMapping("/chat4")
//    public ResponseEntity<List<Tut>> chat4(@RequestParam(value = "q") String query) {
//        return ResponseEntity.ok(this.chatService.chat4(query));
//    }

}
