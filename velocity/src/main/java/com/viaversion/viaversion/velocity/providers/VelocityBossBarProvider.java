/*
 * This file is part of ViaVersion - https://github.com/ViaVersion/ViaVersion
 * Copyright (C) 2016-2023 ViaVersion and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.viaversion.viaversion.velocity.providers;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.BossBarProvider;
import com.viaversion.viaversion.velocity.storage.VelocityStorage;
import java.util.UUID;

public class VelocityBossBarProvider extends BossBarProvider {
    @Override
    public void handleAdd(UserConnection user, UUID barUUID) {
        if (user.has(VelocityStorage.class)) {
            VelocityStorage storage = user.get(VelocityStorage.class);
            // Check if bossbars are supported by bungee, static maybe
            if (storage.getBossbar() != null) {
                storage.getBossbar().add(barUUID);
            }
        }
    }

    @Override
    public void handleRemove(UserConnection user, UUID barUUID) {
        if (user.has(VelocityStorage.class)) {
            VelocityStorage storage = user.get(VelocityStorage.class);
            if (storage.getBossbar() != null) {
                storage.getBossbar().remove(barUUID);
            }
        }
    }
}
