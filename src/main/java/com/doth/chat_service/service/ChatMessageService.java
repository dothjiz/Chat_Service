package com.doth.chat_service.service;

import com.doth.chat_service.io.entity.ChatMessage;
import com.doth.chat_service.model.MessageStatus;

import java.util.List;

public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);
    long countNewMessages(String senderId, String recipientId);
    List<ChatMessage> findChatMessages(String senderId, String recipientId);
    ChatMessage findById(String id);
    void updateStatuses(String senderId, String recipientId, MessageStatus status);

}
