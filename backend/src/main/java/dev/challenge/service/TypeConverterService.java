package dev.challenge.service;

import static java.util.stream.Collectors.toList;

import com.querydsl.core.types.Path;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.Property;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeConverterService {

  private final ConversionService conversionService;

  public List<Object> convert(Collection<String> values, Path<?> path) {
    return values.stream()
        .map(
            value ->
                conversionService.canConvert(String.class, path.getType())
                    ? conversionService.convert(
                        value, TypeDescriptor.forObject(value), getTargetTypeDescriptor(path))
                    : value)
        .collect(toList());
  }

  protected TypeDescriptor getTargetTypeDescriptor(Path<?> path) {
    var property = path.getMetadata().getName();
    var owningType = path.getMetadata().getParent().getType();
    var descriptor = BeanUtils.getPropertyDescriptor(owningType, property);

    var typeDescriptor =
        TypeDescriptor.nested(
            new Property(
                owningType, descriptor.getReadMethod(), descriptor.getWriteMethod(), property),
            0);

    if (typeDescriptor == null) {
      throw new IllegalStateException(
          String.format("Could not obtain TypeDesciptor for Path %s", path));
    }

    return typeDescriptor;
  }
}
