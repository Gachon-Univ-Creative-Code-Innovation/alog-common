package com.gucci.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    OK(HttpStatus.OK, "요청이 성공적으로 처리되었습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다."),
    UPLOAD_SUCCESS(HttpStatus.OK, "파일 업로드에 성공했습니다."),
    GET_PROFILE_SUCCESS(HttpStatus.OK, "프로필 이미지 조회에 성공했습니다."),
    ALIVE_SERVER(HttpStatus.OK,"서버가 작동 중 입니다."),
    LIKE_ADDED(HttpStatus.OK, "좋아요가 추가되었습니다."),
    LIKE_REMOVED(HttpStatus.OK, "좋아요가 취소되었습니다."),
    EMAIL_VERIFICATION_SENT(HttpStatus.OK, "인증 메일이 발송되었습니다."),
    EMAIL_VERIFIED(HttpStatus.OK, "이메일 인증이 완료되었습니다"),
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),
    SIGNIN_SUCCESS(HttpStatus.OK, "로그인이 성공적으로 완료되었습니다."),
    TEMP_PASSWORD_EMAIL_SENT(HttpStatus.OK, "임시 비밀번호가 이메일로 발송되었습니다."),
    PASSWORD_CHANGED(HttpStatus.OK, "비밀번호가 성공적으로 변경되었습니다."),
    VALIDATION_SUCCESS(HttpStatus.OK, "검증이 성공적으로 완료되었습니다."),
    DATA_FETCHED(HttpStatus.OK, "데이터 조회에 성공했습니다."),
    REGENERATE_ACCESS_TOKEN(HttpStatus.CREATED,"Access Token이 재발급 되었습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String message;
}
