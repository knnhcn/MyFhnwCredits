<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

</head>
<body>

    <div class="overview">
        <div class="achieved-container">
            <span class="achieved-text">ACHIEVED: </span> ${achievedCredits} / ${creditsneeded}
            <span class="achieved">
                <g:if test="${achievedCredits >= 0 && achievedCredits <= creditsneeded*0.3}">
                    <i class="fa fa-road" aria-hidden="true"> WAY TO GO!</i>
                </g:if>
                <g:elseif test="${achievedCredits >= creditsneeded*0.3 && achievedCredits <= creditsneeded*0.75}">
                    <i class="fa fa-align-center" aria-hidden="true"> IN THE MIDDLE!</i>
                </g:elseif>
                <g:elseif test="${achievedCredits >= creditsneeded*0.75}">
                    <i class="fa fa-check-circle-o" aria-hidden="true"> SOON DONE!</i>
                </g:elseif>
            </span>
        </div>
        <div class="minus-container">
            <span class="minus-text">MINUS: </span> ${failedCredits} / ${maxfails}
            <span class="minus">
                <g:if test="${failedCredits >= 0 && failedCredits <= maxfails*0.3}">
                    <i class="fa fa-thumbs-o-up" aria-hidden="true"> LUCKY!</i>
                </g:if>
                <g:elseif test="${failedCredits >= maxfails*0.3 && failedCredits <= maxfails*0.75}">
                    <i class="fa fa-fire" aria-hidden="true"> GETTIN' HOT HERE!</i>
                </g:elseif>
                <g:elseif test="${failedCredits >= maxfails*0.75}">
                    <i class="fa fa-exclamation-triangle" aria-hidden="true"> WATCH OUT BUDDY!</i>
                </g:elseif>
            </span>
        </div>
    </div>

    <g:each var="map" in="${courses}">
        <h1 class="group-header">${map.key}</h1>
        <table id="courses-table">
            <tr>
                <th>Course name</th>
                <th>Status</th>
                <th>Credits</th>
                <th>Fail count</th>
            </tr>
            <g:each var="course" in="${map.value}">
                <tr>
                    <td><a href="/course/show/${course.id}">${course.name}</a></td>
                    <td>
                        <g:if test="${course.isDone == true}">
                            <i class="fa fa-check" aria-hidden="true"> DONE</i>
                        </g:if>
                        <g:elseif test="${course.isDone == false && course.failCount == 1}">
                            <i class="fa fa-exclamation" aria-hidden="true"> ONE MORE CHANCE</i>
                        </g:elseif>
                        <g:elseif test="${course.isDone == false && course.failCount == 2}">
                            <i class="fa fa-ban" aria-hidden="true"> FAILED</i>
                        </g:elseif>
                        <g:else>
                            -
                        </g:else>
                    </td>
                    <td>${course.credits}</td>
                    <td>${course.failCount}</td>
                </tr>
            </g:each>
        </table>
    </g:each>

</body>
</html>
