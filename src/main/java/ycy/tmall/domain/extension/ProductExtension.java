package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.annotation.ormAnnaotation.OneToMany;
import ycy.tmall.domain.Category;
import ycy.tmall.domain.ProductImage;
import ycy.tmall.domain.base.BaseDomain;

import java.util.List;

public class ProductExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne
    @JoinColumn(name="imgid")
    private ProductImage image;
    @OneToMany
    @JoinColumn(name="pid")
    private List<ProductImage> productImages;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }
}
