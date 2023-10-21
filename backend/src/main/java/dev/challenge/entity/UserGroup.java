package dev.challenge.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Data
@Entity
@FieldNameConstants
@Accessors(chain = true)
@Table(name = "user_groups")
@TypeDef(name = "JSONB", typeClass = JsonBinaryType.class)
public class UserGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(nullable = false)
  private String name;

  private Integer minAge;
  private Integer maxAge;
  private Integer minChildCount;
  private Integer maxChildCount;

  @Type(type = "JSONB")
  @Column(nullable = false, columnDefinition = "JSONB")
  private List<String> locations = new ArrayList<>();

  @Type(type = "JSONB")
  @Column(nullable = false, columnDefinition = "JSONB")
  private List<String> sources = new ArrayList<>();
}
