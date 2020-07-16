package ycy.tmall.service.interfaze;

import ycy.tmall.service.interfaze.base.BaseService;

import java.util.Map;

public interface IConfigService extends BaseService {
    /**
     * @return 获取参数的键值对
     * @throws Exception
     */
    public Map<String,String> map() throws Exception;

}
