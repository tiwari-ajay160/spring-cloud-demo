package com.example.APIGateway.security;

import java.util.Arrays;
import java.util.List;import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.APIGateway.Beans.UserDetailsBean;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//		MappingJackson2HttpMessageConverter convertor=new MappingJackson2HttpMessageConverter();
//		convertor.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
//		restTemplate.setMessageConverters(Arrays.asList(convertor));
		UserDetailsBean user=restTemplate.getForObject("http://localhost:8091/login/getUser/"+arg0, UserDetailsBean.class);
		return org.springframework.security.core.userdetails.User.withUsername(user.getEmpId().toString()).password(user.getPassword()).roles(user.getRole()).build();
	}

}
