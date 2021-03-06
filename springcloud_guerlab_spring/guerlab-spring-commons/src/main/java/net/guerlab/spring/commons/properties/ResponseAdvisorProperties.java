package net.guerlab.spring.commons.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * http响应数据处理配置参数<br>
 * 符合以下条件之一将不会被包装成{@link net.guerlab.web.result.Result}类型<br>
 * <ul>
 * <li>请求路径符合排除列表前缀</li>
 * <li>使用了{@link net.guerlab.spring.commons.annotation.IgnoreResponseHandler}注解</li>
 * </ul>
 *
 * @author Wujun
 *
 */
@RefreshScope
@ConfigurationProperties("spring.response-advisor")
public class ResponseAdvisorProperties {

    /**
     * 排除路径
     */
    private List<String> excluded = new ArrayList<>();

    /**
     * 返回排除路径
     *
     * @return 排除路径
     */
    public List<String> getExcluded() {
        return excluded;
    }

    /**
     * 设置排除路径
     *
     * @param excluded
     *            排除路径
     */
    public void setExcluded(List<String> excluded) {
        if (excluded != null) {
            this.excluded = excluded;
        }
    }

    /**
     * 添加排除路径
     *
     * @param excluded
     *            排除路径
     */
    public void addExcluded(List<String> excluded) {
        this.excluded.addAll(excluded);
    }

    /**
     * 添加排除路径
     *
     * @param excluded
     *            排除路径
     */
    public void addExcluded(String... excluded) {
        this.excluded.addAll(Arrays.asList(excluded));
    }
}
