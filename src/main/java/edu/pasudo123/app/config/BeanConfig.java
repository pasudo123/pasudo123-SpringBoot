package edu.pasudo123.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pasudo123.app.util.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Bean 어노테이션을 통한 명시적으로 스프링 컨테이너에
 * 해당 객체를 빈으로 등록시킨다. @Configuration 과 @Bean 은 같이 쓰인다.
 */
@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        return modelMapper;
    }

    @Bean
    public ModelMapperUtils modelMapperUtils(){
        return new ModelMapperUtils(modelMapper());
    }
}
