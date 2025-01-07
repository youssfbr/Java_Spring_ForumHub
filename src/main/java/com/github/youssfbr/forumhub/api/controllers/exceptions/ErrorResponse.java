package com.github.youssfbr.forumhub.api.controllers.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp ,
        int status ,
        String error
) {
}
