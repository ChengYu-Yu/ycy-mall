package ycy.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ycy.tmall.dao.PropertyValueMapper;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.Property;
import ycy.tmall.domain.PropertyValue;
import ycy.tmall.domain.PropertyValueExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IPropertyService;
import ycy.tmall.service.interfaze.IPropertyValueService;

import java.util.List;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl<PropertyValueMapper, PropertyValueExample> implements IPropertyValueService {
    @Autowired
    IPropertyService propertyService;

@Override
    public void init(Product product) throws Exception {
        List<Property> properties = propertyService.list("cid", product.getCategory().getId());
        for (Property property: properties) {
            try {
                PropertyValue propertyValue= (PropertyValue) list("ptid",property.getId(),"pid",product.getId());
            }catch (Exception e){
                //对应字段为空
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setValue("");
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                add(propertyValue);
            }
        }
    }
}
