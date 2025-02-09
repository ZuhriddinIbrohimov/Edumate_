package zuhriddinscode.something.dto;

import zuhriddinscode.something.types.ProfileRole;

import java.util.List;

public class JwtDTO {
    private Integer id;
    private List<ProfileRole> roleList;

    public JwtDTO(Integer id, List<ProfileRole> roleList) {
        this.id = id;
        this.roleList = roleList;
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
