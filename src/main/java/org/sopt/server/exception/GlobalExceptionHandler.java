package org.sopt.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.sopt.server.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ResponseDto<?>> handleIllegalArgumentException(final IllegalArgumentException e) {
        log.error("handle Illegal Argument Exception: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDto.fail(e), HttpStatus.BAD_REQUEST);
    }

    // @Validated 어노테이션을 사용하여 검증을 수행할 때 발생하는 예외
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ResponseDto<?>> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handle Argument Not Valid Exception: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDto.fail(e), HttpStatus.BAD_REQUEST);
    }

    // 메소드의 인자 타입이 일치하지 않을 때 발생하는 예외
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ResponseDto<?>> handleArgumentTypeMistmatchException(MethodArgumentTypeMismatchException e) {
        log.error("handle Method Argument Type Mismatch Exception: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDto.fail(e), HttpStatus.BAD_REQUEST);
    }

    // 필수 파라미터가 누락되었을 때 발생하는 예외
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ResponseEntity<ResponseDto<?>> handleMissingRequestParametersException(MissingServletRequestParameterException e) {
        log.error("handle Missing Servlet Request Params Exception: {}", e.getMessage());
        return new ResponseEntity<>(ResponseDto.fail(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<ResponseDto<?>> handleCommonException(final CommonException e) {
        log.error("handle Common Exception: {}", e.getMessage());
        e.printStackTrace();
        HttpStatus status = e.getErrorCode().getHttpStatus();
        return new ResponseEntity<>(ResponseDto.fail(status, e), status);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ResponseDto<?>> handleNotFoundException(final CommonException e) {
        log.error("handle NotFound Exception: {}", e.getMessage());
        e.printStackTrace();
        HttpStatus status = e.getErrorCode().getHttpStatus();
        return new ResponseEntity<>(ResponseDto.fail(status, e), status);
    }
}
