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
    private Date gmtCreate;

    @Getter
    private Date gmtModified;

    @Getter
    @Setter
    private Integer rowVersion;

    @Getter
    private Integer rowStatus;

    @Getter
    @Setter
    private Long bizType;
}
