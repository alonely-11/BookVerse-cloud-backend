package io.github.xxyopen.novel.user.manager.feign;

import io.github.xxyopen.novel.book.dto.req.BookCommentReqDto;
import io.github.xxyopen.novel.book.feign.BookFeign;
import io.github.xxyopen.novel.common.auth.UserHolder;
import io.github.xxyopen.novel.common.req.PageReqDto;
import io.github.xxyopen.novel.common.req.UserCommentPageReqDto;
import io.github.xxyopen.novel.common.resp.PageRespDto;
import io.github.xxyopen.novel.common.resp.RestResp;
import io.github.xxyopen.novel.user.dto.resp.UserCommentRespDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 小说微服务调用 Feign 客户端管理
 *
 * @author xiongxiaoyang
 * @date 2023/3/29
 */
@Component
@AllArgsConstructor
@Slf4j
public class BookFeignManager {

    private final BookFeign bookFeign;

    public RestResp<Void> publishComment(BookCommentReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return bookFeign.publishComment(dto);
    }

    public RestResp<Void> updateComment(BookCommentReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return bookFeign.updateComment(dto);
    }

    public RestResp<Void> deleteComment(BookCommentReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return bookFeign.deleteComment(dto);
    }

    public RestResp<PageRespDto<UserCommentRespDto>> listComments(UserCommentPageReqDto dto) {
        dto.setUserId(UserHolder.getUserId());
        return bookFeign.listComments(dto);
    }
}
