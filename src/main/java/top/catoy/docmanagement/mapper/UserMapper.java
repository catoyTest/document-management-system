package top.catoy.docmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.catoy.docmanagement.domain.User;

@Mapper
public interface UserMapper {
    User getUserByName(@Param("userName") String userName);
}
