package com.gucci.common.response;

import com.gucci.common.exception.CustomException;
import com.gucci.common.exception.ErrorCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ApiResponseTest {

    @Test
    void 성공_응답이_정상적으로_생성된다() {
        //given
        String data = "test-data";

        //when
        ApiResponse<String> response = ApiResponse.success(data);

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
        assertThat(response.getMessage()).isEqualTo("요청이 성공적으로 처리되었습니다.");
        assertThat(response.getData()).isEqualTo("test-data");
    }

    @DisplayName("권한이 없는 경우의 실패 응답 정상 생성")
    @Test
    void 실패_응답이_정상적으로_생성된다() {
        //given
        String message = "권한이 없습니다.";

        //when
        ApiResponse<?> response = ApiResponse.error(ErrorCode.FORBIDDEN);

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.FORBIDDEN);
        assertThat(response.getMessage()).isEqualTo(message);

    }

    @DisplayName("CustomException 예외 정상 발생 확인")
    @Test
    void CustomException_예외_정상_발생_확인() {
        //when
        CustomException exception = assertThrows(CustomException.class, () ->{
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        });

        //then
        assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.UNAUTHORIZED);
        assertThat(exception.getMessage()).isEqualTo(ErrorCode.UNAUTHORIZED.getMessage());
        assertThat(exception.getErrorCode().getHttpStatus()).isEqualTo(ErrorCode.UNAUTHORIZED.getHttpStatus());


    }
}
