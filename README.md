# Android_study

-------------------------
> 1. 안드로이드 - Hello World !! 
> > Date : 2020-11-25
```
###KotlinX 해결방법
 bulild.gradle (project) 와 build.gradle(Module) 에 kotlinX plugin을 추가하면 된다.
 역할은 javascript로 따지면 id를 직접 가저오는 바닐라 js의 차이와 React,Vue,Jquery 등 과 같이 DOM의 id를 단순하게 가져와서 가시적으로 개발에 도움이 주는 차이이다.
```

-------------------------
> 2. 안드로이드 spinner && RecyclerView && Fragment 실슴
> > Date : 2020-11-30
```
### spinner ###
- 여러개 값 중에서 하나를 선택할 수 있게 해주는 편리한 위젯
- 스피너를 .xml 에 추가한다 <개발자로서 code 버전에 능숙해질 필요가 있다>
- list로 원하는 항목들을 먼저 변수로 선언해준다
- 어댑터 설정 : spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner~ , 선언리스트)
- 아이템 선택 리스터 함수 : spinner.onItemSelectedListner = object : AdapterView.onItemSelectedLister { callback함수}
- 이외의 button 들과 융합해서 함수를 구현할 수 있다.
- 스피너는 어댑터가 필요하다. 현재 스피너에서 선택되어 있는 값을 가져오고 이것을 intent에 담아서 새로운 액티비티로 수정하는 등 확장할 수 있는 여지가 많다
```

```
### Recycler View ###
- listView는 모든 데이터에 대한 View를 만들고 사라지고 추가될떄마다 리소스를 새로 불러와야한다
- 스크롤이 생성되는 경우에는 이 문제는 많은 메모리와 저장 공간을 사용하게 된다
- RecyclerView는 간단한 ListView의 단점을 보완하기 위해 만들어졌다.
1. Gradle에 implement 추가(다운도 필요)
2. 데이터 클래스 정의 (ASP.NET의 App.code와 같이)
3. 레이아웃에 RecyclerView 위젯 추가
4. item 생성
5. 어댑터 생성 <뷰홀더 + xml 과 연동하는 클래스들..>
6. 어댑터 설정 <MainActivity.kt 에서 5에서 설정한 어댑터 클래스 선언 및 연결>
```
```
### Fragment 실습 ###
- 테블릿 pc 또는 스와이핑이 가능한 뷰를 구성하기 위해 사용하는 레이아웃
- 화면 분할해서 복잡도를 낮춤과 동시에 다른 Activity 재사용도 가능하다!
1. Fragment를 위한 Layout을 작성하고, Main_activity_layout에도 프라그먼트 레이아웃을 추가한다.
2. Fragment 클래스를 생성한다. 
3. MainActivity.kt 에서 Fragment를 호출한다 => 호출과정에서는 트랜잭션을 이용한다 

```
------------------------------
> 3. MVVM 구조 패턴 공부
> > Date : 2020-12-03
'''
### mvvn 패턴이란
- 안드로이드 초보 개발자는 대부분 액티비티에 거의 모든 코드를 집어넣음
- 비 구조적이고 유지보수가 어려워지는 단점이 존재함
- 이를 위한 구조가 MVVM 패턴
- View ~ ViewModel ~ Model 을 이용해 각각 역할을 분리해서 가독성과 재사용성을 높인 디자인 패턴
- MVC의 경우 Controller 가 View와 Model 을 동시에 관리하기 떄문에 프로젝트가 커질수록 개발이    
  난잡해질 수 있음
- MVVM는 아래와 같음
    1. View는 Adapter를 통해 ViewModel을 감지함, 변화가 나타나면 바로 콜백함수를 보여줘서 데이터를 수정한다
    2. ViewModel은 데이터 갱신을 Model에게 요청하고, 갱신함
- 장점
    1. 뷰가 데이터를 실시간으로 관찰!
        * LiveData, 즉 Observable 패턴을 이용하기 떄문에 데이터베이스를 관찰하고 자동으로  View<UI> 를 관찰
        * 직접 View를 바꾸어주는 번거로움이 없으며, DB와 불일치할 확률이 줄어든다.
    2. 생명주기로부터 안전 + 메모리 누수를 방지함
        * 뷰모델이 모델을 참조하기 떄문에 액티비티<View> 의 생명 주기를 따르지 않음
        * 액티비티가 파괴된 후 재구성되어도 뷰모델이 데이터를 홀드하고 있기 때문에 영향을 안 받음
        * 뷰가 활성화되어있을 경우에만 Adapter를 통해 반영되기 때문에 불필요한 메모리 사용 줄임
    3. 열할 분리 <Modul>
        * 역할별로 정리가 깔끔하고, Unit Test 가 한결 용이해진다는 장점이 있음
- 아키텍쳐 컴포넌트
    1. VIEW
        * UI를 담당하는 액티비티나 프래그먼트를 말하며, 데이터 변화를 감지하기 위한 옵저버가 존재
    2. ViewModel
        * UI를 위한 데이터를 가지고 있으며, Configuration<구성> 이 변경되어도 살아남음
        * AsyncTask 는 액티비티나 프래그먼트 생명 주기에서도 자유로울 수 없지만, 뷰모델은 여전히 가지고 있음
    3. LiveData
        * 관찰이 가능한 홀더 클래스
        * 뷰에서 뷰모델의 라이브데이터를 관찰하게되면 데이터가 변경할때 내부적으로 자동으로 알려줌
        * 액티비티가 화면 위에 활성화 되어 있을 떄만 UI 변경 등의 기능이 작동
        * Destroy 된 상태에서는 동작하지 않고, 이것이 메모리 누수를 방지함
    4. Room
        * SQLite 데이터베이스를 편하게 사용하게 해주는 라이브 클래스
        * 직관적이고 편리하게 DB를 사용할 수 있게 도와줌

'''