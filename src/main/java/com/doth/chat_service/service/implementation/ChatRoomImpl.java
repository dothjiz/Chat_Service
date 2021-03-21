package com.doth.chat_service.service.implementation;

import com.doth.chat_service.io.entity.ChatRoom;
import com.doth.chat_service.repository.ChatRoomRepository;
import com.doth.chat_service.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ChatRoomImpl implements ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Override
    public Optional<String> getChatId(
            String senderId, String recipientId, boolean createIfNotExist) {

        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(!createIfNotExist) {
                        return  Optional.empty();
                    }
                    var chatId =
                            String.format("%s_%s", senderId, recipientId);

                    ChatRoom senderRecipient = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(senderId)
                            .recipientId(recipientId)
                            .build();

                    ChatRoom recipientSender = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(recipientId)
                            .recipientId(senderId)
                            .build();
                    chatRoomRepository.save(senderRecipient);
                    chatRoomRepository.save(recipientSender);

                    return Optional.of(chatId);
                });
    }
}
