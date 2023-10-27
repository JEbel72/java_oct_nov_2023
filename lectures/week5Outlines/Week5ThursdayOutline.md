# Week 5 Thursday in Java - October 26, 2023

## Reminders:
- Core assignments this week (MANDATORY):
    - Dojos & Ninjas
    - Login & Registration
- Practice assignments this week (HIGHLY recommended):
    - NONE - however, you might find the Student Roster 1:n optional assignment useful for practicing 1:n relationships
- Discussion topics are unlocked!  This week's are due Sunday, October 29, by 11:59 PM Pacific
- To pass the course:
    - 10/11 core assignments total (through this week, we have 10 core assignments)
    - 11/16 discussion topics
    - Pass the belt exam with any belt (required for all)

## Announcements:
- Feel free to look at the new belt exam rubric on the platform (Java Spring -> Full Spring -> Belt Exam Rubric); I'll hold a session next week talking about the changes and field any questions you may have
- I strongly recommend doing the Book Club core assignment next week, including the Ninja Bonus of Update and Delete!
- The Artists/Songs project *will* be pushed to GitHub; this week's login/registration demo **will not**

## Lecture outline:
- Routes we'll need for login/registration project
- **Registering:**
    - Build JSP files
        - Be careful with model attributes!!!
    - Test initial built-in validations for registering
    - New validations for registering that don't use the built-in validation annotations
    - Test registering fully with all validations - built-in and custom validations
    - Successful registration - we need something important!!
    - Link on error code generation: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/validation/DefaultMessageCodesResolver.html
- Dashboard (or whatever route you send newly registered and logged in users to)
    - Grabbing the user's info from the database
    - Ensuring only logged in users can access pages
- **Logging out**
- **Logging in:**
    - The LoginUser model revisited
    - Custom validations for logging in
- Ensuring only unique emails are allowed when registering
