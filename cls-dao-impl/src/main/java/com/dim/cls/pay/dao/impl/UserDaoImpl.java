package com.dim.cls.pay.dao.impl;
 
import java.util.Date;

/* Hibernate Tutorials
 
 Lession - 01
 ------------
 1) An ORM
 2) Used in Data layer
 3) Implements JPA(Java Persistance API)
 
 Pain points in manual method
 ----------------------------
 Map member variable to columns
 Mapping Relationship
 Handling Data types
 Manage changes to the object state
 
 Relational way and object relational way is very diffeernt. But in design both side designs should not be compromised
 Ex : In RDBMS, : erlations betwwen tables should not be directly mapped to objects in OO design.
 So, ORM tool is to map objects with Relational database
 
Lession - 02 
------------
 Hibernate Required : JPA, JTA ...etc libs.
 
Lession -03 - Part 1
--------------------

if without Hibernate : steps
1) JDBC configurations.
2) model objects
3) service method to create model
4) Table Design
5) DAO method to save the object via jdbc connection.

Hibernate Way
------------
1) JDBC db configuration (using hibernate configuration file)
2) Model Object - Annotaions configurations.
3) Service method to create the model object and save 
4) DB Design - Not needed. HIbernate creates it for us
5) DAO methods - queries are not needed


Hibernate: defaultly looks configuration file named : hibernate.cfg.xml, in class path

	
Lession -03 - Part 2
--------------------


Lession -03 - Part 3
--------------------

SessionFactory 
1) One object per application(users, hibernate.cfg.xml)
2) then sessionFactory is used to  creates sessions
3) Then those sessions are used to save model objects


Lession - 04
------------

when @Column(name = "FIRST_NAME") is put at a getter method. Hibernate gets the value to be saved, by calling the getName()
method.

At Object to Relation mapping.

when annotated at the getMethod : => some business validations can be write in get method.(Ex: default value if variable is null)
when annotated at the property  : => hibernate access the property via reflection.

when both getMethod and the attribute are annotated
=> hibernate get the value via method and store at the database. 


Lession - 05
-----------

@Basic annotaion : treat the colum with Hibernate defaults.
(java types to sql type, conversion to be done in Hibernate defaults) : Even @Basic is not placed : THis is the default behaviour

@Basic
private String firstName;

@Basic(fetch = FetchType.LAZY, )
@Basic(optional = FetchType.LAZY, )

Configurating a property not to save in DB
------------------------------------------
static => static fields are not saved since they are common for all the objects of a class
mark as @Transient => hibernate ignores this properis

Below are only for Dates
------------------------
@Temporal(TemporalType.DATE) //save only the date. But not the time stamp.
@Temporal(TemporalType.DATE) //save only the time.
@Temporal(TemporalType.TIMESTAMP) // save date and time.(this is default)

@Lob Annotaion
--------------
=> Meaning a large object

@Lob   => can be used with large amount of String, or character .
private String description; => 

Lession 06 => Relational to Object mapping
-------------------------------------------
use of sessions. (in JDBC it is connection : => In hibernate it is session)
session has a db connection internally and it knwos how to do ORM mapping either sides at run time.

Lession 07
----------
@Id

Natural key => Ex: email address, NIC (these has a meaning also and they are unique for records). This has a business value.
Sorrogate key => key only used as a key (Example : Use ID). no business use.


@GeneratedValue => Asking hibernate to auto generate the sorrogate key. We do not need to provide any key.
Ex: 
	@Id // primary key
	@GeneratedValue
	@Column(name = "ID_INTERNAL")

	@GeneratedValue(strategy=GenerationType.AUTO)    //default statergy. Hibernate do its own way.	
	@GeneratedValue(strategy=GenerationType.IDENTITY) //use the identify column feature of database(sqlserver,mysql)
	@GeneratedValue(strategy=GenerationType.SEQUENCE) //it usees the sequence object
	@GeneratedValue(strategy=GenerationType.TABLE) //hibernate use a table to stoe the lastly used primary key. Next time, It will read this value and + 1.
		

Lession - 08
------------

Entity : It is independent and has a meaning itself in business domain (Ex: User)
value object : it does not has a meaning itself in business domain. Ex: Address ( Address of user has a menaing but
not just the address)

	@Embedded
	private Address homeAddress; //no need to create a separte table for homeAddress. but include in the same table since it is a value object.
	
Lession - 09 => Embedeed objects
------------
In ENtity class. Using multiple emebedable objects in same type

	@Embedded
	@AttributeOverrides({ -> all overrides should go inside these tag
	@AttributeOverride(name="city", column=@Column(name="HOME_STREET_NAME")), //do not use the default column name from embedable object. But use these configured values for embeded object proerties.	
	@AttributeOverride(name="town", column=@Column(name="HOME_TOWN"))
	})
	private Address homeAddress; 
	
		@Embedded
	@AttributeOverrides({ -> all overrides should go inside these tag
	@AttributeOverride(name="city", column=@Column(name="OFFICE_STREET_NAME")), //do not use the default column name from embedable object. But use these configured values for embeded object proerties.	
	@AttributeOverride(name="town", column=@Column(name="OFFICE_TOWN"))
	})
	private Address officeAddress; 
	
	
	@EmbeddID annotaion. 
	=> If a Embeded obejct to be the primary key of a table, this annotation is used.
	=> we do not use @Embeded and @Id both together. Instead we use @EmbededId annotaion.
	
	
	@EmbeddedID
	private LoginID loginid; (LoginID is a embedable class)
	
	
Lession 10 => saving collections
--------------------------------

=> No fixed number of related obejcts.
=> need to go for a separate table, for embedable objects.

Hibernate support few collcetion types.

1) Set

	@ElementCollection //Annotion to persist as a collection object. Default name is ENTITYTABLE_EMBEDABLEOBJECTNAME.
	//join colum will be : ENTITYTABLENAME_IDCOLUMNAME
	 
	@CollectionTable(name = "T_IDENTITIES", joinColumns = @JoinColumn(name = "ID_INTERNAL") )
	private Set<Identity> identities;  //hibernate supprot interface type. bUt not impelemntation. So the type must be Set. Not HashSet
	
=> the embedable table will not have a primary key. But only a forign key.
	
Lession 11 => Collections ext..How to add a primary key for embedable table
---------------------------------------------------------------------------

=> Should have a collection type which support indexs. 
	=> So, Set Can not be used.
	=> Can use ArrayList.
	
	@GenericGenerator(name="hilo-gen" , stratergy="hilo")
	@CollectionId(@column={name="ADDRESS_ID"}, generator="hilo-gen", type=@Type(type="long")) // Then the Embedable table will have ADDRESS_ID as primary key.
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	
Lession 12 : Proxy objects and Eagar and Lazy loading
-----------------------------------------------------

Fetch Statergy
-------------


		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//At below step hibernate does not pull the address information from the database. Since performance impact.
		AbstractPerson p3 = (AbstractPerson)session.get(AbstractPerson.class, 1); //pull up the record with userId as 1.
		
		//When the below is exeucted : hibernate get the whole set of address from database.
		 //This is called as lazy initializeation of hibernate
		 //object parameters are initialzed only when they are needed.
		p3.getAddress();
		
		//This lazy initialization is possible becuase of proxy classes.
		 * 
		 * for all 	@Entity / @Embedable , annotated classes hibernate creates proxy classes.
		 * proxy class extends the original class and calls the original class method internally.
		 * 
		 
		  Methods in proxy classes => first call the database to get values from database.
		  
		  //If the session is closed before retriving lazy data => hibernate.LazyInitializationException happens
		   * 
		   * Ex:
		   
		 //At below step hibernate does not pull the address information from the database. Since performance impact.
		 AbstractPerson p3 = (AbstractPerson)session.get(AbstractPerson.class, 1); //pull up the record with userId as 1.
		 session.close();
		 p3.getAddress(); => hibernate.LazyInitializationException happens
		  
		  
		  chaing the initializeation type to 'EAGER' for a collection
		  
		  @ElementCollection(fetch=FetchType.EAGER)
		   @CollectionTable(name = "T_ADDRESS", joinColumns = @JoinColumn(name = "ID_INTERNAL") )
		  private List<Address> address;
		   
		 */
/*		
Lession 13 - one to one (Entity to Entity) relationship
	
Entity to Entity relationship.(before looked at Entity to value object(Embedable objcet)	
	//Entity to Entity relationships
	@OneToOne //Abstract person column will have a colom as fater where fatehs primary key can be stored.
	@JoinColumn(name="father_id")	
	private AbstractPerson father;
	
	Here,
	
	1) Hibernate insert object 1.
	2) Hibernate insert object 2.
	3) Then hibernate update the father_id of the object 1 with id of object 2.
	*/
	
/*
Lession 14
----------

1) By directioanl relationships in objects are common in java enterripse apps
Ex : A person can have multiple vehicles. and a vehical can have only one use.

So in Person class we can have a Set<Vehicle> attribute where we add the vehicle.
In Vehical class we could have a attribute as 'Person owner' where we add the user of the vehical.

In hibernate annotations.

Set<Vehicle> vehicles ; in PErson class is annotated with @oneToMany
Person owner; in vehical class is annotated with @ManyToOne


Lession 15
-----------

db level one to many relationship : By adding a column in many side of the table 
which stores the id of the one side table.


Ex: User has many vehicles. Every vehical has a owner.
User  {

@oneToMany(mappedBy="owner") //this is to inform hibernate to check vehical class, owner filed for relationship information.
Collection<Vehicles> vechicles;
}


Vehical {
@ManyToOne
@JoinColumn("OWNER_ID")
User owner;
}

Then hibernate will not create a new table and, a new colum will be created on vehical table for mapping.


ManyToMany
----------
Case 1
--------
@ManyToMany annotation placed at both ends( class properties).
Then => Hibernate ccreates two mapping tables.

first => User_userVehicals table and Vehcal_userdUser table.

Ex: 


User {
@ManyToMany
Set<Vehicle> userdVehicales;

}


Vechival {
@ManyToMany
Set<User> usedUsers;
}

to avoid this 

User {
@ManyToMany(mappedBy="userUsers") //This helps us to have only one mapping table.  So no extra will be created.
Set<Vehicle> userdVehicales;
}

Vechival {
@ManyToMany
Set<User> usedUsers;
}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "U_EMERGENCY_CONTACT", joinColumns = {
			@JoinColumn(name = "ID_INTERNAL", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INTERNAL_EME", nullable = false) })
	private List<AbstractPerson> emergencyContactPersons;
	
	
Lession - 16 => useful hints.
------------	

class User  {

@OneToOne
Vechile vehicle;

}

Main{

User u = new User();

u.getvehile();

}

Since the user does not have a venile
Here hibernate will give Exception  : 


THe exception can be avoided by

@OneToOne
@NotFound(action=NotFoundAction.IGNORE) => ask hibernate to ignore if the vehicla is not found at u.getVehicla call.
Vechile vehicle;

Hibernate Collection
-------------------
Bag semantic => List/Arry List 
In Bag => put in any order, retrive in any order, 
=> can be implemetend using either a list or array list.

Bag Semantic with ID : => List or Array List
can pull up items depending on the ID.

List sementic => 
Differnce from Bag is :
List can be ordered. 

Set sementic => similar to set data type of java
Map sementic => similar to map sementic of java

Hibernate use one of above to maintain collections.

Cascade
------

User {

@oneToMany
List<Vehicle> vehicle;

}

User u =  new User();
List<Vehicle> vs= new ArrayList<Vehicle>;
Vechicle v1 = new Vechicle();
vs.add(v1);
Vechicle v2 = new Vechicle();
vs.add(v2);
Vechicle v3 = new Vechicle();
vs.add(v3);

u.setVechicle(vs);

How to save them
----------------

session.save(u); 

=> Here hibernate gives org.hibernate.TransientObjectException
=> THis is since the asosciated vehical objects are not saved.

=> HIbernate does not save vehicle objects automatically, Since they are also entities. So
hibernate does not make the assumption to save.(Since those objects have the their own life without user)

So, below is the way to avoid exectiion.

session.save(v1); 
session.save(v2); 
session.save(v3); 
.
.
.
session.save(u); 

So, to avoid above list of saves....Below can be used.

User {
@oneToMany(cascade=CascadeType.PERSIST) : => when the user is persist :=> persist vehicles also.
List<Vehicle> vehicle;
}
Then.
session.persist(u); (not session.save(u);)=>this will save user and all vehicles.

DETACH,MERGE,PERSIST,REFRESH,REMOVE,ALL,class => are other Cascade types.

CascasdeType.REMOVE : => if the user is removed :=> associated users will also be removed.
CascasdeType.ALL : => to happen cascading with every operaration.(create, delete, update...)

Session - 17
--------------
Implementing Inheritance

Inheritance to relational table mapping is a challenge.

Hibernate default way for implementing inheritance is Single table sttergy.

@Entity
class Vehicle{
	@id
	int id;
}

@Entity
class TwoWeeler extends Vehicle{

	String handleSize;
}
@Entity
class FourWheeler extends Vehicle{

	String steringSize;
}

Vehicle a = new Vehicle();
a.setId(1);

Vehicle b = new TwoWheeler();
b.setId(2);
b.setHandleSize(10);

Vehicle c = new FourWheeeler();
c.setId(3);
c.setsteringSize(30);

session.save(a);
session.save(b);
session.save(c);

Here =>
Hibernate create only a onetable named Vehicle.

dtType, 	id, HandleSize, SterringSize
Vehicle     1    
TwoWheeler  2     10
FourWheeler 3                    20

=> So, to differentiate the Object type, => 'dtType' column is used.
=> THis is the default way of hibernate behaviour to facilitate inheritance.


Lession 18 - Specifiing Inheritance 
---------------------
In Parnet Type

@Entity
@Inheritance(sttargy=InhetitanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicleType", discriminatorType=DiscriminatorType.STRING)
class Vehicle{
}

@Entity
@DiscriminatorValue("bike")
class TwoWheeler extends Vehicle{
}


Lession 19 - Table per Class Stratergy Inheritance
--------------------------------------------------

@Entity
@Inheritance(sttargy=InhetitanceType.TABLE_PER_CLASS)
class Vehicle{
@id
@GeneratedValues
int id;
}

@Entity
class TwoWheeler extends Vehicle{
String stering;
}

=> This will crate two different tables for Vehicle and TwoWheeler.
=> A single sequence in GeneratedValue will be used in both tables.

Vehicle table(id);
TwoWheeler table(id,stering);

=> Descriminater colum in not ndded any more.
=> Table per class looks better than single table stratergy.


Lession 20 - Join Table sttergy
-------------------------------

@Entity
@Inheritance(stratergy=InhetitanceType.JOINED)
class Vehicle{
@id
@GeneratedValues
int id;
String name;
}

@Entity
class TwoWheeler extends Vehicle{
String stering;
}

class FourWheeler extends Vehicle{
String numOfSeats;
}

=> Vehicle table(id,name);
=> TwoWheler(id,steering);
=> FourWheeler(id,numOfSeats);

Lession 21 - CURD operations
----------------------------

C - session.save(object) ; / session.persist(object);
R - session.get(object)  ;

//create
for(int i=0;i<10;i++){
	User u = new User();
	u.setName("user name" + i);
	session.save(u);
}

//Retrive
for(int i=0;i<10;i++){
	User u = (User)session.get(User.class,i);
	System.out.println(u.getName());
}

at Get => First level data is pulled up Egarly. Only the three types of relationshipss(oneToOne, manytoOne, oneTomany, manytoMany)
=> does not load egarly.
=> So ven after the sesion.close(); = > u.getName() works without any issue.


//Delete
for(int i=0;i<10;i++){
	User u = (User)session.get(User.class,i);
	session.delete(u);
}

=> First hibernate executes a select statement and then executes a delete statement.
=> This is becuase :
hibernate need to have the object in persistance state. The objects should be in persistant state
if to call hibernate interceptors.


//Update
for(int i=0;i<10;i++){
	User u = (User)session.get(User.class,i);
	u.setUserName("updated Name" + i);
	session.update(u);
}

=> It first  run a select query to take the object to persist state.
=> Then hibernate executes a update statement.


Lession 22 - Trasient, Persistant, Detach Objects
--------------------------------------------------

Transient Object : is an object Before saving an object to the data base.

AbstractPerson p4 = new StaffMember(); 
p4.setFirstName("Dimuthu"); 
=> P4 is called as a trasient object here. Hibernate does not know that hte object to be saved.

//saving the object to database
session.save(p4);
session.getTrasaction().commit();
=> Now p4 object is in persist state : means hibernate is tracking the object.

p4.setFirstName("Dimuthu Darshana");
=> With above commit 	step : hibernate automatically(we do not need to call ) executes
=> update AbstractUser set firstName = "Dimuthu Senanayaka" where id = 1;
=> this is becuase the obejct is in hibernate persist state.

conclution
-----------
=> once a any object is saved(handovering the object to hibernate === PERSISTANT object)
session.save(object); => what ever chanegs mades on the obejcts are saved to the data base at   
  => setssion.getTrasaction.commit();
=> what ever amount of updates are done, only the state at the commit state is updated to database.


=> once the 
	session.close() is called =(all the PERSISTANT objects goes to DETACH state)
	=> the object goes to DETACH status. changing status of the object after the session close
	=> is not going to save in the database anymore.
=>tracking detached objects is not a responsibiltiy of hibernate.

TRANSIENT => PERSIST => DETACH

Lession 23 - Understaning State changes
---------------------------------------


TRANSIENT => PERSISTANT(once the object is saved : hiberate tack cahnegs and commit at session.getTrasaction.commit()) => DETACH(once the session close)

New Object
----------     
        new Object()
TRANSIENT
        session.save()
PERSISTANT
        session.close()
DETACH

Read From DB
-----------

Object o = session.get(Object.class,1);

=> Then the object o is in PERSISTANT status by default. So it will bave persist behaviour.

for get
------

PERSISTANT
     session.close();
DETACH


session.delete(object)
----------------
The record will be deleted in database.
=> The object goes to the Trasient state.

So => two way to convert from 	persistnat to transient(session.close() or session.trasient()).


Lession - 24 - Persisting Detached Objects.
------------------------------------------

Ex: Required at

=> User u = session.get(User.class,1); from database.
=> session.getTransaction().comit();
=> session.close();

Now object is in detached state. Since the session is closed. 
Lets think a user takes about 2 min and update the object. (session is closed, since it is not good 
keeping the sessio open for a long time)

now update the user. 
u.setName("New Name");

session = SessionFactory.openSession();
session.beginTransaction();
session.update(u);

session.getTrasaction().commit();
session.close();

=> Hibernate will execute a update query here.

case 2
----------------------------

=> User u = session.get(User.class,1); from database.
=> session.getTransaction().comit();
=> session.close();

session = SessionFactory.openSession();
session.beginTransaction();
session.update(u);

session.getTrasaction().commit();
session.close();

=> Hibernate will execute a update query here. Tough the object is not updated, hibernate does not know that
since session is terminated. So hibernate will run the upxate query.

HOw to avoid this. => hibernate gives an unswer.(not JPA)

@Entity => JPA
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
class User{
}

=> Then hibernate will run a select query before the update, to get the obejct to persistant state. Then update query is 
run if any only if it is required.


So => From the User class prospective
	=> if there is a good chance object has not been change => use selectBeforeUpdate=true
	=> if the object should have been change frquently => dont use selectBeforeUpdate=true(additional select query is a over head)
	
	
Lesssion 25 - HQL and Query Object
-----------------------------------
hql -> think about objects not about tables.

Query query = session.createQUery(from User where userId > 5);
List<User> users = List<User>query.list();

System.out.println(users.size());

Lession 26 - Select and pagination
----------------------------------

Setting the required ROWNUM
	Query q = (Query) entityManager.createQuery("from AbstractUser");
	q.setMaxResults(30);
	q.setFirstResult(50);
	List<AbstractPerson> setFirstResult2 = (List<AbstractPerson>)q.setFirstResult(40);
	
	for(AbstractPerson p : setFirstResult2 ){
		System.out.println(p.getFirstName);
	}
		

But here hibernate query every colum of the table. To avoid it => Modify the query


Setting the required ROWNUM
	Query q = (Query) entityManager.createQuery("select FirstName from AbstractUser");
	q.setMaxResults(30);
	q.setFirstResult(50);
	List<String> setFirstResult2 = (List<String>)q.setFirstResult(40);
	
	for(String p : setFirstResult2 ){
		System.out.println(p.getFirstName);
	}

OR

Setting the required ROWNUM
	Query q = (Query) entityManager.createQuery("select newMap(userId, firstName	) from AbstractUser");
	q.setMaxResults(30);
	q.setFirstResult(50);
	List<Map<String,String>> setFirstResult2 = (List<String>)q.setFirstResult(40);
	
	for(String p : setFirstResult2 ){
		System.out.println(p.getFirstName);
	}
	
-> most of sqls works fine with HQL also. But property names of objects should be used instead of colum names.

	Query q = (Query) entityManager.createQuery("select max(userID) from AbstractPerson	) from AbstractUser");
	
	
Lession - 27 - Parameter Binding and SQL Injection
--------------------------------------------------

SQL injection

String userId = "5 or 1=1";
	Query q = (Query) entityManager.createQuery("from from AbstractUser where userID =" + userId);

=> Now the where clause is by passed. Since or 1=1.
=> Here the query will list all the end usesr whith is a security problem.

Solution is => parameter substitution
-----------
Using place holders
	Int userId = 5;
	Query q = (Query) entityManager.createQuery("from from AbstractUser where userID = ?);
	q.setInteger(0,userId);
	
	Int userId = 5;
	Query q = (Query) entityManager.createQuery("from from AbstractUser where userID = :x);
	q.setInteger("x",userId);


Lesson 28 : Named Queries
-------------------------

easir to maintain and organize quaries.
named querys are written at the Entity classes.


@Entity
@NamedQuery(name="AbstractUser.byId", query ="from AbstractUser" where userId = ?)                   => HQL
@NamedNativeQuery(name="AbstractUser.byName" query = "select * from user_details where user id = ?",resultClass=AbstractUser.class) => native sql
class AbstractUser{

}

Query q = session.getNamedQuery(AbstractUser.byId);
q.setInteger(2);
List<AbstractUsers> users = (List<AbstraactUsers>) query.list();


Query q = session.getNamedQuery(AbstractUser.byName);
q.setInteger(2);
List<AbstractUsers> users2 = (List<AbstraactUsers>) query.list();

Lession 28 -  Introduction to Criteria API
--------------------------------------------

HQL is another form of SQL. so HQL has not helps to reduce the sql letngth.

=> Critierias helps to eleminate the where clause.

SessionFactory sfac = new Configuration().configure().buildFactory();

Session session = sfac.openSession();
session.beginTrasaction();

//creating the criteria with criteria class
Criteria criteria = session.createCriteria(AbstractUser.class);
criteria.add(Restrictions.eq("userName"), "Dimuthu");  //check the equlity

List<AbstractUsers> users = (List<AbstractUsers>)criteria.list();
session.close();

for(AbstractUser u : users){
	System.out.println(u.getUserName());
}

Lession 30 - Understanidng Restritions
-----------------------------------------

Criteria can be chaned.

criteria.add() => return back the criteria. So, it can be chinged.

criteria.add(Restrictions.eq("userName"), "Dimuthu")
		.add(Restrictions.gt("userId",5)
		.add;  //check the equlity
		
OR close
--------		
		
	session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(AbstractPerson.class);
		criteria.add(Restrictions.eq("userName", "Dimuthu")).
		add(Restrictions.between("age", 10, 15)).
		add(Restrictions.or(Restrictions.le("userId", 5),Restrictions.gt("salary", 100) ));
		
Lession 31 - Rejections and query by examples
----------------------------------------------

Projection

criteria.setProjection(Projections.property("userName"));
		
criteria.add(Restrictions.eq("userName", "Dimuthu")).
add(Restrictions.between("age", 10, 15)).
add(Restrictions.or(Restrictions.le("userId", 5),Restrictions.gt("salary", 100) ))
		
aggrigtion functions
--------------------			
criteria.setProjection(Projections.max("userName"));


Order by
--------
		criteria.addOrder(Order.asc("userId"));

Then
=> When teh query gets complex critieia also gets complex.
=> HIbernate solves this by query by examples.


		//creating the example user
		AbstractPerson pe3 = new AbstractPerson();
		pe3.setDob(new Date());
		pe3.setIdInternal(Long.parseLong("12312"));
		pe3.setFirstName("Dim%");
		
		//HIbernate ignore primary key and null vaues of the example object.
		//then hibernate return similar objects with example object, from the database
		
		Example example = Example.create(pe3).enableLike();
	   session = HibernateUtil.getSessionFactory().openSession();
		
		criteria = session.createCriteria(AbstractPerson.class);
		criteria.add(example);
		
		
Lession 32 - Cacheing in hibernated
------------------------------------

HIbernate started as a ORM tool, but now there are more solutins in it.


By default FirstLevel of chache is enabled witht the session object.

Usage of first leevl of chche
------------------------------

If we run sesson.save(o), with out any real update on the object which is retrived from the database
hibernate do not execut the udpate query.

If we do session.get(object), from database twise. Hibernate does not go to the database twice. second time
it gives the object from its cache.

*The level oneCash is attached with the session, not with the trasaction*

But
we donot keep the session open for a long time. When the interfaction with db is done. we close the session.

So second level is cache is needed => accross different sessions
=> the objects does not leave the cache even though the session is closed.

=> then hibernate will search objects in first level of cache, if it is not found search in
second level of cache.

=> In the fist level chache(session) => the persistancy context is local to the session. There is no any
relationship.
1) If one session reads from db : => If another session also reads => hibernate executes a new select query to db.
2) If one session updates an object => but still not commited to db => if second session reads the object from db
=> it will read the non modifed vaule from the database.

second level cache
------------------
1) accross sessions in a application
2) accross applications
3) accross clusters 


Session s = sessionFactory().openSession();

Abstract user1 = s.get(AbstractUser,1); =>  Hibernate executes a select query here and gives the user1.
user1.setName("changed name");

Abstract user2 =  s.get(AbstractUser,2); => Hibernate DOES not executes a select query and gives the object from cache here.


How to tonfigure leve2 cache
-----------------------------

<property name="hibernate.cache.region.factory_class">
org.hibernate.cache.ehcache.EhCacheRegionFactory
</property>

<property name="hibernate.cache.region.factory_class">
org.hibernate.cache.ehcache.EhCacheRegionFactory
</property>
<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.use_query_cache">false</property>
  
 At the entity class =>
 
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

session1.save(object);
session1.close();

		
Object o = session2.get(Object.class,1); => hibernate does not go to the database here. IT takes it from 2nd level cache.
session2.close();

		
Lession 34 - Query Cache
------------------------

HIbernate first level chache does not work with session.createQueries. Hibernate goes to the db every time.

This is to enable the hibernate Query cacheble.


<property name="hibernate.cache.region.factory_class">
org.hibernate.cache.ehcache.EhCacheRegionFactory
</property>
<property name="hibernate.cache.use_query_cache">true</property>
  
	
Query query1 = session1.createQUery(from User where userId > 5);
query1.setCacheble(true);

Query query2 = session2.createQUery(from User where userId > 5);
query2.setCacheble(true);

=> Now hibernate does not goes to db for the same query again, even within same session or separate sessions.


  
Understanding JPA
------------------

1) JP - API
2) JPQL
3) JPA Criteria API
4) ORM meta data


// No Entity will be associated directly with AbstractDomainEntry, and no object of it will be created.
//But only  more specific objects will be associated with each other
//So AbstractDomainEntry is not an Entity, but a @MappedSuperclass.
// clild class objects like Person, Course, Registration etc.
//
// @MappedSuperclass also has a persistance state and mapping info. But are not entites.
//@MappedSuperclass => these are not mapped as entiteis by the JPA provider.
//@MappedSuperclass => can not be used in JPA queries.
//@MappedSuperclass => can not be target in entity repationships
//@MappedSuperclass => do not have any table => allways goes in table per class fasion.
 
 Non Entity Super Class
 ----------------------
 
 => state of nonEntity supper => is non persistant.
 => can not be used in Query or EntityManager operations
 => Any Anotation in nonEntitySupperClass are ignored
 
 
 Managing Entities ( By EntityManager)
 --------------------------------------
 
 javax.persistance.EntityManager instances
 => Each EM instance is associated with a Persistancy Context.
=> PC => is a set of managed entity instances, in a data store.
=> EM  interface define the methods to interact with PC.

EM => create, remove, search by primary key, search by query the entities.

 
 Container Managed Entity Managers
 ---------------------------------
 
 => EM's associated persistancy context is propergated by the container to 
 application components that use the EM instance within a single JTA transaction.
 
 => NOrmally JTA trasacction involves calls accross the application
 => But this JTA trasaction need to access a single persistancy context, normally.
 
=> This is achived at => injecting EntityManager to the varias parts of the application => and using
 the "javax.persistence.PersistenceContext" annotation.
=> here same persistancy context is propagated to every component within a single transaction.
=> and Entity manager references of same persistance unit, mappes to this same persistance unit within the
=> transaction.

=> so by propergating the same persistancy context => application components do not need to pass
refereces of entity manager instances, within the same trasaction.

=> container manages the life cycle of container managed EMs.

=> To obtain a EntityManager within the application, => use,

@PersistenceContext
EntityManager em;

Application Managed Entity Managers
------------------------------------

=> PC is not managed by the container and the life cycle of EM is managed by the application.

=> Here, each EM creates its own isolated persistancy context, explicitly.

Em em = javax.persistence.EntityManagerFactory -> createEntityManager method.

=> EntityManagerFactory can also be injected into the application.

@PersistenceUnit
EntityManagerFactory emf;

EntityManager em = emf.createEntityManager();

=> the trasaction should be handled manually.

EntityManagerFactory emf;
EntityManager em;
@Resource
UserTransaction utx;
...
em = emf.createEntityManager();
try {
  utx.begin();
  em.persist(SomeEntity);
  em.merge(AnotherEntity);
  em.remove(ThirdEntity);
  utx.commit();
} catch (Exception e) {
  utx.rollback();
}


Note : EntityManagers are not thread safe. But entity manager factories are thread safe.

//search customer
 * 
 *     Customer cust = em.find(Customer.class, custID);


//persisting => moving the entity to managed state
 * ---------
 
 a) calling persist method
 b) calling persist method on a "cascade=PERSIST or cascade=ALL" object
 
 
 => if the entity is detaced and now call persist will throw IllegalArgumentException.
 => commit operation will fail.
 
Remove
------
call remove method or, on cascade=REMOVE or cascade=ALL.

Persistance Unit
----------------

1) define set of all entity classes managed by a entityManager instance in the application.
2) defined in a persistance.xml file, in WEB-INF/classes/META-INF.

Querying Entities
-----------------

JPQL
----
=> Type unsafe, => required casting results.


Criteria API
-----------
=> type safe => No casting is needed.


JPQL
---

=> query can be written by

em.createQuery                       => used to create dynamic queries which are at business logic.

public List findWithName(String name) {
return em.createQuery(
    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
    .setParameter("custName", name)
    .setMaxResults(10)
    .getResultList();
}

em.createNativeQuery methods.        => used to create static queries. which are meta data.

@NamedQuery(
    name="findAllCustomersWithName",
    query="SELECT c FROM Customer c WHERE c.name LIKE :custName"
)

public EntityManager em;
...
customers = em.createNamedQuery("findAllCustomersWithName")
    .setParameter("custName", "Smith")
    .getResultList();
    
    
Named parameters
----------------

public List findWithName(String name) {
    return em.createQuery(
        "SELECT c FROM Customer c WHERE c.name LIKE :custName")
        .setParameter("custName", name)
        .getResultList();
}


positional parameters
---------------------

public List findWithName(String name) {
    return em.createQuery(
        “SELECT c FROM Customer c WHERE c.name LIKE ?1”)
        .setParameter(1, name)
        .getResultList();
}





  
 * 
 * */

	
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dim.cls.dao.abstracts.GenericHibernateDao;
import com.dim.cls.model.Address;
import com.dim.cls.model.HibernateUtil;
import com.dim.cls.model.Identity;
import com.dim.cls.model.StaffMember;
import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.model.util.SysFlag;
import com.dim.cls.pay.dao.api.UserDao;
import com.dim.cls.util.SysFlagDao;

@Repository
public class UserDaoImpl  extends GenericHibernateDao<StaffMember>  implements UserDao {
	
	
	//Hibernate support below persistencey contexts (Moving entities between states)
    // 1. Hibernate Session => propritary to hibernate
	// 2. javax.persistancy Entity Manager => JPA 2 standard
	
	//status of objects associated in persistancy context(cache of JPA 2.0)
	// 1. new, or transient => entity is just initiated. not present in persistancy context. Not in DB. No identifier is assigned.
	// 2. manage / persist => has an associated identifier and associated with persistancy context.
	// 3. detached => entity has a associated identifier => but not associated in PC now.
	// 4 removed => entity has a associated identifier => but schedueld to remove from DB

	//@Autowired
	//private SessionFactory sessionfactory;
	
	//@PersistenceContext(name="onePADB")   //this will do the autowire Just as @Autowire
	//private EntityManager entityManager;

	
	/*
	@Transactional(propagation = Propagation.MANDATORY) //the stack who calls this method should already have a transaction.
	//if the below mehod is called outside a trasaction it gives an error because of Propagation.MANDATORY.
	public void saveUser(StaffMember staffMember) {
		System.out.println("5");
		sessionfactory.getCurrentSession().saveOrUpdate(staffMember);
		
		//entityManager.persist(staffMember);
		System.out.println("4");
		
		//getCurrentSession is not valied without a valied trasaction. It gives the current session on which the current trasaction
		//is handled
	}
	*/

	/*
	public List<StaffMember> findAll() {
		//@SuppressWarnings("unchecked")
		List<AbstractPerson> userlist = sessionfactory.getCurrentSession().createCriteria(AbstractPerson.class).list();
		//List<AbstractPerson> userlist = entityManager.createNativeQuery("select * from test", StaffMember.class).getResultList();

		
		return userlist;
	}
	*/
	
	/*
	public List<AbstractPerson> testMethod() {
		//@SuppressWarnings("unchecked")
		List<AbstractPerson> userlist = sessionfactory.getCurrentSession().createCriteria(AbstractPerson.class).list();
		
		//q.setMaxResults(30);
		//q.setFirstResult(50);
		//List<AbstractPerson> setFirstResult2 = (List<AbstractPerson>)q.setFirstResult(40);
		
		return null;
	}
	*/
	
	public List<AbstractPerson> testMethodCriteria() {
		return null;
	}
	
	@PostConstruct
	public void init(){
        super.setClazz(StaffMember.class);
		System.out.println("User Dao Bean is initialisedd");
	}

	
}