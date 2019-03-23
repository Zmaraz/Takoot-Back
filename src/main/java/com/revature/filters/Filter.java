package com.revature.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.revature.models.Principal;
import com.revature.util.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Controller
public class Filter extends HttpFilter {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside of JwtAuthFilter.doFilter()");
		
		// 1. Get the HTTP header named "Authorization"
		String header = req.getHeader(JwtConfig.HEADER);
		
		// 2. Validate the header values and check the prefix
		if(header == null || !header.startsWith(JwtConfig.PREFIX)) {
			System.out.println("Request originates from an unauthenticated origin");
			
			// 2.1: If there is no header, or one that we provided, then go to the next step in the filter chain (target servlet)
			chain.doFilter(req, resp);
			return;
		}
		// 3. Get the token
		String token = header.replaceAll(JwtConfig.PREFIX, "");
		
		try {
			
			// 4. Validate the token
			Claims claims = Jwts.parser()
					.setSigningKey(JwtConfig.signingKey)
					.parseClaimsJws(token)
					.getBody();
			
			// 5. Obtain the principal/subject stored in the JWT
			Principal principal = new Principal();
			principal.setId(Integer.parseInt(claims.getId()));
			principal.setUsername(claims.getSubject());
			principal.setPassword(claims.get("password", String.class));
			
			
			// 6. Attach an attribute to the request indicating information about the principal
			req.setAttribute("principal", principal);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 7. Send the request to the next filter in the chain (target servlet)
		chain.doFilter(req, resp);
	}
	
}
