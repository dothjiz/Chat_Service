package com.doth.chat_service.io.entity;

import com.doth.chat_service.model.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "ChatMessage")
public class ChatMessage {
    @Id
    private String Id;
    private String chatId;
    private String recipientId;
    private String senderId;
    private String recipientName;
    private String senderName;
    private String content;
    private Date timestamp;
    private MessageStatus status;
}
