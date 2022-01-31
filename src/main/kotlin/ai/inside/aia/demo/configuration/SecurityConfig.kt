package ai.inside.aia.demo.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        // Basic認証を無効化
        http?.authorizeRequests()?.anyRequest()?.permitAll()
        // CSRFを無効化
        http?.csrf()?.disable()
        // h2-consoleでフレームが表示できるようにする
        http?.headers()?.frameOptions()?.disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        // デフォルトのユーザを削除
        auth?.inMemoryAuthentication()
    }
}
