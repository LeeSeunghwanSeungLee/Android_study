# Android_study

-------------------------
 1. 안드로이드 - Hello World !! 
 Date : 2020-11-25
```
###KotlinX 해결방법
 bulild.gradle (project) 와 build.gradle(Module) 에 kotlinX plugin을 추가하면 된다.
 역할은 javascript로 따지면 id를 직접 가저오는 바닐라 js의 차이와 React,Vue,Jquery 등 과 같이 DOM의 id를 단순하게 가져와서 가시적으로 개발에 도움이 주는 차이이다.
```

-------------------------
 2. 안드로이드 spinner && RecyclerView && Fragment 실슴
 Date : 2020-11-30
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
 3. MVVM 구조 패턴 공부
 Date : 2020-12-03
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
-------------------
4. MVVM 실습
Date : 2020-12-03
Title : 전화번호부 어플 제작 연습 // DB 연결은 전혀 없음 // Room으로 내부 저장소를 이용함
'''
- Contact.kt : 데이터 클래스 
    1. asp.net으로 따지면 App.code 와 같다
    2. PK 인지.. Default 값은 무엇인지 등 설정을 주석을 통해 선정함
    3. Entity(~테이블) 을 만드는 것이라 생각하면 된다

- ContactDao.kt : Data Access Class
    1. SQL을 작성하기 위한 인터페이스라고 생각하면 된다
    2. Query, Insert, Update, Delete 등의 어노테이션을 제공함
    3. insert와 Update 에서는 onConflict 속성을 지정할 수 있다고 함
    4. Livedata는 생명주기를 알고, 액티비티가 Start or Resume 되었을때 observer 객체에게 변화를 알려주고 onChanged 메소드가 실행되게 해준다

- ContactDataBase.kt : 실질적으로 데이터베이스 인스턴스를 생성한 클래스로 RoomDatabase클래스를 상속
    1. 클래스 이름 위에 @Database 어노테이션을 이용해 entity 정의 및 SQLite 버전 지정함
    2. INSTANCE 가 실제로 Room Database에 저장하는, 즉 인스턴스화 하는 작업이다
    3. 이것을 아래 Repository에서 호출해서 사용할 것임

-  ContactRepository.kr : 리포지토리
    1. Database // Dao // Contacts 를 각각 초기화해준다
    2. ViewModel에서 DB에 접근을 요청할 때 수행하는 함수 getAll // insert // delete 를 생성
    3. 위에 Rest와 관련된 것은 Dao.insert or Dao.delete를 사용하면 됨
    4. 참고로 메인스레드로 Room DB에 접근하려고 하면 크래쉬가 발생한다고 한다..따라서 별도의 스레드를 이용하는 것을 추천한다

-   ContactViewModel : 뷰모델
    1. AndroidViewModel(application) 클래스를 상속받는다
    2. 리포지토리와 거의 유사하다. Rest함수를 이용하기 위해 private val repository // Room 의 값들을 가져오기 위한 repository 를 생성한다


- MainActivity.kt
    1. ContactViewModel을 인스턴스화한다
    2. 인스턴스화 한 것을 관찰한다




    --------------------------
    5. 세부 복습 
    Date : 20-12-09
    Title : Room Data base 와 리스트 만들기

    - 리스트 뷰 만들기
      1. 리스트 뷰의 5가지 요소들..
        * 데이터 : 리스트 뷰를 보여줄 일관적인 규칙을 가진 데이터, 보통     
          Repository && DB 와 연동하기도 한다
        * 스크롤 영역 : 리스트들이 많아질 것을 대비
        * 뷰 홀더 : 데이터가 반복 적용될 뷰 ( 1개를 만들어 놓고 데이터마다 
          적용)
        * 어댑터 : 데이터를 컨트롤 하는 역할
        * 레이아웃 매니저 : 리스트 뷰의 레이아웃을 변경하는 것을 담당한다

      2. 데이터 클래스를 만든다 - App_Code와 동일
      3. MainActivity 에 (2) 에서 만든 클래스로 임시 List<Contacts> = listof 와 같이 샘플 데이터를 만든다
      4. 리스트 뷰 레이아웃을 만든다
      5. ViewHolder 를 담당하는 xml 과 클래스를 만든다 - 바인딩 해주는 역할
      6. 자세한 내용 ref : https://dalgonakit.tistory.com/138?category=878274


    


    



