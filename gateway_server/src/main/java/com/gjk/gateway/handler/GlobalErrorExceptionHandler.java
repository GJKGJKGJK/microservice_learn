package com.gjk.gateway.handler;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gjk.gateway.dto.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * GlobalErrorExceptionHandler
 * 用于网关的全局异常处理
 *
 *  @Order(-1)：优先级一定要比ResponseStatusExceptionHandler低
 * @author: gaojiankang
 * @date: 2022/9/27 16:33
 * @description:
 */
@Component
@Slf4j
@Order(-1)
@RequiredArgsConstructor
public class GlobalErrorExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper;


    @SuppressWarnings({"rawtypes", "unchecked", "NullableProblems"})
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {


            ServerHttpResponse response = exchange.getResponse();
            if (response.isCommitted()) {
                return Mono.error(ex);
            }

            // JOSN格式返回
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            if (ex instanceof ResponseStatusException) {
                response.setStatusCode(((ResponseStatusException) ex).getStatus());
            }

            return response.writeWith(Mono.fromSupplier(() -> {
                DataBufferFactory bufferFactory = response.bufferFactory();
                try {
                    //返回响应结果，根据业务需求，自己定制
                    Result<String> result = Result.createError(500, ex.getMessage());
                    return bufferFactory.wrap(objectMapper.writeValueAsBytes(result));
                }
                catch (JsonProcessingException e) {
                    log.error("Error writing response", ex);
                    return bufferFactory.wrap(new byte[0]);
                }
            }));
        }

}
