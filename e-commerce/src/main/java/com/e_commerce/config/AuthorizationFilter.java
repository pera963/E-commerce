package com.e_commerce.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class AuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getServletPath().contains("/api/login") || request.getServletPath().contains("/api/customer/register")){
	          filterChain.doFilter(request, response);
	      }
	      else{
	          String authorizationHeader = request.getHeader("Authorization");
	          if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
	              try{
	                  String jwtToken = authorizationHeader.substring("Bearer ".length());
	                  Algorithm algorithm = Algorithm.HMAC256("secretKey".getBytes());
	                  JWTVerifier verifier = JWT.require(algorithm).build();
	                  DecodedJWT decodedJWT = verifier.verify(jwtToken);
	                  String email = decodedJWT.getSubject();
	                  String[] userRoles = decodedJWT.getClaim("role").asArray(String.class);
	                  Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
	                  authority.add(new SimpleGrantedAuthority(userRoles[0]));

	                  UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,null,authority);
	                  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	                  filterChain.doFilter(request, response);

	              } catch (Exception exception){
	                  response.setHeader("error", exception.getMessage());
	                  response.setStatus(403);
	                  Map<String,String> error = new HashMap<>();
	                  error.put("error",exception.getMessage());
	                  response.setContentType("application/json");
	                  new ObjectMapper().writeValue(response.getOutputStream(), error);
	              }
	          }
	          else{
	              filterChain.doFilter(request, response);
	          }
	      }

	

		
	}

}
