package com.study.hello;

import jakarta.validation.constraints.NotBlank;

public record CreateTodoRequest(
        @NotBlank(message = "제목은 필수입니다")
        String title
) {}