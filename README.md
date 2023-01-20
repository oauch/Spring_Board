# Spring_Board

## 2023-01-18
<div align='left'>
📍 Spring 프로젝트 생성 </br> 
📍 Vo Package 생성 </br>
📍 Vo 내용추가 </br>
📍 프로젝트와 Maria DB 연동
</div>
</br>

## 2023-01-19
<div align='left'>
📍 Dao, Service Package 생성 </br> 
📍 Dao 내용추가 </br>
📍 Service 내용추가 </br>
📍 DB에 추가한 내용 게시판에 보여주기 </br>
</div>

## 2023-01-20
📍 게시글 작성 </br>
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
405 에러 = 현재 페이지는 있지만, 현재 메소드 형식을 받을 수 없다

</br></br>

> @RequestParam이란?
> > Parameter를 이용하여 데이터를 가져오는 어노테이션이다.

</br>

```
@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		
	}
```

다음과 같이 사용하면 파라미터 bno의 데이터를 가져오겠다는 의미이다.
