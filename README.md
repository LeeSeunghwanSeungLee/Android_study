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
