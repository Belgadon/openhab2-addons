/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.telegram.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link TelegramBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Jens Runge - Initial contribution
 */
@NonNullByDefault
public class TelegramBindingConstants {

    private static final String BINDING_ID = "telegram";

    // List of all Thing Type UIDs
    public static final ThingTypeUID TELEGRAM_THING = new ThingTypeUID(BINDING_ID, "telegramBot");

    // List of all Channel ids
    public static final String LASTMESSAGETEXT = "lastMessageText";
    public static final String LASTMESSAGEDATE = "lastMessageDate";
    public static final String LASTMESSAGENAME = "lastMessageName";
    public static final String LASTMESSAGEUSERNAME = "lastMessageUsername";
    public static final String REPLYID = "replyId";
}
