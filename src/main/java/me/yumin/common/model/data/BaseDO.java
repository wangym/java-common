package me.yumin.common.model.data;

import lombok.Getter;
import lombok.Setter;
import me.yumin.common.model.BaseModel;
import java.util.Date;

/**
 * @author chinawym@gmail.com
 * @since 2016-01-06
 */
public abstract class BaseDO extends BaseModel {
    private static final long serialVersionUID = -8673404570046804823L;

    @Getter
    private Date gmtCreate; // 首次创建

    @Getter
    private Date gmtModified; // 最后修改

    @Getter
    @Setter
    private Integer rowVersion; // 行版本号

    @Getter
    private Integer rowStatus; // 管理状态

    @Getter
    @Setter
    private Integer bizType; // 业务类型
}
