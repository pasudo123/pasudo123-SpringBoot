package edu.pasudo123.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 해당 설정파일이 존재함으로써,
 * Auditing Entity 를 활성화 시켜준다.
 * edu.pasudo123.app.common 패키지에 존재하는 TimeEntity 를 활성화 시킨다.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}
