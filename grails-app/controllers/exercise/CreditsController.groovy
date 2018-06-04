package exercise

class CreditsController {

    final int CREDITS_NEEDED = 180
    final int MAX_MINUS_CREDITS = 60

    def index() {

        List<Course> allCourses = Course.getAll()
        def groups = allCourses.groupBy({ course -> course.courseGroup })

        def coursesDone = allCourses.findAll{ it.isDone == true}
        def coursesHasFailed = allCourses.findAll{ it.failCount > 0 }

        def achievedCredits
        if (coursesDone) {
            achievedCredits = coursesDone.sum().credits
        } else {
            achievedCredits = 0
        }

        def failedCredits = 0
        if (coursesHasFailed) {
            coursesHasFailed.each { course ->
                if(course) {
                    failedCredits += course.failCount*course.getCredits()
                }
            }
        } else {
            failedCredits = 0
        }

        render view:'credits', model: [courses: groups,
                                       achievedCredits: achievedCredits,
                                       failedCredits: failedCredits,
                                       creditsneeded: CREDITS_NEEDED,
                                       maxfails: MAX_MINUS_CREDITS]
    }
}
