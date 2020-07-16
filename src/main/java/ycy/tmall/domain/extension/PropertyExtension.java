package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.domain.Category;
import ycy.tmall.domain.base.BaseDomain;

public class PropertyExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
