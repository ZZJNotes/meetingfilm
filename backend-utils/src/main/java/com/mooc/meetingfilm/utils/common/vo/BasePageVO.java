package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.ToolUtils;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.utils.common.vo
 * @description : 分页请求类
 **/
@Data
public class BasePageVO extends BaseRequestVO {

    private Integer nowPage = 1;
    private Integer pageSize = 10;

    @Override
    public void checkParam() throws CommonServiceException {

        // TODO nowpage和pageSize不能为空 balaba
        if (ToolUtils.strIsNull(nowPage.toString()) || ToolUtils.strIsNull(pageSize.toString()))
            throw new CommonServiceException(500, "页数不能为空");

    }
}
