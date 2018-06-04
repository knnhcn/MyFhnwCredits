package exercise

import grails.gorm.services.Service
import grails.gorm.services.Where
import groovy.transform.CompileStatic

@CompileStatic
@Service(Course)
interface CourseDataService {

    Course update(Serializable id, Boolean isDirty)

}