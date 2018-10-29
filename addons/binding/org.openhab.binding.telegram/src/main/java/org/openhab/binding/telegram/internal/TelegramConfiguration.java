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

/**
 * The {@link TelegramConfiguration} class contains fields mapping thing configuration parameters.
 *
 * @author Jens Runge - Initial contribution
 */
public class TelegramConfiguration {

    /**
     * Sample configuration parameter. Replace with your own.
     */
    private String botUsername, botToken;
    private List<Integer> chatIds;
    // private List chatIds;

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

    public List<Integer> getChatIds() {
        return chatIds;
    }

}
