package org.anvilpowered.anvil.core.nukkit.module;

import cn.nukkit.command.CommandSender;
import com.google.inject.TypeLiteral;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.anvilpowered.anvil.core.common.module.CommonModule;
import org.anvilpowered.anvil.core.common.plugin.AnvilCorePluginInfo;

import java.io.File;
import java.nio.file.Paths;

public class NukkitModule extends CommonModule<String, CommandSender> {

    @Override
    protected void configure() {
        super.configure();

        File configFilesLocation = Paths.get("plugins/" + AnvilCorePluginInfo.id).toFile();
        if (!configFilesLocation.exists()) {
            if (!configFilesLocation.mkdirs()) {
                throw new IllegalStateException("Unable to create config directory");
            }
        }
        bind(new TypeLiteral<ConfigurationLoader<CommentedConfigurationNode>>() {
        }).toInstance(HoconConfigurationLoader.builder().setPath(Paths.get(configFilesLocation + "/anvil.conf")).build());
    }
}
