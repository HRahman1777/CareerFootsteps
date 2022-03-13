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
 
 # Screenshots
 ------
 ## Main Index Page
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/index.png" />
 
  ## Sign Up
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/user1.png" />
 
   ## Sign In
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/user2.png" />
 
   ## Create Post
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/post1.png" />
 
  ## Home Page
 <img alt="Index" style="border-width:240" height="680" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/post2.png" />
 
  ## All Post with Filter
 <img alt="Index" style="border-width:240" height="680" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/post3.png" />
 
  ## Edit Post
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/post4.png" />
 
  ## Post Comment
 <img alt="Index" style="border-width:240" height="580" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/post5.png" />
 
  ## Self Profile
 <img alt="Index" style="border-width:240" height="580" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/profile1.png" />
 
  ## User Profile
 <img alt="Index" style="border-width:240" height="580" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/profile2.png" />
 
  ## Profile Settings
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/.png" />
 
 ------
 
  ## Admin
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/admin1.png" />
 
  ## Admin - All User
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/admin2.png" />
 
  ## Admin - All Post
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/admin3.png" />
 
  ## Admin - All Category
 <img alt="Index" style="border-width:240" height="480" src="https://raw.githubusercontent.com/HRahman1777/CareerFootsteps/master/screenshots/admin4.png" />
 
 ----------
 -------------
 
