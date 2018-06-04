package exercise

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class CourseGroup {

    String name
    Integer minCreditsNeeded
    Integer achievedCredits = 0

    static constraints = {
        name nullable: false, blank: false
        minCreditsNeeded nullable: false, min: 2
        achievedCredits editable: false
    }

    CourseGroup(String _name, Integer _minCreditsNeeded) {
        this.name = _name
        this.minCreditsNeeded = _minCreditsNeeded
    }

    Boolean isDone() {
        // TODO: Loop through courses with group id and check if minCreditsNeeded is fullfilled then return a boolean
    }

    Boolean containsFailed() {
        // TODO: Loop through courses with group id and check if failCount > 0 then return a boolean.
    }

    String getGroupName() {
        return this.name
    }

    Integer getMinCreditsNeeded() {
        return this.minCreditsNeeded
    }

    Integer getAchievedCredits() {
        return this.achievedCredits
    }

    void incrementAchievedCredits(Integer credits) {
        this.achievedCredits += credits
    }

    void decrementAchievedCredits(Integer credits) {
        this.achievedCredits -= credits
    }

    String toString() {
        return "$id - $name"
    }
}
