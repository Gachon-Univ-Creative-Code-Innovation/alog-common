package com.gucci.common.exception;

import ch.qos.logback.core.status.ErrorStatus;
import com.gucci.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * CustomException이 발생했을 때,
     * 해당 ErrorCode를 꺼내서 ApiResponse.error(...) 형태로 클라이언트에 응답합니다.
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException ex) {
        ErrorCode code = ex.getErrorCode();

        ApiResponse<Void> response = ApiResponse.error(code);
        // 예를 들어, NOT_FOUND_POST라면 response 는 status=404, message="게시글을 찾을 수 없습니다.", data=null
        return ResponseEntity
                .status(code.getHttpStatus())
                .body(response);
    }

    /**
     * 그 외 일반적인 비즈니스 예외나, 예상치 못한 예외를 처리하고 싶다면 아래와 같은 핸들러를 추가로 작성할 수 있습니다.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleOtherExceptions(Exception ex) {
        // 로그를 남기고, 500 서버 에러 응답을 돌려줄 수도 있습니다.
        ApiResponse<Void> response = ApiResponse.error(/* 예: ErrorCode.FAIL */);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

}
