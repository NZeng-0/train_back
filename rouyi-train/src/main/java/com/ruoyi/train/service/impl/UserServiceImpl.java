package com.ruoyi.train.service.impl;

import java.util.*;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ruoyi.train.mapper.UserMapper;
import com.ruoyi.train.domain.User;
import com.ruoyi.train.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户Service业务层处理
 *
 * @author me
 * @date 2025-03-13
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private com.ruoyi.framework.web.service.TokenService tokenService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Value("m91231e")
    private String secret;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户
     */
    @Override
    public List<User> selectUserList(User user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int insertUser(User user) {
        // 检查手机号是否已存在
        if (userMapper.checkPhoneExists(user.getPhone()) > 0) {
            throw new ServiceException("该手机号已被注册");
        }

        // 检查真实姓名是否已存在
        if (userMapper.checkRealNameExists(user.getRealName()) > 0) {
            throw new ServiceException("该真实姓名已被使用");
        }
        String encryptedPassword = SecurityUtils.encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        user.setCreateTime(DateUtils.getNowDate());
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int updateUser(User user) {
        user.setUpdateTime(DateUtils.getNowDate());
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String[] ids) {
        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    /**
     * 登录验证（去掉验证码校验，只验证用户名和密码）
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的 JWT Token
     */
    public String login(String username, String password) {
        // 查询用户信息
        User user = userMapper.selectUserByUserName(username);
        if (user == null) {
            throw new ServiceException("用户不存在");
        }

        // 校验密码
        if (!SecurityUtils.matchesPassword(password, user.getPassword())) {
            throw new UserPasswordNotMatchException();
        }

        // 记录登录信息
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, "登录成功"));
        recordLoginInfo(user.getId());
        // 生成 Token
        return createToken(user.getUsername());
    }

    public User getUserByName(String token){
        String username = getUsernameFromToken(token);
        return userMapper.selectUserByUserName(username);
    }

    /**
     * 记录用户登录信息
     */
    private void recordLoginInfo(String userId) {
        User user = new User();
        user.setId(userId);
        user.setUpdateTime(DateUtils.getNowDate());
        userMapper.updateUser(user);
    }

    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
