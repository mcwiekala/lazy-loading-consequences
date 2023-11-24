# Optimistic Locking 

This project highlights the challenges associated with overly large clusters of entities in applications with high concurrency.

In this example, multiple unrelated scenarios involve various actors. However, ORM tempts developers to merge multiple tables through relationships such as:
 - one to one 
 - many to one / one to many
 - many to many

This is very easy to achieve. However, it results in increasingly larger transactions. Consequently, the application's performance is degraded and leads to numerous blocking issues that are very difficult to fix.

![big-cluster-of-entities.png](docs%2Fbig-cluster-of-entities.png)


Problems are related to `OptimisticLocks` because often the data are `Stale`.

 - **Synchronous operations** - object on the client side is stale and then happens update
[Check this test.](src/test/java/io/cwiekala/agregates/UserSyncIT.java)
 - **Asynchronous operations** - concurrent changes with multiple users competing with each other (changes are in the same table)
[Check this test.](src/test/java/io/cwiekala/agregates/UserAsyncIT.java)

## Why locks happnes?

Database is a very concurrent system where multiple operations happen in the same time. 
The `Lost Update` is an anomaly related to databases when multiple updates trying to override the same data. To prevent it DB uses tools like `Optimistic` or `Pesimistic Locks`

Here is described this problem from the database perspective:
![lost-updates.png](docs%2Flost-updates.png)

_image credits to [Vlad Mihalcea](https://vladmihalcea.com/a-beginners-guide-to-database-locking-and-the-lost-update-phenomena/)_

## Database

This project uses Docker and Postgres DB, because embedded H2 does not support parallel transactions

http://www.h2database.com/html/advanced.html#mvcc

## Medium

Check my article on Medium which explores this subject!

https://medium.com/@michal.cwiekala/aggregates-f1baeca4d5f0