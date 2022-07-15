package org.com.panorama.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

import org.com.panorama.service.impl.JwtUserDetailsService;
import org.com.panorama.utility.JwtTokenUtil;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	private static final Logger logger = LogManager.getLogger(JwtTokenFilter.class);
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private String username;
	private String token;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        
        if (header != null && header.startsWith("Bearer ")) {
			token = header.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				logger.error("Exception at doFilterInternal Unable to get JWT Token");
				logger.error(JwtTokenFilter.class, e);
				
			} catch (ExpiredJwtException e) {
				logger.error("Exception at doFilterInternal JWT Token has expired");
				logger.error(JwtTokenFilter.class, e);
			}
		} else {
			logger.info("Exception at doFilterInternal JWT Token does not begin with Bearer String");
			logger.info(JwtTokenFilter.class);
		}
        
		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			if (jwtTokenUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
		
}