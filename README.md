# Spring based MVC project

Uses the public CHDM repo and stores this in a SQL database.
Java based project.
Spring MVC framework access repo using combination of JDBC and Hibernate.
Thymeleaf is used as templating engine to present Model in View layer.

Bootstrap and JQuery are used in View layer.

Capabilities include:
- User account (3 types: ordinary user, knowledgeable user, admin), user logging in to their homepage.
- Gamification features whereby points are allocated for:
  - 'Liking'/'Not Liking' museum artifacts
  - Adding user comments on individual artifacts
- League table of users.
- Users can browse the repo based on Artist, Object of interest and type.
- Results are presented in alphabetical order and Pagination is used.
- 

 * The Domain objects that that this program uses are:
 * 		- ChObject
 * 		- Image
 * 		- Participation
 * 		- Participant
 * 		- Role
 * 		- User
 * 		- Authorities
 
 * The Entity objects that this program uses are:
 * 		- Comment
 * 		- CommentFlag
 * 		- CommentThumb
 * 		- Crowdsourcing
 * 		- CrowdsourcingFlag
 * 		- Flagchoice
 * 		- GameType
 * 		- Gamification
 * 		- TagName
 * 		- Users

