package com.ngportfolio.services.serviceImp;

import com.ngportfolio.entities.Message;
import com.ngportfolio.repositories.MessageRepository;
import com.ngportfolio.services.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepo;

    @Override
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    @Override
    public Message getById(Long id) {
        return messageRepo.findById(id).orElseThrow();
    }

    @Override
    public Message save(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message update(Long id, Message message) {
        Message existing = messageRepo.findById(id).orElseThrow();
        existing.setSenderName(message.getSenderName());
        existing.setSenderEmail(message.getSenderEmail());
        existing.setSenderContact(message.getSenderContact());
        existing.setSubject(message.getSubject());
        existing.setContent(message.getContent());
        return messageRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        messageRepo.deleteById(id);
    }
}
