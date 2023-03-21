<h1> Автоматизации тестирования для онлайн-кинотеатра <a href="http://lampa.mx/">Lampa</a></h1>

<h3>Содержание:</h3>

<ul>
<li><a href="#tools">Технологии и инструменты</a></li>
<li><a href="#checks">Перечень проверок</a></li>
<li><a href="#launch">Запуск тестов</a></li>
<li><a href="#report">Allure-отчет</a></li>
<li><a href="#testops">Интеграция с Allure TestOps</a></li>
<li><a href="#jira">Интеграция с Jira</a></li>
<li><a href="#telegram">Интеграция с Telegram</a></li>
<li><a href="#video">Видео пример прохождения тестов</a></li>
</ul>

<h2 name="tools">:memo:Технологии и инструменты:memo:</h2>

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

<h2 name="checks">:memo:Перечень проверок:memo:</h2>
<h3>Web</h3>

- [x] User can access to main page after language selection
- [x] It Is Possible To Open Releases page
- [x] It Is Possible to search data
- [x] Checking titles for pages
- [x] Check Title

<h3>Mobile</h3>

- [x] English language choosing
- [x] Check broken links
- [x] Check that user is not logged in

<h3>Api</h3>

- [x] It is possible to log in
- [x] Users email matches entered credentials
- [x] User has profile with name 'Common' attached

<h3>Ручные тесты</h3>

- [x] Checking available languages

<h2 name="launch">:memo:Запуск тестов:memo:</h2>

<pre>
gradle clean ${env} -Denv=${env}
</pre>

Доступные значения переменной ${env}

<pre>
web_local - локальный запуск Web тестов с тегом "web"
web_remote - удаленный запуск Web тестов с тегом "web"
mobile_local - локальный запуск Mobile тестов с тегом "mobile"
mobile_bs - удаленный запуск Mobile тестов с тегом "mobile" в Browserstack
api - запуск Api тестов с тегом "api"
</pre>
<pre>
Параметры каждой переменной ${env} содержатся в соответствующем файле .properties, расположенном в ресурсах
</pre>

<h3>Проект в Jenkins:</h3>
<ol>
<li>Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/001-sergeyZhiharev-final/">проект</a> в Jenkins</li>
<li>Выбрать пункт "Собрать с параметрами"</li>
<li>В случае необходимости изменить параметр запуска, выбрав соответствующее значение из выпадающего списка</li>
<li>Нажать "Собрать"</li>
<li>Результат запуска сборки можно посмотреть в отчёте Allure</li>
</ol>

<h2 name="report">:memo:Allure-отчет:memo:</h2>

<h3>Главное окно</h3>

<p align="center">
<img src="media/allure_report/report1.png">
</p>

<h3>Тесты Web</h3>

<p align="center">
<img src="media/allure_report/report2.png">
</p>

<h3>Тесты Mobile</h3>

<p align="center">
<img src="media/allure_report/report3.png">
</p>

<h3>Тесты Api</h3>

<p align="center">
<img src="media/allure_report/report4.png">
</p>

<h3>Графики</h3>

<p align="center">
<img src="media/allure_report/report5.png">
</p>


<h2 name="testops">:memo:Интеграция с Allure TestOps:memo:</h2>
<h3>Список всех тест-кейсов</h3>
<p align="center">
<img src="media/testops/testops.png">
</p>

<h3>Dashboard</h3>
<p align="center">
<img src="media/testops/testops2.png">
</p>

<h2 name="jira">:memo:Интеграция с Jira:memo:</h2>
<p align="center">
<img src="media/jira/jira.png" >
</p>

<h2 name="telegram">:memo:Интеграция с Telegram:memo:</h2>
<p align="center">
<img src="media/telegram/telegram.png" >
</p>

<h2 name="video">:memo:Видео пример прохождения тестов:memo:</h2>
<h3>Web</h3>
<p align="center">
<img src="media/video1.gif">
</p>
<h3>Mobile</h3>
<p align="center">
<img src="media/video2.gif">
</p>