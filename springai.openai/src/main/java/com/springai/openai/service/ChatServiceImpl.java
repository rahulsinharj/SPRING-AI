package com.springai.openai.service;

import com.springai.openai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    // TODO: Learn more in "Advisors".

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String chat(String query) {
        String prompt = "tell me about Virat Kohli";

//------[Normal calling the ChatResponse]-------------------------------------------
//      Call the LLM for the response:
//        String chatResponse = this.chatClient.prompt(prompt).call().content();
//        System.out.println(chatResponse);

//        return chatResponse;

//------[Calling the ChatResponse with user() and system() ]-------------------------------------------
//        String chatResponse = this.chatClient
//                .prompt()
//                .user(prompt)
//                .system("As an expert in cricket")
//                .call()
//                .content();

//        return chatResponse;

//------[Calling the ChatResponse with using Prompt Object]-------------------------------------------
//        Prompt prompt1 = new Prompt(query);
//
//        String chatResponse = this.chatClient
//                .prompt(prompt1)
//                .call()
//                .content();

//        return chatResponse;

//------[Calling the ChatResponse, and getting ChatResponse.ChatResponseMetadata]-------------------------------------------
        Prompt prompt1 = new Prompt(query);
//        var contentMetadata = this.chatClient
//                .prompt(prompt1)
//                .call()
//                .chatResponse()
//                .getMetadata();

//        return "";

//------[Calling the ChatResponse, and getting ChatResponse.Generation text]-----------------------------
        var content = this.chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();

        System.out.println(content);

        return content;
    }

    @Override
    public Tut chat2(String query) {
//------[Calling the ChatResponse, and getting ChatResponse.Generation in Entity format]-----------------------------
        Prompt prompt1 = new Prompt(query);

        Tut tutorialResponse = this.chatClient
                .prompt(prompt1)
                .call()
                .entity(Tut.class);

        System.out.println(tutorialResponse);

        return tutorialResponse;
    }


    @Override
    public List<Tut> chat3(String query) {
//------[Calling the ChatResponse, and getting ChatResponse.Generation in <List> of Entities format]-----------------------------
        Prompt prompt1 = new Prompt(query);

        List<Tut> tutorialResponse = this.chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });

        System.out.println(tutorialResponse);

        return tutorialResponse;
    }
}
