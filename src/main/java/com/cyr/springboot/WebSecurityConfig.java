package com.cyr.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {//重写请求拦截
        http.csrf().disable().authorizeRequests()//通过authorizeRequests开始请求权限配置
                .antMatchers("/","/login","/chat").permitAll()//设置对/和/login路径不拦截，使用ant风格的路径匹配
                /*.anyRequest().authenticated()*/ //anyRequst:匹配所有路径，其余所有请求都需要认证后访问
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/chat").permitAll()
                .and()
                .rememberMe()//开启cookie
                .tokenValiditySeconds(12096000)//cookie有效期，1209600秒，2星期
                .key("mycookie")
                .and()
                .logout()//定制注销行为
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//在内存中配置两个用户
        auth.inMemoryAuthentication()
                .withUser("cyr").password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("chenyr").password(passwordEncoder().encode("123456")).roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {//resources/static目录下的静态资源,spring Security不拦截
        web.ignoring().antMatchers("/resources/static/**");
    }

}
