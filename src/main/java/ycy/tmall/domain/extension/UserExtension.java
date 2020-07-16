package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.Enumerated;
import ycy.tmall.domain.base.BaseDomain;



public class UserExtension extends BaseDomain {
    @Enumerated(var = "group_")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public enum Group{
        unLogin,user,admin,superAdmin;
    }
}
