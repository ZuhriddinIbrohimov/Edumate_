package zuhriddinscode.something.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zuhriddinscode.something.entity.ProfileEntity;
import zuhriddinscode.something.types.GeneralStatus;
import zuhriddinscode.something.types.ProfileRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private Integer id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private GeneralStatus status;

    public CustomUserDetails(ProfileEntity profile,
                             List<ProfileRole> roleList) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.username = profile.getUsername();
        this.surname = profile.getSurname();
        this.password = profile.getPassword();

//        List <SimpleGrantedAuthority> roles = new ArrayList<>();
//        for (ProfileRole role : roleList){
//             roles.add(new SimpleGrantedAuthority(role.name()));
//        }
//        this.authorities = roles;
        this.authorities = roleList.stream().map(item -> new SimpleGrantedAuthority(item.name())).toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status.equals(GeneralStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    } // o'chirilmaganmi visible

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}