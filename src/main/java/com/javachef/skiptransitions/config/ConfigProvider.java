package com.javachef.skiptransitions.config;

import com.mojang.datafixers.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ConfigProvider implements SimpleConfig.DefaultConfig {
    
    private String configContents = "";
    
    private final List<Pair> configsList = new ArrayList<>();
    
    
    public void addKeyValuePair(Pair<String, ?> keyValuePair) {
        configsList.add(keyValuePair);
        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + "\n";
    }
    
    public void append(String string) {
        configContents += string + "\n";
    }
    
    @Override
    public String get(String namespace) {
        return configContents;
    }
}
