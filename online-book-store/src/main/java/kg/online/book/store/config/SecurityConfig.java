package kg.online.book.store.config;

import kg.online.book.store.filter.JwtFilter;
import kg.online.book.store.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/api/user/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/api/author").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/author/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/author/**").permitAll()

                .antMatchers(HttpMethod.POST, "/api/image/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/image/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/image/hello").permitAll()

                .antMatchers(HttpMethod.GET,"/api/product").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/product/isAvailable").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/product/discount").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/product").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/product/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/api/genre").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/genre/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/genre").permitAll()

                .antMatchers(HttpMethod.GET, "/api/cart_item/mine").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/api/cart_item/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/api/delivery_method").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/delivery_method").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/delivery_method").permitAll()

                .antMatchers(HttpMethod.POST, "/api/payment_method").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/payment_method").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/payment_method").permitAll()

                .antMatchers(HttpMethod.GET, "/api/contacts/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/api/ordered_product").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/api/order").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/order/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/order/user_acc").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/order/products_cost").hasRole("ADMIN")

                .antMatchers("/api/bill/**").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
