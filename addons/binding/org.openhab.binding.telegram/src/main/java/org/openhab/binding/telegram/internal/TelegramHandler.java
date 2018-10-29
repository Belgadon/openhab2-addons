/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.telegram.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;

/**
 * The {@link TelegramHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Jens Runge - Initial contribution
 */
@NonNullByDefault
public class TelegramHandler extends BaseThingHandler {

    @Nullable
    private TelegramConfiguration config;

    public TelegramHandler(Thing thing) {
        super(thing);
    }

    @Nullable
    private String botName, botToken;
    @Nullable
    private List<Integer> chatIds;

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        // if (CHANNEL_1.equals(channelUID.getId())) {
        // if (command instanceof RefreshType) {
        // TODO: handle data refresh
        // }

        // TODO: handle command

        // Note: if communication with thing fails for some reason,
        // indicate that by setting the status with detail information:
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
        // "Could not control device at IP address x.x.x.x");
        // }
    }

    @SuppressWarnings("null")
    @Override
    public void initialize() {
        // logger.debug("Start initializing!");
        config = getConfigAs(TelegramConfiguration.class);

        // TODO: Initialize the handler.
        // The framework requires you to return from this method quickly. Also, before leaving this method a thing
        // status from one of ONLINE, OFFLINE or UNKNOWN must be set. This might already be the real thing status in
        // case you can decide it directly.
        // In case you can not decide the thing status directly (e.g. for long running connection handshake using WAN
        // access or similar) you should set status UNKNOWN here and then decide the real status asynchronously in the
        // background.

        // set the thing status to UNKNOWN temporarily and let the background task decide for the real status.
        // the framework is then able to reuse the resources from the thing handler initialization.
        // we set this upfront to reliably check status updates in unit tests.
        updateStatus(ThingStatus.ONLINE);
        botName = config.getBotUsername();
        botToken = config.getBotToken();
        chatIds = config.getChatIds();

        System.out.println(chatIds);
        /*
         * ApiContextInitializer.init();
         *
         * TelegramBotsApi botsApi = new TelegramBotsApi();
         *
         * try {
         * botsApi.registerBot(new TelegramBot(botToken, botName, chatIds, this));
         * updateStatus(ThingStatus.ONLINE);
         * } catch (TelegramApiException e) {
         * updateStatus(ThingStatus.OFFLINE);
         * }
         */
    }

    public void updateChannel(String channelName, String stateString) {
        State messageState = new StringType(stateString);
        updateState(new ChannelUID(getThing().getUID(), channelName), messageState);
    }
}
