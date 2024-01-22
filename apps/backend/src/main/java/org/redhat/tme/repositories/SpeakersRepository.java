package org.redhat.tme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.redhat.tme.entities.Speaker;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SpeakersRepository implements PanacheRepository<Speaker> {

    @Inject
    Session session ;

    public Speaker findSpeakerById(UUID speakerId) {
        return find("id", speakerId).firstResult();
    }
    public List<Speaker> getAllSpeakersForEvent(UUID eventId){
        Query<Speaker> q = session.createNamedQuery("Speaker.findByEvent", Speaker.class);
        q.setParameter("eventId", eventId);

        return q.getResultList();
    }
    public List<Speaker> getSpeakersForSession(UUID sessionId) {
        Query<Speaker> q = session.createNamedQuery("Speaker.findBySession", Speaker.class);
        q.setParameter("sessionId", sessionId);

        return q.getResultList();
    }
    
    public Speaker updateOrInsert(Speaker entity) {
        Speaker fromDb = findSpeakerById(entity.getId());
        if (fromDb != null) {
            fromDb.setCompany(entity.getCompany());
            fromDb.setEmail(entity.getEmail());
            fromDb.setLinkedIn(entity.getLinkedIn());
            fromDb.setName(entity.getName());
            fromDb.setTitle(entity.getTitle());
            fromDb.setTwitter(entity.getTwitter());

            persist(fromDb);
            return fromDb;
        }
        persist(entity);
        return entity;
    }
}