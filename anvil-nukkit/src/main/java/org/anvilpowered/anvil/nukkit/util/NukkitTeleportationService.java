/*
 *   Anvil - AnvilPowered
 *   Copyright (C) 2020 Cableguy20
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anvilpowered.anvil.nukkit.util;

import cn.nukkit.Player;
import com.google.inject.Inject;
import org.anvilpowered.anvil.api.util.TeleportationService;
import org.anvilpowered.anvil.api.util.UserService;

import java.util.Optional;
import java.util.UUID;

public class NukkitTeleportationService implements TeleportationService {

    @Inject
    protected UserService<Player, Player> userService;

    @Override
    public boolean teleport(UUID teleportingUserUUID, UUID targetUserUUID) {
        final Optional<Player> teleporter = userService.get(teleportingUserUUID);
        final Optional<Player> target = userService.get(targetUserUUID);

        if(!teleporter.isPresent() || !target.isPresent()) {
            return false;
        }
        return teleporter.get().teleport(target.get().getLocation());
    }
}
