package AWS_springboot.config.auth;


import AWS_springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOauth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()//antmatchers선행 메소드
                    .antMatchers("/","/css/**","/images/**","/js/**","h2-console/**").permitAll()//전체접근가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())//user사용자만 접근
                    .anyRequest().authenticated()//나머지url은 인증된 사용자에게만 접근가능하도록
                .and()
                    .logout()
                        .logoutSuccessUrl("/")

                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOauth2UserService);


    }



}
