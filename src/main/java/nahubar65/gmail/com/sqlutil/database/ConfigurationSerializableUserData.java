package nahubar65.gmail.com.sqlutil.database;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationSerializableUserData extends UserDataImpl implements ConfigurationSerializable {
    public ConfigurationSerializableUserData(String password, String username, String ip, String port, String database, String jdbcUrl) {
        super(password, username, ip, port, database, jdbcUrl);
    }

    public ConfigurationSerializableUserData(Map<String, Object> objectMap) {
        this((String) objectMap.get("password"), (String) objectMap.get("username"), (String) objectMap.get("ip"), (String) objectMap.get("port"), (String) objectMap.get("database"), (String) objectMap.get("jdbcUrl"));
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("password", getPassword());
        objectMap.put("username", getUsername());
        objectMap.put("ip", getIp());
        objectMap.put("port", getPort());
        objectMap.put("database", getDatabase());
        objectMap.put("jdbcUrl", JDBC_URL);
        return objectMap;
    }
}
