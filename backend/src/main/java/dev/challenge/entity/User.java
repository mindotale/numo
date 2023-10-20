package dev.challenge.entity;

import dev.challenge.enums.ActivityType;
import dev.challenge.enums.AdviceFrequency;
import dev.challenge.enums.ClientType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@Entity
@Accessors(chain = true)
@FieldNameConstants
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String phone;

  @Column(nullable = false)
  private LocalDate birthDate;

  @Enumerated(EnumType.STRING)
  private ClientType clientType;

  @Enumerated(EnumType.STRING)
  private ActivityType activityType;

  @Column(nullable = false)
  private LocalDate lastActivityDate;

  @Enumerated(EnumType.STRING)
  private AdviceFrequency adviceFrequency;

  @OneToMany(
      mappedBy = "parent",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<Child> children = new ArrayList<>();
}
