package exercise

import grails.util.Environment


class BootStrap {

    def init = { servletContext ->

        if(Environment.current == Environment.DEVELOPMENT) {

            // Software Engineer group and courses.
            CourseGroup SE = new CourseGroup("Software Engineering", 18)
                    .save(failOnError:true)

            Course webec = new Course("Web Engineering", 3, false, 0, SE)
                    .save(failOnError:true)

            Course swegl = new Course("Software Engineering Grundlagen", 3, false, 0, SE)
                    .save(failOnError:true)

            Course req = new Course("Requirements Engineering", 3, false, 0, SE)
                    .save(failOnError:true)

            Course sepc = new Course("Softwareentwicklungsprozesse", 3, false, 0, SE)
                    .save(failOnError:true)

            Course swc = new Course("Software Construction", 3, false, 0, SE)
                    .save(failOnError:true)

            Course ecnf = new Course("Einführung C# und das.NET-Framework", 3, false, 0, SE)
                    .save(failOnError:true)

            Course depa = new Course("Design Patterns", 3, false, 0, SE)
                    .save(failOnError:true)

            Course stqm = new Course("Software Testing and Quality Management", 3, false, 0, SE)
                    .save(failOnError:true)


            // Mathematics group and courses.
            CourseGroup MTH = new CourseGroup("Theoretische Grundlagen und Mathematik", 18)
                    .save(failOnError:true)

            Course mgli = new Course("Mathematische Grundlagen der Informatik", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course lag = new Course("Lineare Algebra und Geometrie", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course mada = new Course("Mathematik für die Datenkommunikation", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course eana = new Course("Einführung in die Analysis", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course dist = new Course("Diskrete Stochastik", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course vana = new Course("Vertiefung Analysis", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course eti = new Course("Einfuehrung in die Theoretische Informatik", 3, false, 0, MTH)
                    .save(failOnError:true)

            Course krysi = new Course("Kryptographie und Informationssicherheit", 3, false, 0, MTH)
                    .save(failOnError:true)
        }

    }

    def destroy = {
    }
}
