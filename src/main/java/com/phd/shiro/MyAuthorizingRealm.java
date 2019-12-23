package com.phd.shiro;

import com.phd.entity.AdminInfo;
import com.phd.entity.AdminInfoExample;
import com.phd.entity.Role;
import com.phd.mapper.AdminInfoMapper;
import com.phd.mapper.RoleMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pahaied
 * @date 2019/12/10 14:21
 */
public class  MyAuthorizingRealm extends AuthorizingRealm {

    private final static Logger logger= LoggerFactory.getLogger(MyAuthorizingRealm.class);

    @Autowired
    private AdminInfoMapper adminInfoMapper;
    @Autowired
    private RoleMapper roleMapper;
    //shiro的权限配置方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        logger.info("权限配置-->doGetAuthorizationInfo");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        logger.info("----------------------------->"+principals.getPrimaryPrincipal());
        AdminInfo admin=(AdminInfo) principals.getPrimaryPrincipal();

        List<Role> roleList = roleMapper.selectAllByRolname(admin.getAno());
        for(int i = 0;i < roleList.size();i++) {
            String role_description = roleList.get(i).getRole_description();
            authorizationInfo.addRole(role_description);
        }
        logger.info("用户"+admin.getAname()+"具有的角色:"+authorizationInfo.getRoles());
//        logger.info("用户"+admin.getAname()+"具有的权限："+authorizationInfo.getStringPermissions());

        return authorizationInfo;
    }

    //shiro的身份验证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        logger.info("正在验证身份...");
        SimpleAuthenticationInfo info = null;

        //将token转换成AdminInfonamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //从转换后的token中获取用户名
        String adminAid = upToken.getUsername();
        logger.info("----->" + adminAid);

        //查询数据库，得到用户
        AdminInfoExample adminInfoExample = new AdminInfoExample();
        AdminInfoExample.Criteria criteria = adminInfoExample.createCriteria();
        criteria.andAnoEqualTo(adminAid);
//        List<AdminInfo> adminInfos = adminInfoMapper.selectByExample(adminInfoExample);
        AdminInfo admin = adminInfoMapper.selectByAdminByAid(adminAid);
        if(admin==null){
            return null;
        }

        //得到加密密码的盐值
//        ByteSource salt = ByteSource.Util.bytes(admin.getSalt());
////        logger.info("加密密码的盐："+salt);
//        //得到盐值加密后的密码：只用于方便数据库测试，后期不会用到。
//        Object md = new SimpleHash("MD5",upToken.getPassword(),salt,1024);
//        logger.info("盐值加密后的密码："+md);

        info = new SimpleAuthenticationInfo(
                admin, //用户名
                admin.getApwd(), //密码
//                salt, //加密的盐值
                getName()  //realm name
        );
        return info;
    }
}
