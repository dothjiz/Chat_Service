package com.doth.chat_service.shared.dto;

import com.doth.chat_service.model.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessageDto implements Serializable {
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
