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

package org.anvilpowered.anvil.nukkit.module;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import com.google.inject.TypeLiteral;
import org.anvilpowered.anvil.api.util.KickService;
import org.anvilpowered.anvil.api.util.StringResult;
import org.anvilpowered.anvil.api.util.TeleportationService;
import org.anvilpowered.anvil.api.util.UserService;
import org.anvilpowered.anvil.common.module.ApiCommonModule;
import org.anvilpowered.anvil.nukkit.util.NukkitKickService;
import org.anvilpowered.anvil.nukkit.util.NukkitStringResult;
import org.anvilpowered.anvil.nukkit.util.NukkitTeleportationService;
import org.anvilpowered.anvil.nukkit.util.NukkitUserService;

public class ApiNukkitModule extends ApiCommonModule {

    @Override
    protected void configure() {
        super.configure();
        bind(KickService.class).to(NukkitKickService.class);
        bind(new TypeLiteral<StringResult<String, CommandSender>>() {
        }).to(NukkitStringResult.class);
        bind(TeleportationService.class).to(NukkitTeleportationService.class);
        bind(new TypeLiteral<UserService<Player, Player>>() {
        }).to(NukkitUserService.class);
    }
}
