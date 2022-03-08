# CareerFootsteps
[![wakatime](https://wakatime.com/badge/user/9db7e6b3-4687-44a1-b37b-f11ae4e037d7/project/74eaf0bd-742a-4f29-89a3-368f5bf93ac5.svg)](https://wakatime.com/@HRahman1777/projects/zfrpvelvne?start=2022-03-03&end=2022-03-17)

One kind of blog site where expert users can share there experiences and steps for a specific profession by posting.
Target Keywords: `jpa` `thymeleaf` `mysql` `rest-api` `js-framework`
<hr>

## Model

  * `User` (id, firstname, lastname, email, username, password, role)
  * `Post` (id, title, description, picture, time, category_id, user_id) <b> ManyToOne with `User`, `Category` </b>
  * `Comment` (id, comment, time, post_id, user_id) <b> ManyToOne with `Post`, `User` </b>
  * `Category` (id, name)
  * `Tag` (id, name) <b> ManyToMany with `Post` </b>
  
## Maven Dependency

  * spring-boot-starter-data-jpa
  * spring-boot-starter-thymeleaf
  * thymeleaf-extras-springsecurity5
  * spring-boot-starter-web
  * spring-boot-starter-security
  * spring-boot-starter-validation
  * spring-boot-devtools
  * mysql-connector-java
  * lombok
  * spring-boot-starter-test

## Features

  * Sign up, Sign in - auth
  * Multiple role - auth
  * more coming soon... 


## To Use
  
  * install MySQL
  * install jdk
  * clone repository
  * run `CareerFootstepsApplication.java`

------------------------------------------------- 
 
  
