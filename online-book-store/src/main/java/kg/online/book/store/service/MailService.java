package kg.online.book.store.service;

public interface MailService {
    Boolean send(String toEmail, String subject, String text);
}
