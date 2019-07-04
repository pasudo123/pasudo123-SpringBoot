package edu.pasudo123.app.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author pasudo123
 * @since 2019-07-03
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */

@Getter
public class ErrorMessage {

    private LocalDateTime timestamp;
    private String status;
    private String message;
    private String details;

    /**
     * 에러 메세지 객체 생성 (빌드패턴)
     * @param timestamp : 발생 시각
     * @param status    : 상태코드
     * @param message   : 에러 메시지
     * @param details   : 에러 상세 내역
     */
    @Builder
    public ErrorMessage(LocalDateTime timestamp, String status, String message, String details){
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
