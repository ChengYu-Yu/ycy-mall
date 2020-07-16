package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.ConfigMapper;
import ycy.tmall.domain.Config;
import ycy.tmall.domain.ConfigExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl extends BaseServiceImpl<ConfigMapper, ConfigExample> implements IConfigService {
    @Override
    public Map<String, String> map() throws Exception {
        List<Config>  configs = list();
        Map<String, String> configMap = new HashMap<>();
        for (Config config : configs) {
            configMap.put(config.getName(),config.getValue());

        }
        return configMap;
    }
}
