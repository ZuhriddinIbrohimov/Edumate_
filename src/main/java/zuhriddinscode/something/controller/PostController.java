package zuhriddinscode.something.controller;

import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zuhriddinscode.something.dto.PostDTO;
import zuhriddinscode.something.util.SpringSecurityUtil;

@RestController
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/create")
    public String create(@RequestBody PostDTO dto){
        System.out.println(SpringSecurityUtil.getCurrentProfile());
        System.out.println(SpringSecurityUtil.getCurrentUserId());
        return "Done";
    }
}