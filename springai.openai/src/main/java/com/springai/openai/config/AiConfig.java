package com.springai.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-5.4")
                        .temperature(0.5)
                        .maxTokens(100)
                        .build())
                .build();
    }

}
