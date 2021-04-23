<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

<p>Create RESTful API and connect it with React app built for Capstone-1: </p>
<p>Data is currently in a .json file and must be added to a database </p>
<p>Data should be restructured to follow database modeling best practices </p>
<p>API should have data persistence layer</p>
<p>Front-end must be refactored to be effectively wired up with API</p>
<p>API should contain full CRUD functionality with appropriate status codes </p>
&nbsp; -Determine which components require API calls (search, add-to-cart, etc.)
<p>API should include completed cardinality between entities </p>

<h2>2. Planning the Solution </h2>
<p>Create DB Schema diagram</p>
<p>Create database (AWS RDS)</p>
<p>Clone Capstone-3 repo and add Maven framework and Spring dependencies</p>
<p>Add datasource to project (AWS RDS database - make sure it is publicly available)</p>
<p>Create entities and implement cardinality</p>
<p>Create .sql file that adds all product data to database (data persistence layer)</p>
<p>Add CRUD functionality by creating repositories, services, and controllers(include status codes)</p>
<p>Test HTTP requests using Insomnia</p>
<p>Once functional, create API documentation</p>

<p>Add API calls to context provider (ProductContext)</p>
<p>If property names in API match property names in data.json file, app should be working correctly</p>
<p>Delete data.json file</p>


<h2>
    3. Executing the Plan
</h2>
<p>Challenge connecting to RDS database</p>
<p>-Solution: Add "inbound" rule to security group that allows connection from "All Traffic"</p>
<p>Challenge with deploying app to EC2 - caused by "no main manifest attribute".</p>
<p>-Solution: Run mvn install. Upload .jar from target folder to EC2 (NOT .jar.original)</p>
<p>API data being fetched successfully via browser and Insomnia,  but unable to be fetched in React</p>
<p>-Solution: Add CORS extension to browser to get around CORS limitations</p>
<p>Database crashes with too much inbound traffic, due to lack of load balancer, resulting in 100% of queries resulting in 500 error</p>
<p>-Solution: Kill all processes making queries to database</p>
<p>Singular context in front-end app requires unnecessary manipulation of data for simple tasks, resulting in errors when other components rely on the original, unaltered, data</p>
<p>-Solution: Create multiple context (separation of concern), allowing one context to maintain unaltered data</p>
<p>Error returned when adding Swagger UI (class path resource [springfox/documentation/spring/web/SpringfoxWebConfiguration.class] cannot be opened because it does not exist)</p>
<p>-Solution: Ensure springfox-swagger-ui and springfox-boot-starter dependencies are the SAME version</p>

<h2>
    4. Reflection / Refactor
</h2>
<p>Put more thought into selection of technologies to use PRIOR to selecting them. Choosing the tech stack for this project before researching them resulted in lost days of work troubleshooting areas that could have been easily overcome by choosing different technologies.</p>
<p>Front-end was heavily dependent on a single context, which made implementation of an API difficult and resulted in major refactoring. </p>
<p>There are areas of the plan that can be worked on in the future (Users) that were not necessary to complete this project.</p>