package org.arithme.exo.mail;

import jakarta.mail.internet.InternetAddress;
import java.io.File;
import java.util.List;
import org.arithme.exo.PojaGenerated;

@PojaGenerated
public record Email(
    InternetAddress to,
    List<InternetAddress> cc,
    List<InternetAddress> bcc,
    String subject,
    String htmlBody,
    List<File> attachments) {}
