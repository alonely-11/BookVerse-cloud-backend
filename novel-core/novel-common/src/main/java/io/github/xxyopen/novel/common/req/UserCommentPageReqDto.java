package io.github.xxyopen.novel.common.req;

import lombok.Data;

@Data
public class UserCommentPageReqDto extends PageReqDto{
    private Long userId;
}
