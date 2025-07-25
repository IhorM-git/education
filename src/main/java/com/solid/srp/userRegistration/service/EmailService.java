package com.solid.srp.userRegistration.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EmailService {

    @Inject
    Mailer mailer;

    public void send(String email) {
        mailer.send(
                Mail.withText(
                        email,
                        "Hello",
                        "Your email: " + email + " was registered successfully!"
                )
        );
    }
}
