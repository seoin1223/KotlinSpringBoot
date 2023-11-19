# TestKotlinSpring

## 목차
1. [Kotlin](#Kotlin)
2. [SpringBoot](#Spring-boot)
3. [REST API](#REST)
4. [URI 설계 방법](#URI-설계-방법)
5. [HTTP](#HTTP)
6. [API](#API)
    - [GET](#GET)
    - [POST](#POST)
    - [PUT](#PUT)
    - [DELETE](#DELETE)
7. [API 최종 정리](#최종-정리)
8. [Rest API 응답 처리](#Rest-API-응답-처리)

## Kotlin
- JVM 언어 : Java와 100% 호환
- 현대 언어 지향
- 안정적인 null point 대응
- Java에 비해 간결한 코드, Kotlin만의 표준 함수
- 타입 추론의 편리함  

<br>

## Spring boot
- 단순히 실행되며, 프로덕션 제품 수준의 스프링 기반 앱을 쉽게 만들 수 있다.
- Spring 구성이 거의 필요하지 않다
- java -jar 로 실행하는 java 앱을 만들 수 있다.  

<br>

## 목표
- Spring 개발에 대해 빠르고, 광범위하게 적용할 수 있는 환경
- 기본값 설정이 있지만 바꿀 수 있음
- 대규모 프로젝트에 공통적인 비 기능 제공
- xml 구성 요구사항이 전혀 없음
  
<br>

## Web
- 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 전 세계적인 정보공간
- 종류
  1. Web Site
  2. User Interface
  3. API * Web Service
- 기반
  1. HTTP : App 컨트롤 ( GET, POST, PUT, DELETE ... )
  2. URI : 리소스 식별자 ( 모든 정보에 접근 할 수 있는 정보)
  3. HTML : 하이퍼미디어 포맷 ( XML을 바탕으로 한 범용 문서 포맷)
 
<br>

## REST
- Client, Server : 클라이언트와 서버가 서로 독립적으로 분리되어야 한다.
- Stateless : 요청에 대해서 클라이언트의 상태가 서버에 저장을 하지 않는다.
- 캐시 : 클라이언트는 서버의 응답을 캐시할 수 있어야 한다 -> 클라이언트가 캐시를 통해서 응답을 재사용할 수 있어야 하며, 이를 통해서 서버의 부하를 낮춘다.
- Latered System : 서버와 클라이언트 사이에 방화벽, 게이트웨이, Proxy, 등 다 계층 형태를 구성할 수 있어야 하며, 확장할 수 있어야 한다.
- 인터페이스 일관성 : 아키텍처를 단순화시키고 작은 단위로 분리하여서 클라이언트 서버가 독립적으로 개선될 수 있어야 한다.
- Code On Demand ( Optional) : 자바 애플릿, 자바스크립트 플래시 등 특정 기능을 서버가 클라이언트에 코드를 전달하여 실행할 수 있어야 한다.

### 인터페이스 일관성 
1. 자원 식별 : 웹 기반의 REST에서는 리서스 접근을 URI 사용
2. 메시지를 통한 리소스 조작 : 리소스의 타입을 알려주기 위해서 헤더부분에 content-type를 통해서 어떠한 타입인지를 지정할 수 있다.
3. 자기서술적 메시지 : 요청하는 데이터가 어떻게 처리되어져야 하는지 충분한 데이터를 포함할 수 있어야 한다. ( HTML Method와 Header의 정보로 이를 표현 가능)
4. 애플리케이션 상태에 대한 엔진으로서 하이퍼미디어 : REST API를 개발할 때에도 단순히 클라이언트 요청에 대한 데이터만 내리는 것이 아닌 관련된 리소스에 대한 링크 정보까지 같이 포함되어야 한다.

   
<b>=>  이러한 조건을 잘 같춘 경우 REST FUl 이라고 하며 REST API라고 부른다.</b>

<br>

## URI 설계 방법
1. URI : 인터넷에서 특정 자원을 나타내는 주소값, 해당 값은 유일하다.
2. URL : 인터넷 상에서의 자원, 특정 파일이 어디에 위치하는지 식별하는 주소 (URI의 하위 개념)
3. URI 설계 원칠 ( RFC-3986 )
   - 슬래프 구분자는 계층 관계를 나타내는 데 사용
   - 마지막 문자로 /는 포함하지 않는다
   - 하이픈(-) 은 URI 가독성을 높이는데 사용
   - 밑줄(_)은 사용하지 않는다.
   - URI 경로에는 소문자가 적합하다
   - 파일 확장자는 URI에 포함하지 않는다
   - 프로그래밍 언어에 의존적인 확장자를 사용하지 않는다
   - 구현에 의존적인 경로를 사용하지 않는다. 
   - 세션ID를 포함하지 않는다
   - 프로그래밍 언어의 Method를 이용하지 않는다
   - 명사에 단수형보다는 복수형을 사용해야 한다 (컬렉션에 대한 표현은 복수로 사용)
   - 컨트롤러 이름으로는 동사나 동사구를 사용한다
   - 경로 부분 중 변하는 부분은 유일한 값으로 대체한다
   - CRUD 기능을 나타내는 것은 URI에 사용하지 않는다
   - URI Query Parameter 디자인  
     : 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있다  
     : 컬렉션 결과를 페이지로 구분하여 나타내는 데 사용한다
   - API에 있어서 서브 도메인은 일관성 있게 사용해야 한다
   - 클라이언트 개발자 포탈 서브 도메인은 일관성 있게 만든다  
     
<br>

## HTTP

1. HTTP  
     : RFC 2616에서 규정된 Web에서 데이터를 주고 받는 프로토콜  
     : TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web 기반의 프로토콜  
     : 메시지를 주고 받는 형태의 통신 방식
    
     <image src="https://github.com/Seoin-A/TestKotlinSpring/assets/129828463/947f3598-b623-4d81-ba57-710233d78490" width="50%" hight="50%"></image>
     
2. HTTP Method

   <image src="https://github.com/Seoin-A/TestKotlinSpring/assets/129828463/a22fe736-6e5a-4399-b626-631537cd7ac9" width ="70%" hight = "50^"></image>

3. HTTP Status Code : 응답의 상태를 나타내는 코드 
   - 1XX : 처리중 -> 처리가 계속 되고 있는 상태, 쿨라이언트는 요청을 계속 하거나 서버의 지시에 따라서 재요청
   - 2XX : 성공 -> 요청의 성공
   - 3XX : 리다이렉트 -> 다른 리소스로 리다이렉트, 해당 코드를 받았을 때는 Response의 새로운 주소로 다시 요청
   - 4XX : 클라이언트 에러 -> 클라이언트의 요청에 에러가 있는 상태, 재전송 하여도 에러가 해결되지 않음
   - 5XX : 서버 에러 -> 서버 처리 중 에러가 발생한 상태, 재전송시 에러가 해결되었을 수 있음

   ***자주 사용되는 코드***
     
     <image src ="https://github.com/Seoin-A/TestKotlinSpring/assets/129828463/bbf7d7ef-d695-4cf1-a969-4cbc5448db77" width ="50%" hight ="50%"></image>

  

# API


### GET


1. GetMapping 
   - @RequestMapping(method =[RequestMethod.GET] , path=[ ]   
     - requestMapping은 제약없이 get, post, put, delete 동작 가능   
     - 따라서 method와 path로 제약을 줄 수 있음
   
   - @GetMapping( )   
     - Get만 동작   
     - @GetMappint(path=["/abc" , "/def" ]) 와 같이 배열로 만들면 여러 개의 주소 할당 가능

2. pathVariable
   - url path와 pathVariable 변수 이름을 동일하게 할 경우
      ```kotlin
      @GetMapping("/get-mapping/path-variable/{name}/{age}")
      fun pathVariable(@PathVariable name : String, @PathVariable age : Int){}
      ```
   - url path와 pathVariable 변수 이름을 다르게 할 경우
      ```kotlin
      @GetMapping("/get-mapping/path-variable/{name}/{age}")
      fun pathVariable(@PathVariable(value= "name") lastName : String, @PathVariable(name = "age") lasgAge : Int){}
      // value 나 name으로 변수명을 지정해준다
      ```
3. 쿼리 파라미터 사용
   - url의 쿼리를 사용할 경우
     ```kotlin
      @GetMapping("/get-mapping/query-param") // ?name=seoin&age=27
      fun queryParam(@RequestParam(name = "name") name: String,@RequestParam(value = "age") age : Int ) : String{}
      ```
   - 객체로 쿼리를 받을 경우
      ```kotlin
      @GetMapping("/get-mapping/query-param/object")
        fun queryParamObject(userRequest: UserRequest): UserRequest {}
  
      data class UserRequest (
          var name: String?=null,
          var age:Int?=null,
          var email:String?=null,
          var address:String?=null )
      ```
   - Map으로 쿼리를 받을 경우
      ```kotlin
      @GetMapping("/get-mapping/query-param/map")
      fun queryParamMap(@RequestParam map : Map<String,Any>): Map<String, Any> {}
      ```
<br>
<br>

### POST
1. PostMapping 
    - RequestMapping(method = [RequestMethod], path = ["/request-mapping"])   
        - requestMapping은 제약없이 get, post, put, delete 동작 가능   
        - 따라서 method와 path로 제약을 줄 수 있음   

    <br>
   
   - @PostMapping( )
     - Post만 동작
     - @PostMappint(path=["/abc" , "/def" ]) 와 같이 배열로 만들면 여러 개의 주소 할당 가능


2. request body로 Data 받기 (Object mapper)
    ```kotlin
    @PostMapping("post-mapping/object)
    fun postMappingObject(@RequestBody userRequest : UserRequest): UserRequest {
        // json -> object로 바뀌어서 들어옴
        println(userRequest)
        
        // object -> json 바뀌어서 return
        return userRequest
   } 
    ```
<br><br>
 
### PUT

1. PutMapping
    - @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    - @PutMapping()   

<br>

2. Request Body로 Data 넣기
    ```kotlin
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        return userRequest
    }
    ```
  
<br>

3. Request에 대한 Response 생성 및 전송
   ```kotlin
    @PutMapping("/put-mapping/ex")
    fun putMappingEx(@RequestBody userRequest: UserRequest) : UserResponse {
    // 0. userResponse
    return UserResponse().apply {
    
    // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {

    // 2. description
            this.description = "~~~~~~~~~"

        }.apply {

    // 3. user mutalbe list
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@google.com"
                this.phoneNumber = "010-1111-aaaa"
                this.address = "a address"
            })

            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 10
                this.email = "a@google.com"
                this.phoneNumber = "010-1111-bbb"
                this.address = "b address"
            })

            this.user = userList
        }
    }
   ```
    
<br><br>


### DELETE   


   - Request Param
   ```kotlin
    @DeleteMapping(path=["/delete-mapping"])
          fun deleteMapping(
                  @RequestParam(value = "name") _name : String,
                  @RequestParam(name = "age") _age : Int
          ): String {
              println(_name)
              println(_age)
              return _name+" "+_age
          }
   ```
   - Path Variable

    ```kotlin
     @DeleteMapping("/delete-mapping/name/{name}/age/{age}") // path variable은 대괄호로 묶어준다
     fun deleteMappingPath(
             @PathVariable(value = "name") _name: String,
             @PathVariable(name = "age") _age: Int
          ): String {
        println(_name)
        println(_age)
        return _name+" "+_age
     }
     ```

<br><br>
      
      

# 최종 정리
## 공통
- @RestController : RestAPI 설정
- @RequestMapping : resource 설정 (method로 구분 가능)
     
## Get
- @GetMapping : Get Resouce 설정
- @RequestParam : URL Query Param Parsing
- @PathVariable : URL Path Variable Parsing
- Object : Query Param Object로 Parsing
- Map : Query Param Map으로 Parsing

## Post
- @PostMapping : Post Resource 설정 
- @RequestBody : Request Body 부분 Parsing
- @PathVariable : URL Path Variable Parsing
- @JsonProperty : json naming
- @JsonNaming : class json naming

## Put
- @PutMapping : Put Resource 설정
- @RequestBody : Request Body 부분 Parsing
- @PathVariable : URL Path VAriable Parsing

## Delete
- @DeleteMapping : Delete Resource 설정
- @RequestParam : URL Query Param Parsing
- @PathVariable : URL Path Variable Parsing
- Object : Query Param Object 로 Parsing




# Rest API 응답 처리





   
  
  
  
