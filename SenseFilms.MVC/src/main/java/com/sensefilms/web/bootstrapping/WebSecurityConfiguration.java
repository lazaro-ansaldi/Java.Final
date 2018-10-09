//ackage com.sensefilms.web.bootstrapping;
//
//mport org.springframework.context.annotation.Bean;
//mport org.springframework.context.annotation.Configuration;
//mport org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//mport org.springframework.security.config.annotation.web.builders.HttpSecurity;
//mport org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//mport org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//Configuration
//EnableWebSecurity
//ublic class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
//
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//       http
//           .authorizeRequests()
//               .antMatchers("/", "/home").permitAll()
//               .anyRequest().authenticated()
//               .and()
//           .formLogin()
//               .loginPage("/login")
//               .permitAll()
//               .and()
//           .logout()
//               .permitAll();
//   }
//
//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception 
//   {
//       auth
//       	.inMemoryAuthentication()
//       	.withUser("user1").password("user1Pass").roles("USER");
//   }
//
