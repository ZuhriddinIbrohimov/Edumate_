package zuhriddinscode.something.dto;

import zuhriddinscode.something.types.ProfileRole;

import java.util.List;

public class JwtDTO {
    private Integer id;
    private List<ProfileRole> roleList;
    private String username;

    public JwtDTO(Integer id, List<ProfileRole> roleList, String username) {
        this.id = id;
        this.roleList = roleList;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProfileRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<ProfileRole> roleList) {
        this.roleList = roleList;
    }
}
