package exercise

import grails.events.annotation.Subscriber
import grails.gorm.services.Service
import grails.events.annotation.gorm.Listener
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.AbstractPersistenceEvent
import org.grails.datastore.mapping.engine.event.PostDeleteEvent
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.grails.datastore.mapping.engine.event.PostUpdateEvent
import org.hibernate.Session
import org.hibernate.SessionFactory

@CompileStatic
@Service(Course)
class CourseListenerService {

    CourseGroupDataService courseGroupDataService
    CourseDataService courseDataService
    SessionFactory sessionFactory


    Long courseId(AbstractPersistenceEvent event) {
        if (event.entityObject instanceof Course) {
            return ((Course) event.entityObject).id
        }
        null
    }

    Course courseObj(AbstractPersistenceEvent event) {
        if (event.entityObject instanceof Course) {
            return (Course) event.entityObject
        }
        null
    }

    @Subscriber
    void afterInsert(PostInsertEvent event) {
        Course courseObj = this.courseObj(event)

        if(courseObj != null && courseObj.getIsDirty() && !courseObj.isDone) {
            courseObj.courseGroup.decrementAchievedCredits(courseObj.getCourseCredit())
            courseGroupDataService.update(courseObj.courseGroup.id, courseObj.courseGroup.getAchievedCredits())
        }

        if (courseObj != null && courseObj.isDone) {
            courseObj.setIsDirty(true)
            courseObj.courseGroup.incrementAchievedCredits(courseObj.getCourseCredit())
            courseGroupDataService.update(courseObj.courseGroup.id, courseObj.courseGroup.getAchievedCredits())
            courseDataService.update(courseObj.id, courseObj.getIsDirty())
        }
    }

    @Subscriber
    void afterUpdate(PostUpdateEvent event) {
        Course courseObj = this.courseObj(event)

        if(courseObj != null) {
            CourseGroup courseGroupObj = courseObj.courseGroup

            if (courseObj.isDone) {

                try {
                    courseObj.setIsDirty(true)
                    courseGroupObj.incrementAchievedCredits(courseObj.getCourseCredit())

                    courseGroupDataService.update(courseGroupObj.id, courseGroupObj.getAchievedCredits())
                    courseDataService.update(courseObj.id, courseObj.getIsDirty())
                } catch (Exception e) {
                }

            }

            if(courseObj.getIsDirty() && !courseObj.isDone) {
                courseObj.courseGroup.decrementAchievedCredits(courseObj.getCourseCredit())
                courseGroupDataService.update(courseObj.courseGroup.id, courseObj.courseGroup.getAchievedCredits())
            }
        }
    }

    @Subscriber
    void afterDelete(PostDeleteEvent event) {
        Course courseObj = this.courseObj(event)

        if(courseObj != null && courseObj.getIsDirty() && !courseObj.isDone) {
            courseObj.courseGroup.decrementAchievedCredits(courseObj.getCourseCredit())
            courseGroupDataService.update(courseObj.courseGroup.id, courseObj.courseGroup.getAchievedCredits())
        }
    }
}