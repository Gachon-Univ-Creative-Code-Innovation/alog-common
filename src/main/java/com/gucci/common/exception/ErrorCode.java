package com.gucci.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 공용
    FAIL(HttpStatus.BAD_REQUEST,"요청에 실패했습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    INVALID_ARGUMENT(HttpStatus.BAD_REQUEST, "잘못된 요청 값입니다."),
    RATE_LIMIT(HttpStatus.TOO_MANY_REQUESTS,"너무 많은 요청이 발생했습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND,"값에 해당하는 리소스가 없습니다."),
    NO_PERMISSION(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    FILE_UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED,"Refresh Token이 유효하지 않습니다."),
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED,"Access Token이 유효하지 않습니다."),
    EXPIRATION_TOKEN(HttpStatus.UNAUTHORIZED,"만료된 토큰입니다."),

    // 로그인, 회원가입
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 이메일이 존재하지 않습니다."),
    EMPTY_EMAIL(HttpStatus.BAD_REQUEST,"이메일이 입력되지 않았습니다."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "이미 가입된 이메일입니다."),
    VERIFICATION_EXPIRED(HttpStatus.BAD_REQUEST, "인증 시간이 만료되었습니다."),
    FAIL_SEND_CODE(HttpStatus.INTERNAL_SERVER_ERROR,"인증 코드 전송에 실패했습니다."),
    INVALID_VERIFICATION_CODE(HttpStatus.BAD_REQUEST, "잘못된 인증 코드입니다."),
    VERIFICATION_CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "인증 코드를 찾을 수 없습니다."),
    EMAIL_NOT_VERIFIED(HttpStatus.BAD_REQUEST, "이메일 인증이 필요합니다. 먼저 이메일 인증을 완료해주세요."),
    EMAIL_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "이메일 발송에 실패했습니다."),
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "유효하지 않은 이메일입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    INVALID_EMAIL_FORMAT(HttpStatus.BAD_REQUEST,"잘못된 이메일 형식입니다."),
    SIGNUP_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "회원가입 처리 중 오류가 발생했습니다."),
    SIGNIN_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "로그인 처리 중 오류가 발생했습니다."),
    TEMP_PASSWORD_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "임시 비밀번호 발송에 실패했습니다."),
    PASSWORD_CHANGE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "비밀번호 변경에 실패했습니다."),

    // 블로그
    NOT_FOUND_POST(HttpStatus.NOT_FOUND,"해당하는 글이 없습니다."),
    NOT_FOUND_POST_CONTENT(HttpStatus.NOT_FOUND,"해당하는 글 본문이 없습니다.")
    ,NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND,"해당하는 댓글이 없습니다.")
    , POST_NO_PERMISSION(HttpStatus.BAD_REQUEST, "작성자만 수정할 수 있습니다")
    ,

    // 유저
    PROFILE_IMAGE_NOT_FOUND(HttpStatus.BAD_REQUEST, "프로필 사진이 없습니다."),

    // 팔로우
    FOLLOWER_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 팔로워가 존재하지 않습니다."),
    FOLLOWEE_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 팔로이가 존재하지 않습니다."),
    DUPLICATE_FOLLOW(HttpStatus.BAD_REQUEST,"이미 팔로우 중 입니다."),
    FOLLOWING_MYSELF(HttpStatus.BAD_REQUEST,"자신은 팔로우 할 수 없습니다."),
    FOLLOW_NOT_FOUND(HttpStatus.NOT_FOUND,"팔로우 목록에 없습니다.");


    private final HttpStatus httpStatus;
    private final String message;
}


