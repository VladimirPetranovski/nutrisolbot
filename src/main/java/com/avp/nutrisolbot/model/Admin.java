package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.user.admin.states.AdminBotState;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "AdminBotState", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AdminBotState adminBotState;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
    private User user;
}
