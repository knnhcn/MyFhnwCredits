package exercise

import grails.gorm.services.Service
import grails.gorm.services.Where
import groovy.transform.CompileStatic

@CompileStatic
@Service(CourseGroup)
interface CourseGroupDataService {

    CourseGroup update(Serializable id, Integer achievedCredits)

}