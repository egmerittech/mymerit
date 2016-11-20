package com.github.egmerittech.web.event;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.github.egmerittech.model.EmailToken;
import com.github.egmerittech.model.User;
import com.github.egmerittech.repository.EmailTokenRepository;

/**
 * @author Greg Baker
 */
public class SignupEventListener implements ApplicationListener<SignupEvent> {

	public static final int EXPIRY_TIME_DAYS_DEFAULT = 14;


	protected MailSender mailSender;


	protected EmailTokenRepository emailTokenRepository;


	protected boolean sendVerificationEmail;


	protected int expiryTimeDays = EXPIRY_TIME_DAYS_DEFAULT;


	public SignupEventListener(MailSender mailSender, EmailTokenRepository emailTokenRepository) {
		this.mailSender = mailSender;
		this.emailTokenRepository = emailTokenRepository;
	}


	@Override
	public void onApplicationEvent(SignupEvent event) {
		if (sendVerificationEmail == false) { return; }

		final User user = event.getUser();
		final String url = event.getUrl();

		final EmailToken emailToken = new EmailToken();
		emailToken.setToken(UUID.randomUUID().toString());
		emailToken.setUser(user);

		final Calendar expiryDate = Calendar.getInstance();
		expiryDate.add(Calendar.DAY_OF_YEAR, expiryTimeDays);
		emailToken.setExpiryDate(expiryDate);

		emailTokenRepository.save(emailToken);

		final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getUsername());
		simpleMailMessage.setFrom("example@example.com");
		simpleMailMessage.setSubject("Therapie - confirm registration");
		simpleMailMessage.setText("Successfully registered.. here's your confirmation token: " + url + "/validate-email?token=" + emailToken.getToken());
		mailSender.send(simpleMailMessage);
	}


	public void setExpiryTimeDays(int expiryTimeDays) {
		this.expiryTimeDays = expiryTimeDays;
	}


	public void setSendVerificationEmail(boolean sendVerificationEmail) {
		this.sendVerificationEmail = sendVerificationEmail;
	}

}
