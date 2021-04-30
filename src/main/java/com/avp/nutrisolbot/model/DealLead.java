package com.avp.nutrisolbot.model;

import com.avp.nutrisolbot.crm.lead.bean.Lead;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deal_lead")
public class DealLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crm_deal_id")
    private Long dealId;

    @Column(name = "paid", columnDefinition = "TINYINT(0)")
    private Boolean paid;

    @Column(name = "stage")
    private String stage;

    @Column(name = "payLink")
    private String payLink;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "SubjectId", nullable = false)
    private Subject subject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "LeadId", nullable = false)
    private Lead lead;
}
