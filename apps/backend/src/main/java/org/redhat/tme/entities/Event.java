package org.redhat.tme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.redhat.tme.enums.EventType;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import org.redhat.tme.utils.PostgreSqlStringArrayType;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
@Entity
public class Event extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "uuid2",
            type = org.hibernate.id.uuid.UuidGenerator.class
    )
    @Column(name = "event_id", updatable = false, nullable = false)
    @Getter
    @Setter
    private UUID id;

    @Column(name = "event_name", nullable = false, unique = true)
    @Getter
    @Setter
    private String name;

    @Column(name = "event_description", nullable = false, columnDefinition = "TEXT")
    @Getter
    @Setter
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    @Getter
    @Setter
    private EventType type;

    @Column(name = "event_location", nullable = false)
    @Getter
    @Setter
    private String location;

    @Column(name = "audiences", columnDefinition = "text[]")
    @Getter
    @Setter
    @Type(value = PostgreSqlStringArrayType.class)
    private String[] audiences;

    @Column(name = "topics", columnDefinition = "text[]")
    @Type(value = PostgreSqlStringArrayType.class)
    @Getter
    @Setter
    private String[] topics;
}
