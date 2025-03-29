package com.ruoyi.train.mapper;

import java.util.List;
import com.ruoyi.train.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 用户Mapper接口
 *
 * @author me
 * @date 2025-03-13
 */
@Mapper
public interface UserMapper
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public User selectUserById(String id);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteUserById(String id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByIds(String[] ids);


    // 查询手机号是否已存在
    int checkPhoneExists(String phone);

    // 查询真实姓名是否已存在
    int checkRealNameExists(String realName);

    User selectUserByUserName(String username);

    @Update("UPDATE t_user SET password = #{newPassword} WHERE id = #{id}")
    int updatePassword(@Param("id") String id, @Param("newPassword") String newPassword);
}
