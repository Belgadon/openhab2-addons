/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.telegram.bot;

import static org.openhab.binding.telegram.internal.TelegramBindingConstants.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openhab.binding.telegram.internal.TelegramHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * The class defines common constants, which are
 * used across the whole binding.
 *
 * @author Jens Runge - Initial contribution
 */
public class TelegramBot extends TelegramLongPollingBot {
    String botToken, botUsenName;
    List<Integer> chatIds;
    TelegramHandler telegramHandler;

    public TelegramBot(String botToken, String botUsenName, List<Integer> chatIds, TelegramHandler telegramHandler) {
        this.botToken = botToken;
        this.botUsenName = botUsenName;
        this.telegramHandler = telegramHandler;
        this.chatIds = chatIds;
    }

    @Override
    public String getBotUsername() {
        // TODO Auto-generated method stub
        return botUsenName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(chatIds.toString());
        if (update.hasMessage() && update.getMessage().hasText()
        /* && update.getMessage().getChatId().intValue() == chatIds */) {
            String lastMessageText = update.getMessage().getText();
            String lastMessageDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                    .format(new Date(update.getMessage().getDate().longValue() * 1000));
            String lastMessageName = update.getMessage().getFrom().getFirstName() + " "
                    + update.getMessage().getFrom().getLastName();
            String lastMessageUsername = update.getMessage().getFrom().getUserName();

            telegramHandler.updateChannel(LASTMESSAGETEXT, lastMessageText);
            telegramHandler.updateChannel(LASTMESSAGEDATE, lastMessageDate);
            telegramHandler.updateChannel(LASTMESSAGENAME, lastMessageName);
            telegramHandler.updateChannel(LASTMESSAGEUSERNAME, lastMessageUsername);

        } else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage().hasText()
        /* && update.getCallbackQuery().getMessage().getChatId().intValue() == chatIds */) {

            String lastMessageText = update.getCallbackQuery().getData();
            String lastMessageDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(System.currentTimeMillis());
            String lastMessageName = update.getCallbackQuery().getFrom().getFirstName() + " "
                    + update.getCallbackQuery().getFrom().getLastName();
            String lastMessageUsername = update.getCallbackQuery().getMessage().getFrom().getUserName();

            telegramHandler.updateChannel(LASTMESSAGETEXT, lastMessageText);
            telegramHandler.updateChannel(LASTMESSAGEDATE, lastMessageDate);
            telegramHandler.updateChannel(LASTMESSAGENAME, lastMessageName);
            telegramHandler.updateChannel(LASTMESSAGEUSERNAME, lastMessageUsername);
        }

    }

    @Override
    public String getBotToken() {
        // TODO Auto-generated method stub
        return botToken;
    }

}
