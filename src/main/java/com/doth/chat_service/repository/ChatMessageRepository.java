package com.doth.chat_service.repository;

import com.doth.chat_service.io.entity.ChatMessage;
import com.doth.chat_service.model.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}
