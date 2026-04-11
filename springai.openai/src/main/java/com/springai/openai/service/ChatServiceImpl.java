package com.springai.openai.service;

import com.springai.openai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    // TODO: Learn more in "Advisors".

    private final ChatClient chatClient;

//---[Constructor injection of the ChatClient using OpenAiChatModel]--------------------------
//    public ChatServiceImpl(OpenAiChatModel openAiChatModel) {
//        this.chatClient = ChatClient.create(openAiChatModel);
//    }

    //---[Constructor injection of the ChatClient using ChatClient.Builder]-----------------------
    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String chat1(String query) {
        String prompt = "tell me about Virat Kohli";

//------[Normal calling the ChatClient : Call the LLM for the normal response]------------------------
        String chatResponse = this.chatClient
                .prompt(prompt)
                .call()
                .content();
//
//        System.out.println(chatResponse);
//
//        return chatResponse;

//------[Calling the ChatClient with user() and system() ]-------------------------------------------
//        String chatResponse = this.chatClient
//                .prompt()
//                .user(prompt)
//                .system("As an expert in cricket")
//                .call()
//                .content();

//        return chatResponse;

//------[Calling the ChatClient with using Prompt Object]-------------------------------------------
//        Prompt prompt1 = new Prompt(query);
//
//        String chatResponse = this.chatClient
//                .prompt(prompt1)
//                .call()
//                .content();

//        return chatResponse;

//------[Calling the ChatClient, and getting ChatResponse.ChatResponseMetadata]-------------------------------------------
        Prompt prompt1 = new Prompt(query);
//        var contentMetadata = this.chatClient
//                .prompt(prompt1)
//                .call()
//                .chatResponse()
//                .getMetadata();

//        return "";

//------[Calling the ChatClient, and getting ChatResponse.Generation text]-----------------------------
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
//------[Calling the ChatClient, and getting ChatResponse.Generation in Entity format]-----------------------------
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
//------[Calling the ChatClient, and getting ChatResponse.Generation in <List> of Entities format]-----------------------------
        Prompt prompt1 = new Prompt(query);

        List<Tut> tutorialResponse = this.chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });

        System.out.println(tutorialResponse);

        return tutorialResponse;
    }

    @Override
    public String chat4(String query) {
//------[Calling the ChatClient, and passing some ChatOptions parameters via Prompt obj]-----------------------------
        Prompt prompt1 = new Prompt(query, OpenAiChatOptions.builder()
                .model("gpt-5.4")
                .temperature(0.5)
                .maxTokens(100)
                .build());
        var contentMetadata = this.chatClient
                .prompt(prompt1)
                .call()
                .content();

        System.out.println(contentMetadata);

        return contentMetadata;
    }

}
