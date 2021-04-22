<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
*Create an Inventory Management System for the business of my choice
*   Must be a single-page application using react.js and react router
*   Must have:
*     - A Product Page View that displays Products with a thumbnail image
*     - A Shopping Cart View that allows for Purchase Functionality
*     - A Product Detail View that displays details of the product with the following details : 
*       - Product Name
*       - Serial Number
*       - Price
*       - Manufacturer (Optional, especially if there is only 1 manufacturer for **all** products)
*       - Category / Tag
*       - Quantity
*       - Product Image
*       - Search Functionality
*       - Inventory of at least 10 items  
*
*   Advanced:
*       - Deploy React App using any Hosting solution ([Surge](https://daveceddia.com/deploy-create-react-app-surge/), [Vercel] (https://vercel.com/guides/deploying-react-with-vercel-cra), [Netlify](https://www.netlify.com/blog/2016/07/22/deploy-react-apps-in-less-than-30-seconds/), [AWS](https://aws.amazon.com/getting-started/hands-on/build-react-app-amplify-graphql/module-one/?e=gs2020&p=build-a-react-app-intro), [Heroku](https://blog.heroku.com/deploying-react-with-zero-configuration), etc. )
*       - Staff View - Protected Route
*           - Modify Inventory Quantities (which update the inventory data)
*           - Add New Products
*           - Remove Products
*           - Update Product details
*       - Staff Login View - (to allow access to the Staff View)
*       - Search functionality by any of the item details (serial,price,manufacturer,category)
*       - Allow customers to purchase multiple quantities of the same item.
*       - Integrate with a 3rd party payment processing tool (Stripe / Paypal)
*       - Error Handling when customers attempt to purchase more than what is currently available
*       - Error Handling when customers search for something that is not in the inventory
<h2>
    2. Planning the Solution
</h2>
*   Identify business of my choice
*   Review products and ensure required product details are available/provided
*   Create wireframe
*   Identify individual components and how they react with one another and overall app
*   Identify any areas of concern (maybe areas that will require functionality I'm not familiar with)
*   Create "skeleton" (all files/folders)
*   Download necessary resources (images)
*   
<h2>
    3. Executing the Plan
</h2>
*   Begin with App - build layout
*   Build components, starting with the outter most component and working inwards
*   Implement styling
*   Test functionality
*   Refactor where needed
*   Focus on one task at a time, commit often
*   Utlize all resources along the way (Google, classmates, TM's, stackoverflow)
*
<h2>
    4. Reflection / Refactor
</h2>
* Features I'd like to add
    *"Added to cart" confirmation or indicator
    *"Search by" drop down allowing users to select the item detail they'd like to search (category, price, title, etc.")
* Functionality I'd like to add
    *Update inventory when item moved to cart
    *When "Add to cart" is pushed mulitple times, quantity should adjust instead of adding duplicate items to cart
*Overall areas of improvement
    *Include more notes, especially in areas of code that do not immediately reflect purpose/functionality to another developer
*Successes
    *Components have "one job"
    *UI has consistent theme and behaves as expected
    *Detailed commits during development process
