package masterdev.br.com.zup.security;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BcryptUtils {
    private static BcryptUtils bcryptUtils;
    private  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static BcryptUtils getInstance(){
        return bcryptUtils == null ? (bcryptUtils = new BcryptUtils()) : bcryptUtils;
    }
    public String hash(String password) {
        System.out.println(encoder);
        return  encoder.encode(password);
    }
    public boolean matches(String password, String hash) {
        return encoder.matches(password,hash);
    }
}
