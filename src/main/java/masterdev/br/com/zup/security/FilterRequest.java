package masterdev.br.com.zup.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@Component
//@Order(1)
@Component
public class FilterRequest implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (httpRequest.getServletPath().startsWith("/user")) {
            // requisição para criar player
            chain.doFilter(request, response);
            return;
        }

        if (httpRequest.getServletPath().startsWith("/user/login")) {
            // requisicao para login
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader("token");
        if (token == null) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        try {

            String jwt = token;

            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(JwtUtils.key))
                    .parseClaimsJws(jwt).getBody();
            httpRequest.setAttribute("idGame",claims.get("id"));

            // chamada autenticada
            chain.doFilter(request, response);
        } catch (SignatureException s) {
            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}

