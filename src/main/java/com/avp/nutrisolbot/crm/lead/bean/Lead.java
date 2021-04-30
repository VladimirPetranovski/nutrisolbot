package com.avp.nutrisolbot.crm.lead.bean;

import com.avp.nutrisolbot.model.Student;
import com.avp.nutrisolbot.model.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crm_lead")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("ID")
    @Column(name = "CrmId")
    private Integer crmId;

    @JsonProperty("TITLE")
    @Column(name = "Title")
    private String title;

    @Column(name = "moved", nullable = false, columnDefinition = "TINYINT(0)")
    private Boolean moved;

    @JsonProperty("NAME")
    @Column(name = "Firstname")
    private String firstname;

    @JsonProperty("SECOND_NAME")
    @Column(name = "Surname")
    private String surname;

    @JsonProperty("LAST_NAME")
    @Column(name = "Lastname")
    private String lastname;

    @JsonProperty("STATUS_ID")
    @Column(name = "StatusId")
    private String statusId;

    @JsonProperty("OPENED")
    @Column(name = "Opened")
    private String opened;

    @JsonProperty("ASSIGNED_BY_ID")
    @Column(name = "AssignedById")
    private Long assignedById;

    @JsonProperty("CURRENCY_ID")
    @Column(name = "Currency")
    private String currencyId;

    @JsonProperty("OPPORTUNITY")
    @Column(name = "Opportunity")
    private Double opportunity;

    @Column(name = "Email")
    @JsonIgnore
    private String email;

    @Column(name = "RegistrationDate")
    @JsonIgnore
    private Date registrationDate;

    @Column(name = "AccessDate")
    @JsonIgnore
    private Date accessDate;

    @Column(name = "PhoneNumber")
    @JsonIgnore
    private String phoneNumber;

    @JsonProperty("EMAIL")
    @Transient
    private List<Email> leadEmail;

    @JsonProperty("PHONE")
    @Transient
    private List<Phone> leadPhone;

    @JsonProperty("CONTACT_ID")
    @Column(name = "ContactId")
    private Long contactId;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private Set<DealLead> dealLeads;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Student student;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable( name = "crm_lead_subject",
            joinColumns = {@JoinColumn(name = "LeadId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name="SubjectId", referencedColumnName = "Id")})
    private Set<Subject> subjects = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable( name = "lead_pay_subject",
            joinColumns = {@JoinColumn(name = "LeadId", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name="SubjectId", referencedColumnName = "Id")})
    private Set<Subject> paySubjects = new HashSet<>();

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "id.lead", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<EventLead> eventLeads;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @OneToMany(mappedBy = "id.lead", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<TrialLead> trialLeads;

    public String getFullName() {
        String fullName = "";

        if (this.getFirstname() != null) {
            fullName += this.getFirstname();
        }
        if (this.getLastname() != null) {
            fullName += " " + this.getLastname();
        }

        return fullName;
    }
}
