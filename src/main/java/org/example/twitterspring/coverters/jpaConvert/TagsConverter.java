package org.example.twitterspring.coverters.jpaConvert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class TagsConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        String result = attribute.toString();
        result = result.replace("[", "");
        result = result.replace("]", "");
        return result;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbTags) {
        return List.of(dbTags.split(", "));
    }
}
