package org.assignment.app.component;

import java.util.Locale;

import org.assignment.common.MessageType;
import org.assignment.common.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author phuongnq
 * MessageHandler
 */
@Component
public class MessageHandler {

	@Autowired
	MessageSource messageSource;

	public Messages handleMessage(MessageType type, String code, String text) {
		
		Messages message = handleMessage(type, code);
		if(message.getMessage().isEmpty()) {
			message.setMessage(text);
		}
		return message;
	}

	public Messages handleMessage(MessageType type, String code) {
		Locale locale = LocaleContextHolder.getLocale();
		Messages message = new Messages();
		message.setType(type);
		if(code != null && !code.isEmpty()) {
			message.setMessage(messageSource.getMessage(code, null, locale));
		}
		return message;
	}

}
