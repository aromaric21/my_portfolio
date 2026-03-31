package com.ngportfolio.services.service;

import com.ngportfolio.entities.Message;

import java.util.List;

public interface MessageService {

    // Message List
    List<Message> getAllMessages();
    // Search a message
    Message getById(Long id);
    // Create a message
    Message save(Message message);
    // Update message
    Message update(Long id, Message message);
    // Delete message
    void delete(Long id);
}
