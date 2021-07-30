package com.zamar.www.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

   @Test
    public void 롬복_기능_테스트(){

       //given
       String name = "zamar";
       int amount = 3000;

       //when
       HelloResponseDto dto = new HelloResponseDto(name, amount);

       //then
       assertThat(dto.getName()).isEqualTo(name);
       assertThat(dto.getAmount()).isEqualTo(amount);

       //assertThat = 테스트 검증 라이브러리의 검증 메소드
   }
}
