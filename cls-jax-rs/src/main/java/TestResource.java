/*
 

RESTfull web services
---------------------

=> REST does not have set of rules. It is a archetectural style. So only convention.


Action base URI
-----------------
whetherapp.com?zipcode=12345

Resource Location based URL (Not expecting an action. But looking for an existing data)
----------------------------
whetherapp.com/zipcode/12345

=> for every resouce => there is a standard uri

http methods
------------

get    => whetherapp.com/zipcode/12345
post
put => 
post
delete

depends on the action of teh rest API, select the method.


http meta data
----------------

Ex : status code of http response
200 - success
500 - server errror

So, status codes are very important to client of the API, to work.

restful can response in any of xml, json, plain ..etc
------------------------------------------------------

So how the client identify the type of the response is : header value named : "content-type" meta data.

content-type
------------
1) text/xml
2) application/json

same API may return different content types based on the client request.

So, => server and the client first do => content negotiation

RestFul URIs => contain nouns, but not verbs like getMessage etc.
-------------
=> Does not depends on the framework.


Ex :

/profiles/{profileName}
/messages/{messageId}

Resource Relation
-----------------

First level entities
---------------------

/messages/1
/messages/2

: /messages/{messageId}

second level entities
-----------------------

comments/1/comments/4
: /message/{messageId}/comments/{commentId}

=> Above are one to one or one to many relations.

There are two types of Restfull URIs
------------------------------------
Instance resource URIs  => Single instance is access by the URI.
-----------------------
Ex: /messages/{messageId}

=> URIs have the resource Id

Collection Resoure URIs
-----------------------

Ex: /messages 
To get all messages

/messages/2/comments
commments for message 2.


But there is no URI for => get all the comments, irrespective to the message. (This based on the design of URIs.)
=> it designed this way since, getting all teh comments irrespective to the message is uncommon.


Filterming Results / Pagination using Query parameters
-------------------------------------------------------

Ex : mesasges/?offset=30&limit=10
	 messages/?year=2014&offset=30&limit=10
	 
	 
In action based URIs were like => getMessage to getting a message, postMessage to save a message etc.

But In RestFull -> All have the same URI and the action is desided by the http method 
(common : get, post, put, delete
uncommon : head, options)

GET  : => Getting an resource. get method : messages/10
POST : => creating new resource. Request alwasys go to the collection URI, since the ID is not yet created. /messages. Body contain the resouce content.
PUT  : => Update or change resource. messages/10 (Request body is the content of the new message)
DELETE : => Deleting an resource. message/10. No request body is requeired.
		

create : POST
=message => messages/1
=profile => profiles
.
=> the request body contain the information of the resources to be created.
=> the response contans the resource ID just created. /messages/21


Colelction URI
---------------
POST :
/messages/10/comments => create a new comment for message 10.
PUT :
/messages/10/comments => replace all comments of message 10.
DELETE
/messages/10/comments => Delete all comments of message 10.


Archive message, Run a job etc ..  misalaneous operations(non curd opeartions) => will discuss later.

IDEMPOTENT in HTTP
-------------------

POST => to create a resource 
PUT => to update a resource

classification1

A read only method.
--------------------
GET   => safe to do the same multiple times.

beow are write methods.
-----------------------
POST
PUT
DELETE


Repeteble methods => GET, DELETE, PUT => IDEMPOTENT methods => HTTP protocal request us to use this methods in this way.
----------------------------------------------------------------------------------

DELETE the same multiple time does not have an impact. SInce it is already deleted.
PUT -> message/10 => no prob, since the same will be update multiple times.

Non repetable methods => POST => NON IDEMPOTENT methods
----------------------------------------- 
= /message
=> this creates a multipe  => so not safe to call multiple times.


Cacheig only GET responses => use if more more request is received within a short period of time.

JSON
----

java script at bworser can convert json messages to java script messages fast.
json is more compact than xml.

so JSON is getting popular over xml.

json representation
---------------------
{
	"id" : "10",
	"message" : "hellow",
	"auther" : "dimuthu"
}

xml representation
-------------------
<MessageEntity>
	<id>10</10>
	<message>hellow</message>
	<auther>dimuthu</auther>
<MessageEntity>

=> this is way REPRESENTATIONAL state trasfer(REST)

HTTP headers
-------------
status code (200 OK, 404 Not found)
Message length
Date
content-type

Message Body
-------------

HTTP staus codes
-----------------
100 t 599

1XX => INFORMATIONAL.
2XX => SUCCESS (200=OK, 201 = CREATED, 204 = NO CONTENT)
3XX => REDIRECTION (ASK CLIENT TO DO MORE ACTIONS. 302 = FOUND, 	304 = NOT MODIFIED(SAME AS GIVEN BEFORE, 307 = TEMPARALY REDIRECT)
4XX => CLIENT ERROR (400= BAD REQUEST, 401= UNAUTHORIZED, 403=FORBIDDEN, 404 = NOT FOUND, 405 = UNSUPPORTED MEDIA TYPE)
5XX => SERVER ERROR(500= INTERNAL SERVER ERROR)

It is a good practise to send correct error codes to the consumer of the REST API.

	
HATEOAS(Hypermedia As The Engine Of Application State)
--------
=> way of sending "required uris are also sent in the response"

{
id
message
auther
commentsUri
shareUri
autherProfileUri
}

/messages
{

	{
		id
		message
		auther
        href : /messeges/1
		comments-href  : /messages/1/comments
	},
	{
		id
		message
		auther
        href = > instant URL to the same resource.

	},
		{
		id
		message
		auther
        href = > instant URL to the same resource.
	}
}
=> but in above way also the client has to remember the property names of links.



/messages
{

	{
		id
		message
		auther
        links : 
				[
				{
					href : /messges/1/
					rel:self
				},
				{
					href : /messges/1/comments
					rel:comments
				},
				{
					href : /messges/1/share
					rel:share
				}
				]
	},
}

=> the way of presenting links may diffeer implementation to implementation.


Richardson Maturity Model
-------------------------
=> To determine how RESTful is an API ?

level 0 -  not restful
------
=> the operation is in the message body.

Ex: In a SOAP request
<create-msg>
	<id>10</id>
	<body>Test message</body>
</create-msg>

So, same HTTP method can be used in every soap request since the action is mentioned in the message body.
this is Swamp of POX(Using Plain Old Xml to define everything, including the action.)
No HTTP concepts are used to communicate info.

level 1
-------
Individual URIs for each resource. 
/messge/1
/profile/2
/messages


level 2
--------

Introduce different HTTP methods for different operations.
Use HTTP status code.

level 3
-------
Response has links to other importatt resources. Implement HEATOAS

RESTful in practise - writing RESTful APIS using JAX-RS
-------------------------------------------------------

JAX-RS is a an API.
Jersy, Restlet, CXF, ... and few implements JAX-RS


So, JAX-RS is a set of interfaces and annotations. => But no implementation. Implementatinos do the actual work.
=> implementation reads the annotations and do the work.

Every implementation of JAX-RS, has a copy of API(interfaces, annotations) classes also.

=> Application code depends only on the JAX-RS code. So, the code run on backside(implementation)
can be changed seemlessly.

Why Jersy
---------
Becase is the referece implementaion for the API.
developed by same people who implemented JAX-RS.


Applicaton Archetecture
-----------------------

Directing requests to 
org.glassfish.jersey.servlet.ServletContainer
=> Provide the resource classes as a jersey.config.server.provider.packeg parameter.

<servlet>
    <servlet-name>Jersey Web Application</servlet-name>
    <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
    <init-param>
      <param-name>jersey.config.server.provider.packages</param-name>
      <param-value>com.dim.jaxrs</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>

JerseyServelt checks for the annotated classes


@Path("myresource") => url mapped to a resouce classs
@GET => method call is mapped to a method
@Produces(MediaType.TEXT_PLAIN)  =>    //return information formatting type of the method
(ex : application/xml, application/json)

//In model -> if we add a constuctor -> make sure to add a noArg constrccutoer also.
 * -> because frameworks use it.
 * 
 
 -> If the mediaType is XML and we are returning an object by the method.
 	=> there is exception as => contextBodyWriter is not found.
 	-> (Meaning Jersy do not know how to convert the object to an xml )
 	
 	=>Hhere we can use JAXP( JAVA API for XML processing) to conver the object to xml.
 	
 	here
 	->
 	
 	Model class should be annotated with @XmlRootElement
 	
 	@XmlRootElement
 	public class ModelObject{
 	}
 	-> if we manually add constructers. A no arg construction should also be added.
 	-> this is needed by JAXB
 	
 	-> @XmlTransient
 		=> skip an attribute from returning in xml body
 		

HTTP Rest Client :
	-> postmen -> a plugin of chrome
	-> Get request does not have a requst body
	-> but POST/PUT has a request body
	

Spring + Jersy integration

		<!-- for Jersey without Spring (No webapplicationcontext is loaded) 
		<servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class> -->
		<!-- Jersey with Spring. webapplciationContext is loaded by this -->
		<servlet-class>com.sun.jersey.spi.spring.container.servlet.SpringServlet</servlet-class>

 => Componets managed by SPring will not be managed by Jersey and Jesey lifecycle annotation will be ignored.
 => Thre resource class will beocme Singalton.(In original jeersy servelt -> resouce and once a request)
 
 //When spring @Autowiare => constructor, or setter is not rquired.
 
 //JPA persist vs merge
 
 persist => insert a new row to Db. Attach the object to persistancy context => thwos EntityExistsException is entity exists
 merge => find an attached object and update it and return the object.
 		=> if does not exit => add record to db
 
 
JAX-RS @path annotation can be keep at both class and methods.

 
 @Path
 @Path("/{id}")
 @Produces(MediaType.APPLICATION_XML)
 public User getUser(){
 }

=> Biggest changel using JAXB and Hibernate

	=> Hibernate lazy loading
	=> Then when the JAX B tries to call getters outside a trasaction => session close execption is comming
	=> JAXB unmarshing happens at the last miniute(After the trasaction is completed)
	=> properties can be set as @XmlTransient to avoid prasing in XML. or can be eagar loaded.
	=> futher stuy is need on this => how to use JAXB with Hibernate lazy loading
	
JAX-RS => @path => can contain the regular expressions also.

RETURNING JASON
---------------=

=> chaneg media type to jason

	@Produces(MediaType.APPLICATION_JSON)
	
	=> thouse JAXB is there for XML, there is no similar service in JEE for json.
	=> so we have to add a extra libery to do the conversion. => jersey-json and jersey-media-moxy
	=> this liberty provides the message body writter needed for object to json conversion.
	
=> Impelemnt POST method
---------------------
	=> message body contain the information of the object to be saved
	=> the mesage body may contain json , xml ...
	=> in the headder of request => we need to sent context-type as json.
	    => this is used by the server to understnad that message body is in json format
	    
	@POST
	//this method consumes the json send on body of the message
	@Consumes(MediaType.APPLICATION_JSON)
	//jaxrs will looking to json data and will consturct staffmemebr object and inject to this method
	public StaffMember addStaffMember(StaffMember staffmember){
		userService.saveOrUpdate(staffmember);
		return staffmember;
	}	    
	
	
	
	
	
	
	
	





	
	




































































































































































































































































































































































































Advance JAX-RS
==============

Jersy Param conversion
----------------------

ParameterConver class
	=> should implements ParamConverter interface.
	 => It has public T fromString(String value), public String toString(T value)
	
ParameterConverProvider clss -> Jersy looks at all avilable parameterCOnverterProvider class to 
find the ParaeterConverter class for the reuqested param conversion.
	=> this class should implement "javax.ws.rs.ext.ParamConverterProvider" interface
	
// Jersey send below parameters to "getConverter" method of "ParamConverterProvider".
 Class<T> rawType, 
 Type genericType, A
 nnotation[] annotations

@Provider annotation should be placed to register the ConverterProvider in JAX-RS

MessageBodyReaders & MessageBodyWriters
---------------------------------------

MessageBodyWriter = > write objects to the response/payload of JAX-RS call. (json or xml)

MessageBodyReader => convert request to java objects. In POST, and PUT methods pay load come on the message body.


Difference Between MessageBodayWriter / MessageBodyReader and ParamConverter
-----------------------------------------------------------------------------

MessageBodayWriter, MessageBodyReader => deal with the payload/body(xml,json) of the request/response
ParamConverter => deal with the parameters of the request(query param and pathparam, header param, cookie param)

All three types do the object <-> String , onversions.


Ex :

PUT request 

header info =>  can be read by Param Converter

/webapi/user/koushik
 * 
 * here Koushik is the path param => can be read by Param Converter
 * 
 * {data: "" ,,,} => this is the message body => can be read by MessageBodyReader


Custom Media Types ( then this media type can be used instead of jason/xml)
---------------------------------------------------------------------------

Ex :

Annotate the method with below media type

@Produces("text/shortdate")


RESTful Client. JAX-RS

		Client client = ClientBuilder.newClient();
		Response rs = client.target("http://localhost:8080/cls-jax-rs-messages/webapi/messages/1").request().get();
		Message msg = rs.readEntity(Message.class);
		System.out.println(msg.getMessage());
		
Best Practises Of Clients
-----------------------------
	
	1) one Instance of client for the requeat.
	2) create the targent for => base url
	Check RS_CLint_Test.java class
	

//CREATING A POST REQUEST
//CREATING A PUT REQUEST
 * 
 * 
 *Invocaction  => creating a request at a single place and calling it from another place
 * Generic Types
 * 
 * => covered in "RS_CLint_Test.java"
		
Web Service Authentication/Security in JAX-RS
---------------------------------------------


=> Best way is using filters => for cross cutting resources.
=> Ex : LoginFilter
		a. Request Filter   => implement COntainerRequestFilter (ContainerRequestContext)
		b. Response Filter  => implement CntainerResponseFilter(ContainerRequestContext, COntainerResponseRequest)

JAX-RS first call the filter.

	
How the classic Session based authentication works
--------------------------------------------------

client pass username/password

server authenticate and create a session object
webserver creates a - session which has a ID(session)

session token is sent to the client back.

Client sent this value back in a Cookie => then server knows that this is a known logged sessin.

when the logout => session is closed by the server.

RESTful webservice has a problem with above classic way
	=> because RESTful is stateless.(client/server does not maintain any state)
	=> No information is maintained accorss multipel requests
(server should not remember anything about the previous requests)


STATELESS Authentication
-------------------------

1) Basic Access Authntication

	a. for every single request, it sends username and password information.
	
	=> username and the password is sent on the header of request.
	
	=> username:password -> do base64 encoding -> take encoded username:password
	=> then this combined value is sent to the server on request header like below.
	
	Autherization: Basic asdfwWFLLHlhlKJHJLLJK34343=
	
	=> server gets the request => then check Autherization header value => then cehck for the Basic word
	=> then get the base64 decoding.
	=> then server knows username:password => then can be validated over stored username and password.
	
	=> Note => this is not encryption(secret) => 
	=> So, This is not secure.
	=> So the request should be sent on HTTPS always, if it is basic autherization.
	=> then why encode : To make remove the Non HTTP compatible characters removed, by encodeing.
	
	Advantages
	----------
	Simple
	stateless server
	supported by all browsers(Since info in sent on header)

	
	Advantages
	----------
	Required HTTPS
	subject to replay attacks.
	Logout is tricky.(Browser caching)
	
Betetr solutions
----------------

Digest Access Authentication
----------------------------
1) this do the encription of secrekey(not username password)


Asymmectric cryptography
-------------------------
	a. this uses public key and private key
	
	
OAuth
-----

OAuth2
------
=> this is getting popular

Json webtokens
--------------

Postmen support => preparing Basic Access Authntication and => it does the required formatting(encoding) for us
( if the username:pwd is test:test 
=> it is encoded by the postmen.
=> then it is added as a header parameter in required format.


Implementing Authnticated REST API
------------------------------------

Check SeruredResource and SecurityFilter => security is implemented by a => ContextRequestFilter

Missalaneous Topics
-------------------

Filters and Intercepters
------------------------

Intercepters => Model similar to Filters.
=> Intecepters used to manupulate the body of messages(Entities)
=> Filters are used to manupulute the Header of requests/responses

There are two types of intercepters
----------------------------------

1) WriteInteceptor
2) ReadInteceptors


Examle : A output inteceptor to ZIP the content of response body.


Differnece Between Filters and Intecepteors

Filter
	=> reuqst and response parameters, URI,headers..
		=> Request Filter
		=> Response Filter

	Ex: Login, authentication etc. Crosscutting concerns

Interceptor
	=> manupulate entities 
			=> Read Inteceptor
			=> Write Inteceptor

	Ex: Encoding an entity response(GZIP)
	
	
	
Client Side Filters and Inteceptors
-----------------------------------

	Filters
		ClientRequestFilter
		ClientResponseFilter
	
	Interceptors
		ReaderInteceptor
		WriterInteceptor
	
	Readers
		MesasgeBodyReader
		MessageBodyWriter
		

Difference Element getCalled order
----------------------------------

Request from clint to server goes thorugh, like below.

Client Side
ClientRequestFilter(param monipulator) -> ClinetWriterInteceptor(Body manupulator) -> MessageBodyWriter
Server Side			
 -> COntextRequestFilter -> ContextReaderInteceptor -> MesasgeBodyReadr(Payload to java instance)
	
	
response from server to client
server side
ContainerResponseFilter -> WriterInteceptor->MesasgeBodyWriter 
cient side
ClientResonseFilter -> ReaderInteceptor-> MessageBodyReader


JAX-Rs and EJB
--------------

EJC -> CDI -> Component Dependency Injetion

=> can injected using annotations


=>	JAX-RS resoces should be converted to Singalton/ stateless beans

@Stateless
@Path("jax-rs-resouce")
public class StatelessResource


=> above works tipical Stateless EJB and a jax-rs resoces (But Singalton)

@Path("jax-rs-resouce")
@RequestScope                  => binding with CDI DI in EJB.
public class StatelessResource


Above => scope of the resouce is ReqeustScope and it works in normal way as a jax-rs resource

Summary
-------

Applciation class for bootstrap appliation
Resouce life cyclce
Custom parameter
message body reader, message body writer
Custom Media Types
Jax-rs client
Making GET/POST/PUT methods
Generics in Jax-rs
filters and seccurity. Basic Auth
Inteceptor, Request Response Flow
Integration with EJB






 * */

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Singleton;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.message.internal.MediaTypes;

import com.dim.cls.model.StaffMember;

//every request creates a new instance of this class. (Not as the controller in MVC)
//never share the same instance.
//this is the behaviour of JAX-RS. :-> one instance of resource for each reuqest.

@Path("{pathParam}/test")
//@Singleton //override default life cycle of the reuest to be Singalton.
public class TestResource {
	
	private int count;
	
	//Below injection can only be done if the resouce object is not Singalton.
	//because, if Singalton, object is created before the request comes in.
	@PathParam(value = "pathParam")
	private String pathParamExample;
	@QueryParam(value = "query")
	private String queryParamExmaple;
	
	@GET	
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		
		count++;
		return "hello client : the count is : " + count + ":"+pathParamExample+":"+queryParamExmaple;
	}

}

