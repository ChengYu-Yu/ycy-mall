package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.UserMapper;
import ycy.tmall.domain.User;
import ycy.tmall.domain.UserExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IUserService;
import ycy.tmall.util.PasswordUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserExample> implements IUserService {
    @Override
    public Integer add(User rawUser) throws Exception {
        String rawPassword = rawUser.getPassword();
        rawUser.setPassword(PasswordUtil.encryptPassword(rawPassword));
        return super.add(rawUser);
    }

    @Override
    public boolean isExist(String username) throws Exception {
        return !list("name",username).isEmpty();
    }

    @Override
    public User get(String name, String password) throws Exception {

        return (User) getOne("name", name, "password", PasswordUtil.encryptPassword(password), "order", "id asc");
    }
}
