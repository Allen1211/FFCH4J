package cc.eguid.commandManager;

import cc.eguid.commandManager.config.ProgramConfig;

import java.io.FileNotFoundException;
import java.io.IOException;

import static cc.eguid.commandManager.util.PropertiesUtil.load;

/**
 * @ClassName FFCH4J
 * @Description
 * @Author XianChuLun
 * @Date 2020/10/10
 * @Version 1.0
 */
public class FFCH4J {

    private static ProgramConfig config;

    private static CommandManager manager = null;

    public synchronized static CommandManager getManager(ProgramConfig aConfig) {
        if(manager != null) {
            return manager;
        }
        if (aConfig != null) {
            config = aConfig;
        } else {
            config = load("loadFFmpeg.properties", ProgramConfig.class);
        }
        if (config == null) {
            throw new RuntimeException("配置文件加载失败！配置文件不存在或配置错误");
        }
        manager = new CommandManagerImpl(config);
        return manager;
    }

    public static ProgramConfig config() {
        return config;
    }

}
