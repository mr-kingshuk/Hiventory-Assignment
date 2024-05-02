# Hiventory Assignment

The task involves creating a **POST API (/addpayment)** capable of handling a JSON body containing the _**amount**_ and _**customerId**_. Upon receiving a request, the API processes outstanding orders for the specified customer, clearing them in _ascending order_ based on their IDs. Subsequently, it updates the customer's balance in the Customer table. Payments are then recorded in the Payment table, designated as **"SQUARED"** for cleared orders or **"ADVANCE"** for advance payments. 

# Table of Contents📄
- Assumptions
- API Endpoints
- Future Enhancements
- License

# Assumptions
- Customer table has been already updated, and no api route will add any resource to the Customer table. 

- Thus, only Ajay and Anil are the only customer in the application.

# API Endpoints📄
- **GET /all-orders** - Gets all the orders present in the Orders table, in asscending order
- **GET /order/:id** - Gets the order corresponding to the id given in the request params.
- **GET /order/:id** - Gets the order corresponding to the id given in the request params.
- **DELETE /order/:id** - Delete the order corresponding to the id given in the request params.
- **PUT /order/:id** - Updates the order corresponding to the id given in the request params, taking the entire Order object as request body.
- **POST /order/** - Add a order resource in the Orders table, taking the entire Order object as request body.

- **POST /addpayment** - Handles any outstanding orders or advance deposits, associated with the designated customer, resolving them in ascending order according to their IDs. Following this, it proceeds to adjust the customer's balance within the Customer table. Finally, documenting payments within the Payment table, marking them as "SQUARED" for resolved orders or "ADVANCE" for prepayments.

# Future Enhancements💫

- **Adding API for Customer Resource** - for updating, modifying or deleting a customer.
- **Changing Orders Table Schema** - instead of customer being a String feild saving customer name, we could use a foreign key that links to the primary key id of Customer table. In case, a customer is deleted, the row will be _soft-deleted_, i.e. a new feild *is_deleted* in the table will be true(default false), in that case.

- **Data Insights:** More API endspoints can be created to filter and search outstanding dues on orders or deposits amounts paid by customer.
  
# License📄

This project is licensed under the MIT License. Please feel free to use, modify, and distribute this code according to the terms of the license.
