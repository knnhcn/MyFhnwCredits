package exercise

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Course {

    String name
    Integer credits
    Boolean isDone
    Integer failCount
    CourseGroup courseGroup
    private Boolean isDirty = false

    static constraints = {
        name nullable: false, blank: false
        credits nullable: false, min: 1, max: 12
        isDone nullable: false
        failCount nullable: false, min: 0, max: 2, defaultValue: 0
        courseGroup nullable: false
        isDirty editable: false, display: false
    }

    Course(String _name, Integer _credits, Boolean _isDone, Integer _failCount, CourseGroup _courseGroup) {
        this.name = _name
        this.credits = _credits
        this.isDone = _isDone
        this.failCount = _failCount
        this.courseGroup = _courseGroup
    }

    Course plus(Course other) {
        new Course(credits: this.credits + other.credits)
    }

    String toString() {
        return "$name"
    }

    String getCourseName() {
        return this.name
    }

    Integer getCourseCredit() {
        return this.credits
    }

    Boolean courseIsDone() {
        return this.isDone
    }

    Integer getFailCount() {
        return this.failCount
    }

    Boolean getIsDirty() {
        return isDirty
    }

    void setIsDirty(Boolean isDirty) {
        this.isDirty = isDirty
    }
}
