package exercise

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CourseSpec extends Specification implements DomainUnitTest<Course> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test name cannot be blank'() {
        when:
        domain.name = ''

        then:
        !domain.validate(['name'])
    }

}
