/*
 *     Copyright 2016-2026 TinyZ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ogcs.app;

import io.netty.channel.ChannelId;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple session manager.
 * Register session When the user's connection active. and unregister session when lost connection.
 *
 * @author TinyZ on 2015/10/27.
 */
public enum Sessions {

    INSTANCE;

    Sessions() {
        sessions = new ConcurrentHashMap<>();
    }

    private final ConcurrentHashMap<ChannelId, Session> sessions;

    public Session get(ChannelId id) {
        return sessions.get(id);
    }

    public void register(ChannelId id, Session session) {
        sessions.put(id, session);
    }

    public Session unregister(ChannelId id) {
        return sessions.remove(id);
    }
}
