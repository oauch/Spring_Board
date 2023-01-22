# Spring_Board

## 2023-01-18
📍 Spring 프로젝트 생성 </br> 
📍 Vo Package 생성 </br>
📍 Vo 내용추가 </br>
📍 프로젝트와 Maria DB 연동</br></br>

## 2023-01-19
📍 Dao, Service Package 생성 </br> 
📍 Dao 내용추가 </br>
📍 Service 내용추가 </br>
📍 DB에 추가한 내용 게시판에 보여주기 </br></br>

## 2023-01-20
📍 게시글 작성 </br>
📍 게시글 조회 </br>
📍 게시글 수정 </br>
📍 게시글 삭제 </br>
📍 메뉴바 추가 </br></br>


> @ReqeustMapping이란?
>> 특정 URL을 요청으로 보내면 Controller에서 어떤 방식으로 처리할지 정의한다. </br>
이때 들어온 요청을 ***특정 메서드와 매핑***하기 위해 사용하는 어노테이션 

</br></br>


```
@RequestMapping(value = "/list", method = RequestMethod.GET)
```

> value = 요청 받을 URL </br>
method = 어떤 요청을 받을지 정의 

</br></br>


그럼 GET, POST, PUT, DELETE를 사용하려면 어떤식으로 사용할까? </br>

```
@RestController
public class BoardController {

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String helloGet(...) {
        ...
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public String helloPost(...) {
        ...
    }

   @RequestMapping(value = "/board", method = RequestMethod.PUT)
    public String helloPut(...) {
        ...
    }

    @RequestMapping(value = "/board", method = RequestMethod.DELETE)
    public String helloDelete(...) {
        ...
    }
}
```

</br>
이런식으로 사용하면된다.
</br>

</br></br>

> @RequestParam이란?
> > Parameter를 이용하여 데이터를 가져오는 어노테이션이다.

</br>

```
@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		
	}
```

다음과 같이 사용하면 파라미터 bno의 데이터를 가져오겠다는 의미이다. </br></br>

## 2023-01-21
📍 페이징 구현중(현재 페이징 확인을 위해 확인페이지에 들어가면 500 오류 발생) </br></br>


## 2023-01-22
📍 전일에 발생한 500 오류 해결 완료</br></br> 
![image](https://user-images.githubusercontent.com/49686619/213909937-d0572c22-9e2d-40db-b577-64e8ef186499.png) </br>
> 이 부분을 id="listpage"로 적어서 500 오류가 발생했던것이다. </br>




# 오류 모음
1. **405 에러** = 현재 페이지는 있지만, 현재 메소드 형식을 받을 수 없다.
2. **404 에러** = 파일 자체가 없거나, 경로를 지정해주지 않으면 발생한다.
3. **500 에러** = sql을 작성하는 xml파일을 잘 보면 된다. </br>내가 500 에러가 떴던 이유는 다음과 같은 문법적(?) 실수도 있었고 </br> 테이블명이나 컬럼 명을 잘못 입력했을 때 나타났다.

```
# 틀린답
<select id="view" parameteryType="com.board.domain.BoardVo">

# 정답
<select id="view" resultType="com.board.domain.BoardVo">
```
