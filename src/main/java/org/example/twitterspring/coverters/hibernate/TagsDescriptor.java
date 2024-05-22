package org.example.twitterspring.coverters.hibernate;

import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagsDescriptor extends AbstractTypeDescriptor<List<String>> {

    public final static TagsDescriptor INSTANCE = new TagsDescriptor();

    protected TagsDescriptor() {
        super((Class<List<String>>) (Class<?>) List.class);
    }

    @Override
    public List<String> fromString(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return new ArrayList<>();
        }

        return List.of(s.split(", "));
    }

    @Override
    public <X> X unwrap(List<String> strings, Class<X> aClass, WrapperOptions wrapperOptions) {
        if (Objects.isNull(strings) || strings.isEmpty()) {
            return null;
        }

        String dbNote = strings.toString().replace("[", "").replace("]", "");
        return (X) dbNote;
    }

    @Override
    public <X> List<String> wrap(X x, WrapperOptions wrapperOptions) {
        return fromString(x.toString());
    }
}
