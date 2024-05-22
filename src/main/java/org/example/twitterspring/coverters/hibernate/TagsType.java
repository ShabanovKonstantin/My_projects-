package org.example.twitterspring.coverters.hibernate;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.util.List;

public class TagsType extends AbstractSingleColumnStandardBasicType<List<String>> {

    public TagsType() {
        super(VarcharTypeDescriptor.INSTANCE, TagsDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "TagsType";
    }
}
