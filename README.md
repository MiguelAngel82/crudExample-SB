# Spring Boot CRUD example

A Spring Boot 1.3.2 CRUD example. This example is based on Dan Vega's example (from the course http://www.learnspringboot.com/).

This project includes 7 brances. In each branch configuration or functionality is added:

 - **properties** branch: first branch to show how the properties are configured.
 - **domain** branch: this branch contains the domain.
 - **controller** branch: the controllers are added in this branch.
 - **service** branch: services an repositories are added.
 - **view** branch : views wit Thymeleaf are created in this branch. Also, a `DataLoader` class is created, to add default data in aplication's startup.
 - **security** branch: security is configured and "thymeleaf-extras-springsecurity4" is added.

So this project contains:

**Domains**:

 - `Author`. Represents the author of a post. Contains:
	 - `id`. Long.
	 - `firstName`. String.
	 - `lastName`. String.
	 - `email`. String.
 - `Post`. Represents a post. Contains:
	 - `id`. Long.
	 - `title`. String. Not empty.
	 - `slug`. String. Not empty.
	 - `postedOn`. Date with the format "M/dd/yyyy hh:mm:ss a". Not null.
	 - `keywords`. List of Strings. Min size 1 and max size 2. 
	 - `active`. Boolean.
	 - `author`. Many to One relation with Author.
	 - `teaser`. String.
	 - `body`. String. Not empty.

**Controllers**:

 - `HomeController`. Manages `/` requests. Shows the "index" page.
 - `PostController`. Manages `/posts` requests:
	 - `/list`. Shows `post/list` view, that contains all posts.
	 - `/view/{slug}`. Shows `post/view view.` This view shows a post by a given slug.
	 - `/byAuthor/{id}`. Shows `post/list` view, getting the post by the specified author.
 - `AuthorController`: Manages `/authors` requests.
	 - `/list`. Shows `author/list` view, that contains all authors.
	 - `/view`. Shows `author/view` view. 
 -  `AdminPostController`: Manages requests for the `ROLE_ADMIN`.
	 - `/admin/posts`. Shows `admin/post/list` view, that contains all posts.
	 - `/admin/post/create`. Shows `admin/post/postForm` view, to create a new post.
	 - `/admin/post/save`. Saves a new post. If is saved correctly redirects to `/admin/post/` action, with the ID of the new post created. If there is an error, shows the view `admin/post/postForm`.
	 - `/admin/post/edit/{id}`. Shows the view `admin/post/postForm` to edit the post by the giving ID.
	 - `/admin/post/delete/{id}`. Redirects to  `/admin/posts` deleting the post by the giving ID.

**Services**:

 - `AuthorService`. Contaisn all the business logic about author:
	 - `list`: gets all authors order by last name, ascending, and first name, ascending.
 - `PostService`. Contaisn all the business logic about post: 
	 - `getLatestPost`: gets the first post order by "postedOn", descending.
	 - `list`: gets all posts order by "postedOn", descending.
	 - `getBySlug`: gets a post by slug.
	 - `listByAuthor`: gets all posts by author and order by "postedOn", descending. 
	 - `get`: gets a post by id.
	 - `save`: saves the post given.
	 - `delete`: deletes a post by id.

