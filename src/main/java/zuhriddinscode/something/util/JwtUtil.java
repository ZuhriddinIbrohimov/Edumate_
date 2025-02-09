package zuhriddinscode.something.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import zuhriddinscode.something.types.ProfileRole;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

public class JwtUtil {

    private static final int tokenLiveTime = 1000 * 3600 * 24; // 1-day
    private static final String secretKey = "veryLongSecretmazgillattayevlasharaaxmojonjinnijonsurbetbekkiydirhonuxlatdibekloxovdangasabekochkozjonduxovmashaynikmaydagapchishularnioqiganbolsangizgapyoqaniqsizmazgi";

    public static String encode(Integer id, List<ProfileRole> roleList) {   // bir nechta role bo'lsa
        String strRoles = roleList.stream().map(item -> item.name())
                .collect(Collectors.joining(","));

//  kengaytirilgan kodi yuqoeridagini (23-27)
//        List<String> stringList = new LinkedList<>();
//        for (ProfileRole role: roleList){
//            stringList.add(role.name());
//        }
//        String roleString = String.join(",", stringList);

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("roles", strRoles);

        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(String.valueOf(id))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (tokenLiveTime)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Integer decode(String token) {
        Claims claims = Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Integer id = Integer.valueOf(claims.getSubject());
        String strRole = (String) claims.get("role");
        //Role_User, Role_Admin
        String [] roleArray = strRole.split(",");
        List<ProfileRole> roleList = new ArrayList<>();
        for (String role : roleArray ){
            roleList.add(ProfileRole.valueOf(role));
        }


        ProfileRole role = ProfileRole.valueOf((String) claims.get("role"));



//        String strRoleList = (String) claims.get("role");

        return Integer.valueOf(claims.getSubject());
    }

    private static SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}